package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Day21_2 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		// 1. FXML 파일 불러오기 : 컨테이너
		Parent parent = FXMLLoader.load(getClass().getResource("test.fxml") );
		// 2. Scene 객체 생성 : scene에 
		Scene scene = new Scene(parent);
		// 3. stage에 scene 넣기
		stage.setScene(scene);
		// 4. stage 시작
		stage.show(); // 스테이지 열기
		
	}
	
	public static void main(String[] args) {
		launch(args); // start 메소드 호출
	}
	
	
	
}
