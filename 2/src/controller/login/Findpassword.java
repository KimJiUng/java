package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import dto.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Findpassword implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}
	
    @FXML
    private Button btnback;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtemail;

    @FXML
    private Button btnfindpw;

    @FXML
    private Label lblconfirm;

    @FXML
    void accback(ActionEvent event) {
    	Login.instance.loadpage("/view/login/loginpane.fxml");
    }

    @FXML
    void accfindpw(ActionEvent event) {
    	// 1. 컨트롤[fxid]에 입력된 값 가져오기
    	String email = txtemail.getText();
    	String id = txtid.getText();
    	// 2. DB 객체내 메소드 호출
    	String result = MemberDao.memberDao.findpw(email, id);
    	// 3. 결과 확인
    	if(result!=null) {
    		Member.sendmail(email, result);
	    	// 1. 메세지창 출력 [Alert : 메세지(알람) 클래스]
			Alert alert = new Alert(AlertType.INFORMATION); // 메세지 객체
			alert.setTitle("알림"); // 메세지 제목 설정
			alert.setHeaderText("비밀번호찾기가 완료되었습니다."); // 
			alert.setContentText("해당 메일로 비밀번호를 전송하였습니다.");
			alert.showAndWait(); // 메세지 실행
		
		// 2. 화면 전환 [로그인페이지로 전환]
		Login.instance.loadpage("/view/login/loginpane.fxml");
    	}
    	else {
    		lblconfirm.setText("일치하는 이메일이 없습니다.");
    	}
    }
}
