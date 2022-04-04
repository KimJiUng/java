package controller.home;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import controller.login.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Info implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblnum.setText(Login.member.getMnum()+"¹ø");
		lblid.setText(Login.member.getMid());
		lblemail.setText(Login.member.getMemail());
		lbladdress.setText(Login.member.getMaddress());
		lblpoint.setText(Login.member.getMpoint()+"Á¡");
		lblsince.setText(Login.member.getMsince());
		
	}
	
	@FXML
	private Label lblnum;
	
	@FXML
	private Label lblid;
	
	@FXML
	private Label lblemail;
	
	@FXML
	private Label lbladdress;
	
	@FXML
	private Label lblpoint;
	
	@FXML
	private Label lblsince;
	
    @FXML
    private Button btnback;

    @FXML
    void accback(ActionEvent event) {
    	Main.instance.loadpage("/view/home/home.fxml");
    }
	
	
	
}
