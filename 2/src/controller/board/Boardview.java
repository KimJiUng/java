package controller.board;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.BoardDao;
import dao.ReplyDao;
import dto.Board;
import dto.Reply;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Boardview implements Initializable {

	public static Reply reply;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		BoardDao.boardDao.viewplus();
		Board board = controller.board.Boardcontroller.board; // boardcontroller내 테이블에서 선택된 객체 호출
		
		// 각 컨트롤에 선택된 board의 데이터 설정하기
		txttitle.setText(board.getBtitle());
		txtcontent.setText(board.getBcontent());
		lblwriter.setText("작성자 : "+board.getBwrite());
		lbldate.setText("작성일 : "+board.getBdate());
		lblview.setText("조회수 : "+board.getBview());
		
		// 만약에 게시물 작성자와 현재로그인된 id와 동일하지 않으면
		if(!Login.member.getMid().equals(board.getBwrite())) {
			btndelete.setVisible(false);
			btnupdate.setVisible(false);
			
		}
		// 제목과 내용 수정 못하게
		txttitle.setEditable(false);
		txtcontent.setEditable(false);
		btnredelete.setVisible(false);
		btnreupdate.setVisible(false);
		
		replytableshow();
		replytable.setOnMouseClicked(e ->{
			reply = replytable.getSelectionModel().getSelectedItem();
			if(reply.getRwriter().equals(Login.member.getMid())) {
				btnreupdate.setVisible(true);
				btnredelete.setVisible(true);
			}
			else {
				btnredelete.setVisible(false);
				btnreupdate.setVisible(false);
			}
		});
		
	}
	
    @FXML
    private TextField txttitle;

    @FXML
    private TextArea txtcontent;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btnback;

    @FXML
    private Label lblwriter;

    @FXML
    private Label lbldate;

    @FXML
    private Label lblview;

    @FXML
    private TextArea txtrecontent;

    @FXML
    private Button btnrewrite;

    @FXML
    private TableView<Reply> replytable;
    
    @FXML
    private Button btnredelete;

    @FXML
    private Button btnreupdate;

    @FXML
    void accback(ActionEvent event) {
    	Home.instance.loadpage("/view/board/board.fxml");
    }

    @FXML
    void accdelete(ActionEvent event) {
    	// 1. 경고 메세지 알림
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("정말 삭제하시겠습니까?");
    	Optional<ButtonType> optional = alert.showAndWait();
    	// 2. 확인 버튼 눌렀을때
    	if(optional.get()==ButtonType.OK) {
    		// 3. 삭제처리
    		boolean result = BoardDao.boardDao.delete(Boardcontroller.board.getBnum());
    		if(result) {
    			Alert alert2 = new Alert(AlertType.INFORMATION);
        		alert2.setHeaderText("삭제가 완료되었습니다.");
        		alert2.showAndWait();
    			Boardcontroller.board=null;
        		Home.instance.loadpage("/view/board/board.fxml");
    		}else {
    			System.out.println("삭제실패 DB오류");
    		}
    	}
    }

    @FXML
    void accrewrite(ActionEvent event) {
    	if(reupdatecheck) {
    		String rcontent = txtrecontent.getText();
        	int rnum = reply.getRnum();
        	boolean result = ReplyDao.replyDao.replyupdate(rnum, rcontent);
        	if(result) {
        		Alert alert = new Alert(AlertType.INFORMATION);
        		alert.setHeaderText("수정이 완료되었습니다.");
        		alert.showAndWait();
        		btnredelete.setVisible(false);
        		btnreupdate.setVisible(false);
        		btnrewrite.setText("댓글작성");
        		reupdatecheck=false;
        		Home.instance.loadpage("/view/board/boardview.fxml");
        		
        	}
    	}else {
    		String recontent = txtrecontent.getText();
        	String rwriter = Login.member.getMid();
        	int bnum = Boardcontroller.board.getBnum();
        	Reply reply = new Reply(0, rwriter, null, recontent, bnum);
        	boolean result = ReplyDao.replyDao.wirte(reply);
        	if(result) {
        		Alert alert = new Alert(AlertType.INFORMATION);
        		alert.setHeaderText("댓글이 작성 되었습니다.");
        		alert.showAndWait();
        		Home.instance.loadpage("/view/board/boardview.fxml");
        	}
    	}
    	
    }

    boolean updatecheck = true; // 수정 버튼 스위치 변수
    @FXML
    void accupdate(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	
    	if(updatecheck) { // 수정 시작
    		
    		alert.setHeaderText("게시글 수정후 수정완료 버튼 눌러주세요");
    		alert.showAndWait();
    		txttitle.setEditable(true);
    		txtcontent.setEditable(true);
    		btnupdate.setText("수정완료");
    		updatecheck=false;
    		
    	} else {
    		String title = txttitle.getText();
        	String content = txtcontent.getText();
        	int bnum = Boardcontroller.board.getBnum();
        	
        	boolean result = BoardDao.boardDao.update(bnum, title, content);
        	if(result) {
        		alert.setHeaderText("수정이 완료되었습니다.");
        		alert.showAndWait();
        		txttitle.setEditable(false);
        		txtcontent.setEditable(false);
        		btnupdate.setText("수정");
        		updatecheck=true;
        		Home.instance.loadpage("/view/board/boardview.fxml");
        		
        	}
    		
    	}

    }
    
    @FXML
    void accredelete(ActionEvent event) {
    	if(reply.getRwriter().equals(Login.member.getMid())) {
    		// 1. 경고 메세지 알림
        	Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setHeaderText("정말 삭제하시겠습니까?");
        	Optional<ButtonType> optional = alert.showAndWait();
        	// 2. 확인 버튼 눌렀을때
        	if(optional.get()==ButtonType.OK) {
        		// 3. 삭제처리
        		boolean result = ReplyDao.replyDao.replydelete(reply.getRnum());
        		if(result) {
        			Alert alert2 = new Alert(AlertType.INFORMATION);
            		alert2.setHeaderText("삭제가 완료되었습니다.");
            		alert2.showAndWait();
        			reply=null;
        			Home.instance.loadpage("/view/board/boardview.fxml");
        		}else {
        			System.out.println("삭제실패 DB오류");
        		}
        	}
		}
    	else {
    		System.out.println("삭제불가");
    	}
    	
    }
    boolean reupdatecheck = false;
    @FXML
    void accreupdate(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	
    	if(updatecheck) { // 수정 시작
    		btnreupdate.setVisible(false);
    		alert.setHeaderText("댓글 수정후 수정완료 버튼 눌러주세요");
    		alert.showAndWait();
    		btnrewrite.setText("수정완료");
    		reupdatecheck=true;
    		
    	} else {
        
    		
    	}
    }
    
    public void replytableshow() {
    	
    	ObservableList<Reply> replylist = ReplyDao.replyDao.list();
    	
    	TableColumn tc = replytable.getColumns().get(0);
    	tc.setCellValueFactory(new PropertyValueFactory<>("rnum"));
    	
    	tc = replytable.getColumns().get(1);
    	tc.setCellValueFactory(new PropertyValueFactory<>("rwriter"));
    	
    	tc = replytable.getColumns().get(2);
    	tc.setCellValueFactory(new PropertyValueFactory<>("rdate"));
    	
    	tc = replytable.getColumns().get(3);
    	tc.setCellValueFactory(new PropertyValueFactory<>("rcontent"));
    	
    	replytable.setItems(replylist);
    	
    }
	
	
	
}
