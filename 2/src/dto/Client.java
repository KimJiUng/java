package dto;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import controller.Server;

public class Client {
	// ������ ���ӵ� Ŭ���̾�Ʈ�� Ŭ����
	
	// 1. �ʵ� [����]
	public Socket socket;
	
	// 2. ������
	public Client(Socket socket) {
		this.socket=socket;
		recive(); // ������ ����� Ŭ���̾�Ʈ ��ü�� �����ɶ�
	}
	
	// 3. ���� �޼ҵ�
	public void recive() {
		// ��Ƽ������ [Thread Ŭ���� vs Runnable �������̽�]
		Runnable runnable = new Runnable() {
			// �������̽��� �߻�޼ҵ尡 �����ϱ� ������ run �޼ҵ带 �ʼ������� �����ؾ���
			@Override
			public void run() {
				// ��������� �޼��� �޴� ����
				try {
					while(true) {
						// 1. �Է� ��Ʈ��
						InputStream inputStream = socket.getInputStream();
						byte[] bytes = new byte[1000];
						inputStream.read(bytes);
						String msg = new String(bytes);
						// * ������ ���� �޼����� ���� ������ ������ ��� Ŭ���̾�Ʈ���� ���� �޼��� ������
						for(Client client : Server.clientlist) {
							client.send(msg); // ���� �޼����� ������ ���ӵ� Ŭ���̾�Ʈ�鿡�� ������
						}
					}
				} catch(Exception e) {}
			}
		}; // ��Ƽ������ ���� ��
		
		// �ش� ��Ƽ�����带 ������Ǯ�� �־��ֱ�
		Server.threadpool.submit(runnable);
		
	}
	
	// 4. �۽� �޼ҵ�
	public void send(String msg) {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				try{
					OutputStream outputStream =socket.getOutputStream();
					outputStream.write(msg.getBytes() ); 
				} catch(Exception e) {}
				
			}
		}; // ��Ƽ������ ���� ��
		Server.threadpool.submit(runnable);
		
	}
	
}
