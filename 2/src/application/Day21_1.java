package application;

// javafx만 사용 [awt, swing x]
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Day21_1 extends Application {
					// extends : 상속 [ Application : JAVAFX GUI 관련클래스 ]
							// 상속받으면 슈퍼클래스내 멤버를 사용할 수 있다.
	
	@Override
	public void start(Stage stage) throws Exception {
		// javafx를 실행하는 메소드 [추상->구현]
			// start(State 스테이지이름)
		// 1. 컨테이너 만들기 [여러개 컨트롤을 세로로 저장]
		VBox box = new VBox();
			// 2. 컨트롤 만들기
			Button button = new Button();
			button.setText("닫기");
			button.setOnAction(e -> Platform.exit());
							// 값 -> 인수 : 람다식 (이름이 없는 메소드)
		// 3. 컨테이너에 컨트롤 넣기
		box.getChildren().add(button);
		// 4. Scene 객체 만들어서 컨테이너 넣기
		Scene scene = new Scene(box, 500, 500); // 컨테이너이름, 가로길이, 세로길이
		// 5. stage에 scene 넣기
		stage.setScene(scene);
		
		stage.show(); // 스테이지 열기
		
		// * 순서 : 스테이지 -> 씬 -> 컨테이너 -> 여러개의 컨트롤(버튼,입력상자,표 등)
	}
	
	public static void main(String[] args) { // main 스레드를 가지고 있는 메소드
		launch(args); // start 메소드 호출
		
		
		
	}
	
	
	
}
