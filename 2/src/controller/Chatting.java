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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Chatting implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txtmsg.setEditable(false);
		txtcontent.setDisable(true);
		btnsend.setDisable(true);
		txtmsg.setText("채팅방 입장 후 사용가능합니다.");
	}
	
    @FXML
    private Button btnconnect;

    @FXML
    private TextArea txtcontent;

    @FXML
    private Button btnsend;

    @FXML
    private TextField txtmsg;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtip;

    @FXML
    private TextField txtport;

    // 1. 클라이언트 소켓 선언
    Socket socket;
    
    // 2. 클라이언트 실행 메소드
    public void clientstart() {
    	// 멀티 스레드
    	Thread thread = new Thread() {
    		@Override
    		public void run() {
    			try {
    				socket = new Socket("192.168.17.38",1234);
    				recive(); // 접속과 동시에 받기 메소드는 무한루프
    			} catch(Exception e) {}
    		}
    	}; // 멀티스레드 구현 끝
    	thread.start();		
    }
    
    // 3. 클라이언트 종료 메소드
    public void clientstop() { try{ socket.close(); }catch(Exception e) {} }
    
    // 4. 메세지 송신 메소드
    public void send(String msg) {
    	Thread thread = new Thread() {
    		@Override
    		public void run() {
    			try {
    				OutputStream outputStream = socket.getOutputStream();
    				outputStream.write(msg.getBytes());
    				outputStream.flush(); // 스트림 초기화
    			} catch(Exception e) {}
    		}
    	}; // 멀티스레드 구현 끝
    	thread.start();
    }
    
    // 5. 메세지 수신 메소드
    public void recive() {
    	try {
    		while(true) {
    			InputStream inputStream = socket.getInputStream(); // 입력스트림
    			byte[] bytes = new byte[1000]; // 바이트배열선언
    			inputStream.read(bytes); // 읽어오기
    			String msg = new String(bytes); // 바이트배열->문자열 변환
    			txtcontent.appendText(msg); // 입력받은 내용을 채팅창에 추가하기
    		}
    	} catch(Exception e) {}
    }    
    @FXML
    void connect(ActionEvent event) {
    	if(btnconnect.getText().equals("채팅방 입장")) {
    		btnconnect.setText("채팅방 퇴장");
    		txtcontent.appendText("---[채팅방 입장]---\n");
    		clientstart();
    		txtmsg.setText("");
    		txtmsg.setEditable(true);
    		txtcontent.setDisable(false);
    		btnsend.setDisable(false);
    		txtmsg.requestFocus();
    		txtcontent.appendText(Login.member.getMid()+"님이 접속하셨습니다.\n");
    	}else {
    		btnconnect.setText("채팅방 입장");
    		txtcontent.appendText("---[채팅방 퇴장]---\n");
    		clientstop();
    		txtmsg.setEditable(false);
    		txtcontent.setDisable(true);
    		btnsend.setDisable(true);
    		txtmsg.setText("채팅방 입장 후 사용가능합니다.");
    	}
    }

    @FXML
    void send(ActionEvent event) { // 전송 버튼 눌렀을때
    	String msg = txtmsg.getText()+"\n";
    	send(msg);
    	txtmsg.setText("");
    	txtmsg.requestFocus(); // 보내기 후 메세지 입력창으로 포커스(커서) 이동
    	
    }
	
}
