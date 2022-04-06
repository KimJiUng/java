package controller.board;

import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.BoardDao;
import dto.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Boardwrite implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
    @FXML
    private TextField txttitle;

    @FXML
    private TextArea txtcontent;

    @FXML
    private Button btnwrite;

    @FXML
    private Button btnback;

    @FXML
    void accback(ActionEvent event) {
    	Home.instance.loadpage("/view/board/board.fxml");
    }

    @FXML
    void accwrite(ActionEvent event) {
    	String title = txttitle.getText();
    	String content = txtcontent.getText();
    	String writer = Login.member.getMid();
    	int mnum = Login.member.getMnum();
    	Board board = new Board(0, title, content, writer, null, 0,mnum);
    	boolean result = BoardDao.boardDao.write(board);
    	if(result) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("게시글이 작성 되었습니다.");
    		alert.showAndWait();
    		Home.instance.loadpage("/view/board/board.fxml");
    	}else {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("게시글 작성 실패 [관리자에게 문의하세요]");
    		alert.showAndWait();
    	}
    	
    }
	
	
}
