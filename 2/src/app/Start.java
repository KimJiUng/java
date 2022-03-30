package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Start extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		// 5. 컨테이너 불러오기
		Parent parent = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
		// 6. 씬 객체 -> 컨테이너
		Scene scene = new Scene(parent);
		// 7. 씬 -> 스테이지
		stage.setScene(scene);
		// 3. 스테이지 로고 설정
			// 1. 이미지 불러오기 [이미지 객체화]
			Image image = new Image("/img/stagelogo.png");
				// 절대경로 : 모든 경로
					// C:\Users\504\git\java\2\src\img/파일명.확장자
				// 상대경로 : 현 위치 기준 경로
					// 생략 [src폴더부터 ] /img/파일명.확장자
		stage.setResizable(false); // 4. 스테이지 크기 변경 불가
		stage.getIcons().add(image); // 3. 스테이지 아이콘설정
		stage.setTitle("이젠마켓"); // 2. 스테이지 창 이름
		stage.show(); // 1. 스테이지 열기
	}
	public static void main(String[] args) {
		launch(args);
	}
}
