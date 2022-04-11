package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import controller.login.Login;



public class Server { // fxml 사용하지 않는 클래스 [서버 컨트롤 사용]

/////////////////////////////////////////////////////////////////////
	// 중첩클래스
	public class Client{
		// 서버에 접속된 클라이언트의 클래스
		// 1. 필드 [소켓]
		public Socket socket;
		// 2. 생성자
		public Client(Socket socket) {
			this.socket=socket;
			recive(); // 서버와 연결된 클라이언트 객체가 생성될때
		}
		// 3. 수신 메소드
		public void recive() {
			// 멀티스레드 [Thread 클래스 vs Runnable 인터페이스]
			Runnable runnable = new Runnable() {
				// 인터페이스는 추상메소드가 존재하기 때문에 run 메소드를 필수적으로 구현해야함
				@Override
				public void run() {
					// 계속적으로 메세지 받는 상태
					try {
						while(true) {
							// 1. 입력 스트림
							InputStream inputStream = socket.getInputStream();
							byte[] bytes = new byte[1000];
							inputStream.read(bytes);
							String msg = new String(bytes);
							
							// * 서버가 받은 메세지를 현재 서버에 접속한 모든 클라이언트에게 받은 메세지 보내기
							for(Client client : clientlist) {
								client.send(msg); // 받은 메세지를 서버에 접속된 클라이언트들에게 보내기
							}
						}
					} catch(Exception e) { System.out.println("수신 메소드 오류 : "+ e);}
				}
			}; // 멀티스레드 구현 끝
			
			// 해당 멀티스레드를 스레드풀에 넣어주기
			threadpool.submit(runnable);
		}
		// 4. 송신 메소드
		public void send(String msg) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try{
						OutputStream outputStream =socket.getOutputStream();
						outputStream.write(msg.getBytes() ); 
					} catch(Exception e) {
						serverstop();
						System.out.println("송신 메소드 오류 : "+ e);
						}
				}
			}; // 멀티스레드 구현 끝
			threadpool.submit(runnable);
		}
	} // 중첩클래스 종료
///////////////////////////////////////////////////////////////////////
	
	

    
    // * 서버에 연결된 클라이언트를 저장하는 리스트
    public Vector<Client> clientlist = new Vector<>();
    		// Vector 사용하는 이유 : 동기화o 
    			// 동기화 : 여러개의 스레드가 하나의 메소드에 접근할 경우 대기 상태 만들어줌
    // * 멀티스레드를 관리해주는 스레드풀
    public ExecutorService threadpool;
    		// ExecutorService : 스레드를 구현 인터페이스
    // 1. 서버소켓 선언
    ServerSocket serverSocket;
    
    // 2. 서버실행 메소드
    public void serverstart(String ip, int port) { // 인수로 ip와 port 받아서 받은 ip와 port 로 서버소켓 바인딩(생성)
    	try {
    		// 1. 서버소켓 메모리할당
        	serverSocket = new ServerSocket();
        	// 2. 서버소켓 바인딩
        	serverSocket.bind(new InetSocketAddress(ip,port));
        	
    	} catch(Exception e) {serverstop(); System.out.println("서버 실행 메소드 오류 : "+ e);}
    		// 3. 클라이언트의 요청 대기 [멀티스레드 사용하는 이유 : 1.클라이언트연결 2.보내기 3.받기 동시처리하기 위해서]
    	Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						Socket socket = serverSocket.accept(); // 1. 요청 수락후에 수락된 소켓을 저장
						clientlist.add(new Client(socket)); // 2. 연결될 클라이언트(연결된소켓) 생성 후에 리스트에 클라이언트 추가
					}	
				} catch(Exception e) {serverstop(); System.out.println("서버가 클라이언트 연결 오류 : "+ e);}
				
				
			}
		}; // 멀티스레드 구현 끝
		// 스레드풀 메모리 초기화
		threadpool = Executors.newCachedThreadPool();
    	threadpool.submit(runnable);
    }
    
    // 3. 서버종료 메소드
    public void serverstop() {
    	try {
    		// 1. 접속된 모든 클라이언트들의 소켓 닫기
        	for(Client client : clientlist) {
        		client.socket.close();
        	}
        	// 2. 서버소켓 닫기
        	serverSocket.close();
        	// 3. 스레드풀 닫기
        	threadpool.shutdown();
    	} catch(Exception e) { System.out.println("서버 종료 메소드 오류 : "+ e);}
    	
    }
	
}
