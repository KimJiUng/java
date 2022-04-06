package controller.home;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.Main;
import controller.login.Login;
import dao.MemberDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Home implements Initializable {
	
	public static Home instance;
	
	public Home() {instance=this;}
	
	@FXML
	private Label lblloginid;
	
	@FXML
	private Label lblpoint;
	
	@FXML
	private Label lbllogout;
	
	@FXML
	private Label lbldelete;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblloginid.setText(Login.member.getMid());
		lblpoint.setText("보유 포인트 : "+Login.member.getMpoint());
	}
	
	@FXML // 로그아웃 레이블을 클릭했을때 이벤트
	public void logout(MouseEvent e) {
		// 1. 로그인 정보 지우기
		Login.member = null;
		Main.instance.loadpage("/view/login/login.fxml");
	}
	
	@FXML
	public void delete(MouseEvent e) {
		// 1. 메세지
		Alert alert = new Alert(AlertType.CONFIRMATION); // 확인 취소 버튼
		alert.setHeaderText("정말 탈퇴하시겠습니까?");
		// 2. 버늩 확인 [Optional 클래스]
		Optional<ButtonType> optional = alert.showAndWait(); // 실행
		if(optional.get()==ButtonType.OK) { // 확인 버튼을 눌렀을때
			// 회원탈퇴 진행
			boolean result = MemberDao.memberDao.delete(Login.member.getMnum());
			if(result) { // 탈퇴 성공
				// 로그아웃 [Login 클래스내 member 객체 null로 수정]
				Login.member=null;
				// 페이지전환
				Main.instance.loadpage("/view/login/login.fxml");
			}else { // 탈퇴 실패
				
			}
		}
	}
    @FXML
    private BorderPane borderpane;
    
    public void loadpage(String page) {
    	try {
    		Parent parent = FXMLLoader.load(getClass().getResource(page));
    		borderpane.setCenter(parent);
    	} catch(Exception e) {
    		System.out.println("Home 페이지 불러오기 실패 : "+e);
    	}
    }
	@FXML
	private Label lblinfo;
	
	@FXML
	public void accinfo(MouseEvent e) {
		loadpage("/view/home/info.fxml");
		
	}
	
	@FXML
	private Label lblmodify;
	
	@FXML
	public void accmodify(MouseEvent e) {
		loadpage("/view/home/modify.fxml");
	}
	
	@FXML
	private Label lblboard;
	
	@FXML void accboard(MouseEvent e) {
		loadpage("/view/board/board.fxml");
	}

	@FXML
	public void accproduct(MouseEvent e) {
		loadpage("/view/product/product.fxml");
	}
	
}
