package controller.home;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import controller.login.Login;
import dao.MemberDao;
import dto.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Modify implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
		txtnewemail.setText(Login.member.getMemail());
		txtnewaddress.setText(Login.member.getMaddress());
	}
	
    @FXML
    private TextField txtpw;

    @FXML
    private TextField txtnewpw;

    @FXML
    private TextField txtnewpwcheck;

    @FXML
    private TextField txtnewemail;

    @FXML
    private TextField txtnewaddress;
    
    @FXML
    private Button btnmodify;

    @FXML
    private Button btnback;
    
    @FXML
    private Label lblconfirm;

    @FXML
    void accback(ActionEvent event) {
    	Main.instance.loadpage("/view/home/home.fxml");
    }

    @FXML
    void accmodify(ActionEvent event) {
    	String pw=null;
    	String newpw=null;
    	String newpwcheck=null;
    	String newemail=null;
    	String newaddress=null;

    	
    	if(txtpw.getText().equals("")) {
    		if(!(txtnewpw.getText().equals("") || txtnewpwcheck.getText().equals("") )) {
    			lblconfirm.setText("현재 비밀번호, 새로운 비밀번호, 비밀번호 확인을 모두 입력해주세요.");
    			return;
    		}
    		pw = Login.member.getMpassword();
    		newpw = Login.member.getMpassword();
    		newpwcheck = Login.member.getMpassword();
    	}else {
    		if(!txtpw.getText().equals(Login.member.getMpassword())) {
    			lblconfirm.setText("현재 비밀번호가 일치하지 않습니다.");
    			return;
    		}
    		if(txtnewpw.getText().length()<4 || txtnewpw.getText().length()>10) {
    			lblconfirm.setText("비밀번호의 길이는 4~10 사이로 입력해주세요.");
        		return;
    		}
    		if(!txtnewpw.getText().equals(txtnewpwcheck.getText())) {
    			lblconfirm.setText("비밀번호가 일치하지 않습니다.");
    			return;
    		}
    		
    		pw = txtpw.getText();
    		newpw = txtnewpw.getText();
    		newpwcheck = txtnewpwcheck.getText();
    	}
    	if(txtnewemail.getText().equals("")) {
    		newemail = Login.member.getMemail();
    	}else {
    		if(txtnewemail.getText().indexOf("@")==-1) { // 만약에 입력한 이메일에 @가 없으면
        		lblconfirm.setText("이메일 형식으로 입력해주세요");
        		return;
        	}
    		newemail = txtnewemail.getText();
    	}
    	if(txtnewaddress.getText().equals("")) {
    		newaddress = Login.member.getMaddress();
    	}else {
    		if(!(txtnewaddress.getText().contains("시") && txtnewaddress.getText().contains("구") && txtnewaddress.getText().contains("동")) ) {
        		lblconfirm.setText("주소 형식으로 입력해주세요");
        		return;
        	}
    		newaddress = txtnewaddress.getText();
    	}
    	
    	boolean result = MemberDao.memberDao.modify(pw, newpw, newpwcheck, newemail, newaddress);
    	if(result) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("알림");
    		alert.setHeaderText("회원정보 수정이 완료되었습니다.");
    		alert.setContentText("로그아웃후 메인페이지로 돌아갑니다.");
    		alert.showAndWait();
    		Login.member=null;
    		Main.instance.loadpage("/view/login/login.fxml");
    	}else {
    		System.out.println("실패");
    	}
    }


	
	
	
}
