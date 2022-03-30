package controller;

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
    private TextField textid;

    @FXML
    private PasswordField textpw;

    @FXML
    private Button btnlogin;

    @FXML
    private Button btnfindid;

    @FXML
    private Button btnfindpw;

    @FXML
    private Button btnsignup;

    @FXML
    private Label labelconfirm;
	
    @FXML
    void accfindid(ActionEvent event) {
    	System.out.println("���̵�ã�� ������");
    }

    @FXML
    void accfindpw(ActionEvent event) {
    	System.out.println("��й�ȣã�� ������");
    }

    @FXML
    void accfindsingup(ActionEvent event) {
    	System.out.println("ȸ������ ������");
    }

    @FXML
    void acclogin(ActionEvent event) {
    	System.out.println("�α��� ������");
    }	
}
