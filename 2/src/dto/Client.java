package dto;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import controller.Server;

public class Client {
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
						for(Client client : Server.clientlist) {
							client.send(msg); // 받은 메세지를 서버에 접속된 클라이언트들에게 보내기
						}
					}
				} catch(Exception e) {}
			}
		}; // 멀티스레드 구현 끝
		
		// 해당 멀티스레드를 스레드풀에 넣어주기
		Server.threadpool.submit(runnable);
		
	}
	
	// 4. 송신 메소드
	public void send(String msg) {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				try{
					OutputStream outputStream =socket.getOutputStream();
					outputStream.write(msg.getBytes() ); 
				} catch(Exception e) {}
				
			}
		}; // 멀티스레드 구현 끝
		Server.threadpool.submit(runnable);
		
	}
	
}
