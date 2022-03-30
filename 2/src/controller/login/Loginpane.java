package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

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
    }

    @FXML
    void accfindpassword(ActionEvent event) {
    	System.out.println("비밀번호찾기 페이지로 이동");
    }

    @FXML
    void accsignup(ActionEvent event) {
    	System.out.println("회원가입 페이지로 이동");
    	Login.instance.loadpage("/view/login/signuppane.fxml");
    }

    @FXML
    void login(ActionEvent event) {
    	System.out.println(txtid.getText() + "로 아이디가 입력되었습니다.");
    	System.out.println(txtpassword.getText() + "로 패스워드가 입력되었습니다.");
    	String id = txtid.getText();
    	String pw = txtpassword.getText();
    	if(id.equals("admin") && pw.equals("1234")) {
    		lblconfirm.setText("관리자 로그인");
    	}else {
    		lblconfirm.setText("일반회원 로그인");
    	}
    		
    	System.out.println("로그인처리");
    }
	
}
