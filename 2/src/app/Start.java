package app;

import controller.Chatting;
import controller.login.Login;
import dao.RoomDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Start extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// 5. 컨테이너 불러오기
		Parent parent = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
		// 6. 씬 객체 -> 컨테이너
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		
	
		// 3. 스테이지 로고 설정
			// 1. 이미지 불러오기 [이미지 객체화]
		Image image = new Image("/img/stagelogo.png");
				// 절대경로 : 모든 경로
				// 상대경로 : 현 위치[프로젝트기준 src] 기준 경로
					// 생략 [src 폴더부터] /img/파일명.확장자
		
		stage.getIcons().add(image);
		
		// * 외부 폰트 설정
			// 1. 폰트 가져오기
			Font.loadFont(getClass().getResourceAsStream("해남체.ttf"), 14);
			// 2. 외부 스타일시트 적용
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		// * stage = 윈도우창에 x버튼 눌렀을때 이벤트
		stage.setOnCloseRequest(e ->{
			// 만약에 로그인이 되어있으면
			if(Login.member!=null) {
				if(Chatting.room != null) {
					// 1. 방 접속명단 삭제
					RoomDao.roomDao.roomlivedelete(Login.member.getMid());
					// 2. 방 삭제
					RoomDao.roomDao.roomdelete(Chatting.room.getRoomnum());
				}
				// 3. 선택 방 초기화
				Chatting.room = null;
			}
		});
		
		stage.setResizable(false); // 4. 스테이지 크기 변경 불가
		stage.setTitle("이젠마켓"); // 2. 스테이지 창 이름
		stage.show(); // 1. 스테이지 열기
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
