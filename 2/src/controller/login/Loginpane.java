package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Loginpane implements Initializable {


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txtid.requestFocus();
		
		lblconfirm.setText(""); // 처음 실행시 문구 숨기기
		
	}
	
    @FXML
    private TextField txtid;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Button btnlogin;

    @FXML
    private Button btnsignup;

    @FXML
    private Button btnfindid;

    @FXML
    private Button btnfindpassword;

    @FXML
    private Label lblconfirm;

    @FXML
    void accfindid(ActionEvent event) {
    	System.out.println("아이디찾기 페이지로 이동");
    	Login.instance.loadpage("/view/login/findidpane.fxml");
    }

    @FXML
    void accfindpassword(ActionEvent event) {
    	Login.instance.loadpage("/view/login/findpwpane.fxml");
    	System.out.println("비밀번호찾기 페이지로 이동");
    }

    @FXML
    void accsignup(ActionEvent event) {
    	System.out.println("회원가입 페이지로 이동");
    	Login.instance.loadpage("/view/login/signuppane.fxml");
    }

    @FXML
    void login(ActionEvent event) {
    	// 1. 컨트롤[fxid]에 입력된 값 가져오기
    	String id = txtid.getText();
    	String password = txtpassword.getText();
    	// 2. DB 객체내 메소드 호출
    	boolean result = MemberDao.memberDao.login(id, password);
    	// 3. 결과 확인
    	if(result) {
    		// 로그인 성공시 성공한 회원정보 저장 [로그아웃시 초기화]
    		Login.member = MemberDao.memberDao.getMember(id);
    		
    		boolean result2 = MemberDao.memberDao.pointplus();
    		if(result2) {
    			Login.member = MemberDao.memberDao.getMember(id);
    			Main.instance.loadpage("/view/home/home.fxml");
    		}
    		
    		
    		
    	}
    	else {
    		lblconfirm.setText("동일한 회원정보가 없습니다.");
    	}
    	
    }
    
    @FXML
    void enterlogin(ActionEvent event) {
    	// 1. 컨트롤[fxid]에 입력된 값 가져오기
    	String id = txtid.getText();
    	String password = txtpassword.getText();
    	// 2. DB 객체내 메소드 호출
    	boolean result = MemberDao.memberDao.login(id, password);
    	// 3. 결과 확인
    	if(result) {
    		// 로그인 성공시 성공한 회원정보 저장 [로그아웃시 초기화]
    		Login.member = MemberDao.memberDao.getMember(id);
    		
    		boolean result2 = MemberDao.memberDao.pointplus();
    		if(result2) {
    			Login.member = MemberDao.memberDao.getMember(id);
    			Main.instance.loadpage("/view/home/home.fxml");
    		}
    		
    		
    		
    	}
    	else {
    		lblconfirm.setText("동일한 회원정보가 없습니다.");
    	}
    }
    

    
  
}
