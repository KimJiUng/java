package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.RoomDao;
import dto.Room;
import dto.Roomlive;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class Chatting implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txtmsg.setDisable(true);  // 채팅입력창 사용금지
		txtcontent.setDisable(true); // 채팅방 사용금지
		btnsend.setDisable(true); // 전송버튼 사용금지
		txtmsg.setText("채팅방 입장 후 사용가능합니다.");
		btnconnect.setDisable(true); // 입장버튼 사용금지
		txtmidlist.setDisable(true); // 접속회원 목록 사용금지
		show();
	}
	
	public static Room room;
	
    @FXML
    private Button btnconnect;

    @FXML
    private TextArea txtcontent;

    @FXML
    private TextField txtmsg;

    @FXML
    private Button btnsend;

    @FXML
    private TableView<Room> roomtable;

    @FXML
    private TextField txtroomname;

    @FXML
    private Button btnadd;

    @FXML
    private TextArea txtmidlist;

    @FXML
    private Label lblselect;

    // 서버소켓 생성 [ 모든 메소드에서 사용 ]
    public Server server;
    
    @FXML
    void add(ActionEvent event) { // 방 개설 버튼을 눌렀을때
    	Alert alert = new Alert(AlertType.INFORMATION);
    	// 1. 컨트롤에 입력된 방 이름 가져오기
    	String roomname = txtroomname.getText();
    	if(roomname.length()<4) {
    		alert.setHeaderText("방 개설 실패");
    		alert.setContentText("방 이름은 4~20글자 사이여야 합니다.");
    		alert.showAndWait();
    		return;
    	}
    	// 2. 방 객체 만들기
    	Room room = new Room(0, roomname, "127.0.0.1", 0);
    	// 3. DB 처리
    	boolean result = RoomDao.roomDao.roomadd(room);
    	if(result) {
    		// 4. 해당 방 서버 실행
        	server = new Server(); // 메모리 할당
        	int result2 = RoomDao.roomDao.getroomnum();
        	// 서버 실행 [인수로 ip,port번호 넘기기]
        	server.serverstart(room.getRoomip(), result2);
        	
        	alert.setHeaderText("방 생성이 완료되었습니다. 방 번호 : "+result2);
        	alert.showAndWait();
        	txtroomname.setText("");
        	Home.instance.loadpage("/view/chatting.fxml");
    	}else {
    		System.out.println("add DB 오류");
    	}
    	

    }



    @FXML
    void roomname(ActionEvent event) {

    }

    // 1. 클라이언트 소켓 선언
    Socket socket;
    
   
    
    // 2. 클라이언트 실행 메소드
    public void clientstart(String ip, int port) {
    	// 멀티 스레드
    	Thread thread = new Thread() {
    		@Override
    		public void run() {
    			try {
    				socket = new Socket(ip,port);
    				send(Login.member.getMid()+"님이 입장하셨습니다.\n");
    				recive(); // 접속과 동시에 받기 메소드는 무한루프
    			} catch(Exception e) { System.out.println("클라이언트 실행 오류 : "+e);}
    		}
    	}; // 멀티스레드 구현 끝
    	thread.start();		
    }
    
    // 3. 클라이언트 종료 메소드
    public void clientstop() {
    	try{
    		socket.close(); 
    	}catch(Exception e) { System.out.println("클라이언트 종료 오류 : "+e);} }
    
    // 4. 메세지 송신 메소드
    public void send(String msg) {
    	Thread thread = new Thread() {
    		@Override
    		public void run() {
    			try {
    				OutputStream outputStream = socket.getOutputStream();
    				outputStream.write(msg.getBytes());
    				outputStream.flush(); // 스트림 초기화
    			} catch(Exception e) { System.out.println("메세지 송신 오류 : "+e);}
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
    	} catch(Exception e) { System.out.println("메세지 수신 오류 : "+e);}
    }    
    @FXML
    void connect(ActionEvent event) {
    	if(btnconnect.getText().equals("채팅방 입장")) { // 입장
    		clientstart(room.getRoomip(), room.getRoomnum());
    		btnconnect.setText("채팅방 퇴장");
    		txtcontent.appendText("---[채팅방 입장]---\n");
    		txtmsg.setText("");
    		txtmsg.setDisable(false);
    		txtcontent.setDisable(false);
    		btnsend.setDisable(false);
    		txtmsg.requestFocus();
    		
    		// 현재 방 접속명단 추가
    		Roomlive roomlive = new Roomlive(0, room.getRoomnum(), Login.member.getMid());
    		RoomDao.roomDao.addroomlive(roomlive);
    		midshow();
    		
    		txtroomname.setDisable(true); // 채팅방이름 입력창 사용금지
    		btnadd.setDisable(true); // 채팅방 개설 버튼 사용금지
    		roomtable.setDisable(true); // 채팅방 목록 사용금지
    		
    	}else { // 퇴장
    		btnconnect.setText("채팅방 입장");
    		txtcontent.appendText("---[채팅방 퇴장]---\n");
    		clientstop();
    		txtmsg.setDisable(true);
    		txtcontent.setDisable(true);
    		btnsend.setDisable(true);
    		btnconnect.setDisable(true); // 입장버튼 사용금지
    		txtmidlist.setDisable(true); // 접속회원 목록 사용금지
    		txtmsg.setText("채팅방 입장 후 사용가능합니다.");

    		txtroomname.setDisable(false); // 채팅방이름 입력창 사용가능
    		btnadd.setDisable(false); // 채팅방 개설 버튼 사용가능
    		roomtable.setDisable(false); // 채팅방 목록 사용가능
    		
    		// 1. 방 접속 명단에서 제외[삭제]하기
    		RoomDao.roomDao.roomlivedelete(Login.member.getMid());
    		// 2. 만약에 방 접속 명단이 0명이면 방삭제
    		boolean result = RoomDao.roomDao.roomdelete(room.getRoomnum());
    		if(result) {
    			show();
    			// * 서버소켓 종료
    			server.serverstop();
    			
    		}
    		// * 테이블뷰에서 선택된 방 객체 초기화
    		room = null;
    		// * 선택된 방 레이블 초기화
    		lblselect.setText("현재 선택된 방 : ");
    		show();
    		
    		// 방 나갈때 서버소켓내 접속된 소켓 리스트에서 소켓 제거
    		
    	}
    }

    @FXML
    void msg(ActionEvent event) { // 메세지 입력하고 엔터 쳤을때
    	String msg =Login.member.getMid()+" : "+ txtmsg.getText()+"\n";
    	send(msg);
    	txtmsg.setText("");
    	txtmsg.requestFocus(); // 보내기 후 메세지 입력창으로 포커스(커서) 이동
    	midshow();
    }
    
    @FXML
    void send(ActionEvent event) { // 전송 버튼 눌렀을때
    	String msg =Login.member.getMid()+" : "+ txtmsg.getText()+"\n";
    	send(msg);
    	txtmsg.setText("");
    	txtmsg.requestFocus(); // 보내기 후 메세지 입력창으로 포커스(커서) 이동
    	midshow();
    
    }
    
    public void midshow() {
	ArrayList<Roomlive> roomlivelist = RoomDao.roomDao.getRoomlivelist(room.getRoomnum());
    	
    	txtmidlist.setText("");
    	int i=0;
    	for(Roomlive temp : roomlivelist) {
    		txtmidlist.appendText(i+"번 "+temp.getMid()+"\n");
    		i++;
    	}
    }
	
    public void show() {
    	
    	ObservableList<Room> r = RoomDao.roomDao.roomlist();
    	ObservableList<Room> roomlist = FXCollections.observableArrayList();
		for(int i=0; i<r.size(); i++) {
			if(RoomDao.mcountlist!=null) {
				roomlist.add(RoomDao.roomDao.roomlist().get(i));
			}else {
				for(int j=0; j<RoomDao.mcountlist.size(); j++) {
					 if(r.get(i).getRoomnum()==RoomDao.mcountlist.get(j).getRoomnum()) {
						 Room ro = new Room(r.get(i).getRoomnum(), r.get(i).getRoomname(), r.get(i).getRoomip(), RoomDao.mcountlist.get(j).getMcount());
						 roomlist.add(ro);
					 }
					 else  {
						roomlist.add(RoomDao.roomDao.roomlist().get(i));
					}
				 }
			}
			 
		}
		
		TableColumn tc = roomtable.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("roomnum"));
		
		tc = roomtable.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("roomname"));
		
		tc = roomtable.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("mcount"));
		
		roomtable.setItems(roomlist);
		
		roomtable.setOnMouseClicked(e->{
			room = roomtable.getSelectionModel().getSelectedItem();
			lblselect.setText("현재 선택된 방 : "+room.getRoomname());
			btnconnect.setDisable(false);
		});
    }
    
}
