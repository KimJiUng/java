package controller;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dto.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Server implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txtserver.setDisable(true); // �ش� fxid ������
	}
	
    @FXML
    private Button btnserver;

    @FXML
    private TextArea txtserver;

    @FXML
    void server(ActionEvent event) { // ���� ���� ��ư
    	if(btnserver.getText().equals("���� ����")) {
    		serverstart();
    		txtserver.appendText("[[���� �����մϴ�.]]\n");
    		btnserver.setText("���� ����");
    	}
    	else {
    		serverstop();
    		txtserver.appendText("[[���� �����մϴ�.]]\n");
    		btnserver.setText("���� ����");
    	}
    }
    
    // * ������ ����� Ŭ���̾�Ʈ�� �����ϴ� ����Ʈ
    public static Vector<Client> clientlist = new Vector<>();
    		// Vector ����ϴ� ���� : ����ȭo 
    			// ����ȭ : �������� �����尡 �ϳ��� �޼ҵ忡 ������ ��� ��� ���� �������
    // * ��Ƽ�����带 �������ִ� ������Ǯ
    public static ExecutorService threadpool;
    		// ExecutorService : �����带 ���� �������̽�
    // 1. �������� ����
    ServerSocket serverSocket;
    
    // 2. �������� �޼ҵ�
    public void serverstart() {
    	try {
    		// 1. �������� �޸��Ҵ�
        	serverSocket = new ServerSocket();
        	// 2. �������� ���ε�
        	serverSocket.bind(new InetSocketAddress("192.168.17.38",1234));
        	
    	} catch(Exception e) {}
    		// 3. Ŭ���̾�Ʈ�� ��û ��� [��Ƽ������ ����ϴ� ���� : 1.Ŭ���̾�Ʈ���� 2.������ 3.�ޱ� ����ó���ϱ� ���ؼ�]
    	Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						Socket socket = serverSocket.accept(); // 1. ��û �����Ŀ� ������ ������ ����
						clientlist.add(new Client(socket)); // 2. ����� Ŭ���̾�Ʈ(����ȼ���) ���� �Ŀ� ����Ʈ�� Ŭ���̾�Ʈ �߰�
					}	
				} catch(Exception e) {}
				
				
			}
		}; // ��Ƽ������ ���� ��
		// ������Ǯ �޸� �ʱ�ȭ
		threadpool = Executors.newCachedThreadPool();
    	threadpool.submit(runnable);
    }
    
    // 3. �������� �޼ҵ�
    public void serverstop() {
    	try {
    		// 1. ���ӵ� ��� Ŭ���̾�Ʈ���� ���� �ݱ�
        	for(Client client : clientlist) {
        		client.socket.close();
        	}
        	// 2. �������� �ݱ�
        	serverSocket.close();
        	// 3. ������Ǯ �ݱ�
        	threadpool.shutdown();
    	} catch(Exception e) {}
    	
    }
	
}
