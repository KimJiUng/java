package application.Day26;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Day26_server {

	// 통신용 서버 만들기
		// 1. 서버소켓 만들기
			// 서버 : 클라이언트에게 정보나 서비스를 제공해주는 컴퓨터
			// 소켓 : PC간의 통신 종착점
		// 2. 서버소켓 바인딩
			// 서버에 ip주소와 port번호 설정
				// * ip : 통신 인식 번호 [pc를 식별하는 번호]
				// * port : pc내 
						// * port : 3306 번호는 mydql 프로그램으로 연결하는 번호
	public static void main(String[] args) {
		

		try {
			// 1. 서버소켓 만들기
			ServerSocket serverSocket = new ServerSocket();
			// 2. 서버소켓 바인딩
			serverSocket.bind(new InetSocketAddress("192.168.17.38",5000) );
			// 3. 클라이언트의 요청 대기
			while(true) {
				System.out.println("[[서버가 연결 대기중입니다.]]");
				// 4. 요청이 있을경우 수락
				Socket socket = serverSocket.accept(); // 서버소켓.accept() : 요청수락
				// 5. 수락된 소켓의 정보 확인
				InetSocketAddress socketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("[[클라이언트와 연결이 되었습니다. 연결된 클라이언트 정보 : "+socketAddress.getHostName()+" ]]");
				// 6. 클라이언트에게 데이터 수신[받기]
				InputStream inputStream = socket.getInputStream();
				byte[] bytes = new byte[1000];
				inputStream.read(bytes);
				System.out.println("클라이언트가 보낸 메세지 : "+new String(bytes));
				// 7. 클라이언트에게 데이터 송신[보내기]
				Scanner scanner = new Scanner(System.in);
				System.out.println("클라이언트에게 보낼 메세지 : "); String msg = scanner.next();
				OutputStream outputStream = socket.getOutputStream();
				outputStream.write(msg.getBytes());
			}
			
		} catch (IOException e) {}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
