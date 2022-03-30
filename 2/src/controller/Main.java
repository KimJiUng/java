package controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable {
					// Initializable : view 가 열렸을때 초기값 설정 메소드 제공

    @FXML
    private BorderPane borderpane; // fx:id
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { // 해당 fxml이 열렸을때 초기값
		loadpage("/view/login.fxml"); // loadpage 메소드 호출( 패키지/파일명 )
	}
	
	public void loadpage(String page) { // loadpage(파일경로)
		try {
			// 페이지(fxml) 객체화
			Parent parent = FXMLLoader.load(getClass().getResource(page)); // 무조건 예외처리
			borderpane.setCenter(parent); // 컨테이너 가운데에 페이지 넣기
		} catch (Exception e) {
			System.out.println("페이지 연결 실패 사유 : "+e);
		} 
	}
	
	
	
}
