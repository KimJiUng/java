package controller.board;

import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import dao.BoardDao;
import dto.Board;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Boardcontroller implements Initializable {

	public static Board board; // 테이블에서 클릭한 객체를 저장하는 객체
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// ArrayList 가 아닌 ObservableList 사용하는 이유 : TableView에 넣기 위해서
		// DB에서 모든 게시글 가져오기
		ObservableList<dto.Board> boardlist = BoardDao.boardDao.list();
		// TableView에 추가
		TableColumn tc = boardtable.getColumns().get(0); // 테이블에서 인덱스0(첫번째) 열 가져오기
		tc.setCellValueFactory(new PropertyValueFactory<>("bnum"));
		
		tc = boardtable.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		
		tc = boardtable.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("bwrite"));
		
		tc = boardtable.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("bdate"));
		
		tc = boardtable.getColumns().get(4);
		tc.setCellValueFactory(new PropertyValueFactory<>("bview"));
		
		// TableView에 list 연결
		boardtable.setItems(boardlist);
		
		// * TableView에서 해당 셀을 클릭했을때 이벤트
		boardtable.setOnMouseClicked(e ->{ // 인수 -> { 실행코드 } : 테이블을 클릭했을때
			// 1. 테이블에서 클릭한 객체를 임시객체에 저장
			board = boardtable.getSelectionModel().getSelectedItem(); // 클릭된 board 객체 호출
			
			// 2. 조회수 증가
			// 3. 페이지 전환
			Home.instance.loadpage("/view/board/boardview.fxml");
		});
		
	}
	
    @FXML
    private TableView<Board> boardtable;

    @FXML
    private Button btnwrite;

    @FXML
    void accwrite(ActionEvent event) {
    	Home.instance.loadpage("/view/board/boardwrite.fxml");
    }
}
