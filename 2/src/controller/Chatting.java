package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import controller.login.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Chatting implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txtmsg.setDisable(true);  // ä���Է�â ������
		txtcontent.setDisable(true); // ä�ù� ������
		btnsend.setDisable(true); // ���۹�ư ������
		txtmsg.setText("ä�ù� ���� �� ��밡���մϴ�.");
		btnconnect.setDisable(true); // �����ư ������
		txtmidlist.setDisable(true); // ����ȸ�� ��� ������
		
	}
	
    @FXML
    private Button btnconnect;

    @FXML
    private TextArea txtcontent;

    @FXML
    private TextField txtmsg;

    @FXML
    private Button btnsend;

    @FXML
    private TableView<?> roomtable;

    @FXML
    private TextField txtroomname;

    @FXML
    private Button btnadd;

    @FXML
    private TextArea txtmidlist;

    @FXML
    private Label lblselect;

    @FXML
    void add(ActionEvent event) { // �� ���� ��ư�� ��������
    	// 1. ��Ʈ�ѿ� �Էµ� �� �̸� ��������
    	// 2. �� ��ü �����
    	// 3. DB ó��
    	// 4. �ش� �� ���� ����

    }

    @FXML
    void msg(ActionEvent event) {
    	String msg = txtmsg.getText()+"\n";
    	send(msg);
    	txtmsg.setText("");
    	txtmsg.requestFocus(); // ������ �� �޼��� �Է�â���� ��Ŀ��(Ŀ��) �̵�
    }

    @FXML
    void roomname(ActionEvent event) {

    }

    // 1. Ŭ���̾�Ʈ ���� ����
    Socket socket;
    
    // 2. Ŭ���̾�Ʈ ���� �޼ҵ�
    public void clientstart() {
    	// ��Ƽ ������
    	Thread thread = new Thread() {
    		@Override
    		public void run() {
    			try {
    				socket = new Socket("192.168.17.38",1234);
    				recive(); // ���Ӱ� ���ÿ� �ޱ� �޼ҵ�� ���ѷ���
    			} catch(Exception e) {}
    		}
    	}; // ��Ƽ������ ���� ��
    	thread.start();		
    }
    
    // 3. Ŭ���̾�Ʈ ���� �޼ҵ�
    public void clientstop() { try{ socket.close(); }catch(Exception e) {} }
    
    // 4. �޼��� �۽� �޼ҵ�
    public void send(String msg) {
    	Thread thread = new Thread() {
    		@Override
    		public void run() {
    			try {
    				OutputStream outputStream = socket.getOutputStream();
    				outputStream.write(msg.getBytes());
    				outputStream.flush(); // ��Ʈ�� �ʱ�ȭ
    			} catch(Exception e) {}
    		}
    	}; // ��Ƽ������ ���� ��
    	thread.start();
    }
    
    // 5. �޼��� ���� �޼ҵ�
    public void recive() {
    	try {
    		while(true) {
    			InputStream inputStream = socket.getInputStream(); // �Է½�Ʈ��
    			byte[] bytes = new byte[1000]; // ����Ʈ�迭����
    			inputStream.read(bytes); // �о����
    			String msg = new String(bytes); // ����Ʈ�迭->���ڿ� ��ȯ
    			txtcontent.appendText(msg); // �Է¹��� ������ ä��â�� �߰��ϱ�
    		}
    	} catch(Exception e) {}
    }    
    @FXML
    void connect(ActionEvent event) {
    	if(btnconnect.getText().equals("ä�ù� ����")) {
    		btnconnect.setText("ä�ù� ����");
    		txtcontent.appendText("---[ä�ù� ����]---\n");
    		clientstart();
    		txtmsg.setText("");
    		txtmsg.setDisable(false);
    		txtcontent.setDisable(false);
    		btnsend.setDisable(false);
    		txtmsg.requestFocus();
    		txtcontent.appendText(Login.member.getMid()+"���� �����ϼ̽��ϴ�.\n");
    	}else {
    		btnconnect.setText("ä�ù� ����");
    		txtcontent.appendText("---[ä�ù� ����]---\n");
    		clientstop();
    		txtmsg.setDisable(true);
    		txtcontent.setDisable(true);
    		btnsend.setDisable(true);
    		txtmsg.setText("ä�ù� ���� �� ��밡���մϴ�.");
    	}
    }

    @FXML
    void send(ActionEvent event) { // ���� ��ư ��������
    	String msg = txtmsg.getText()+"\n";
    	send(msg);
    	txtmsg.setText("");
    	txtmsg.requestFocus(); // ������ �� �޼��� �Է�â���� ��Ŀ��(Ŀ��) �̵�
    	
    }
	
}
