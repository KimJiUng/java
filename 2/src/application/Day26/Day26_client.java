package application.Day26;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Day26_client {

	public static void main(String[] args) {
		
		// 1. 소켓 만들기
		Socket socket = new Socket();
		

		while(true) {
			try {
				// 2. 서버소켓으로 연결하기 [ 서버소켓의 ip와 port번호 넣어주기 ]
				socket.connect(new InetSocketAddress("192.168.17.38",1234));
				System.out.println("[[서버와 연결 성공]]");
				
				Scanner scanner = new Scanner(System.in);
				// 3. 서버에게 데이터 송신하기[보내기]
					// 1. 데이터 입력받기
				System.out.println("서버에게 보낼 메세지 : "); String msg = scanner.next();
					// 2. 소켓의 출력 스트림(통신단위:바이트) 가져오기
				OutputStream outputStream = socket.getOutputStream();
					// 3. 내보내기 [ 문자열 -> 바이트열 ]
				outputStream.write(msg.getBytes());
				// 4. 서버에게 데이터 수신[받기]
				InputStream inputStream = socket.getInputStream();
				byte[] bytes = new byte[1000];
				inputStream.read(bytes);
				System.out.println("서버가 보낸 메세지 : "+new String(bytes));
						
				
			} catch (IOException e) {}
		}
		
	}
	
}
