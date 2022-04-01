package application.Day22;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DBtestcontroller implements Initializable{
										// Initializable : fxml이 새로 열렸을떄 초기값[처음값] 설정 메소드 제공
    @FXML
    private TextField txtwirter;

    @FXML
    private TextField txtcontent;

    @FXML
    private Button btnget;

    @FXML
    private Button btnwrite;

    @FXML
    private TextArea txtcontentlist;

    @FXML
    void accget(ActionEvent event) {
    	System.out.println("DB내 데이터를 호출합니다.");
    	
    	// 1. DB 연동 객체 만들기
    	Day22_2 DB연동 = new Day22_2();
    	// 2. DB 객체내 메소드 호출
    	ArrayList<data> datalist = DB연동.get();
    	// 3. 리스트를 컨트롤에 넣어주기
    	for(data temp : datalist) {
    		// txtcontentlist.appendText : 해당 컨트롤에 내용 추가
    		
    		txtcontentlist.appendText(
    				"번호 : "+temp.getNum()+
    				"\t작성자 : "+temp.getWriter()+
    				"\t내용 : "+temp.getContent()+"\n"
    				
    				);
    		
    	}
    	
    }

    @FXML
    void accwrite(ActionEvent event) {
    	System.out.println("DB내 데이터를 저장합니다.");
    	
    	// fxid명.getText() : 해당 컨트롤에 입력된 값을 가져오기
    	String writer = txtwirter.getText();
    	String content = txtcontent.getText();
    	
    	// 1. DB 연동 객체 만들기
    	Day22_2 DB연동 = new Day22_2();
    	// 2. DB 연동 객체내에서 삽입[write] 메소드 호출
    	boolean result = DB연동.write(writer, content);
    	if(result) {
    		System.out.println("DB에 저장 성공");
    		
    		// 성공시 컨트롤에 입력된 데이터 지워주기
    			// fxid명.setText() : 해당 컨트롤에 값 넣기
    		txtwirter.setText("");
    		txtcontent.setText("");
    		
    	}else {
    		System.out.println("DB에 저장 실패");
    	}
    }
    

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	Day22_2 DB연동 = new Day22_2(); // 생성자에 db연동 코드를 넣었기 떄문에 객체 선언시 연동
    }
	
	
}
