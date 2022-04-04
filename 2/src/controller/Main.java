package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable {
	
	public static Main instance;
	
	public Main() { instance = this; }
	
    @FXML
    private BorderPane borderpane1;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadpage("/view/login/login.fxml"); // loadpage 메소드 호출시(파일경로)
	}
    
	public void loadpage(String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page)); // 해당 파일 불러오기
			borderpane1.setCenter(parent); // main.fxml에 존재하는 borderpane1 객체내 center를 해당 파일로 변경
		} catch(Exception e) {System.out.println("ㅗ페이지 불러오기 실패 사유 : "+e);}
		
	}
	
    
}
