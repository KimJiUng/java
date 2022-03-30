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
    	System.out.println("���̵�ã�� �������� �̵�");
    }

    @FXML
    void accfindpassword(ActionEvent event) {
    	System.out.println("��й�ȣã�� �������� �̵�");
    }

    @FXML
    void accsignup(ActionEvent event) {
    	System.out.println("ȸ������ �������� �̵�");
    	Login.instance.loadpage("/view/login/signuppane.fxml");
    }

    @FXML
    void login(ActionEvent event) {
    	System.out.println(txtid.getText() + "�� ���̵� �ԷµǾ����ϴ�.");
    	System.out.println(txtpassword.getText() + "�� �н����尡 �ԷµǾ����ϴ�.");
    	String id = txtid.getText();
    	String pw = txtpassword.getText();
    	if(id.equals("admin") && pw.equals("1234")) {
    		lblconfirm.setText("������ �α���");
    	}else {
    		lblconfirm.setText("�Ϲ�ȸ�� �α���");
    	}
    		
    	System.out.println("�α���ó��");
    }
	
}
