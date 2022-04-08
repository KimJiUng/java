package controller.login;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import dao.MemberDao;
import dto.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Signuppane implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
		txtid.requestFocus();
	}
	
    @FXML
    private TextField txtid;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Button btnsignup;

    @FXML
    private Button btnback;

    @FXML
    private Label lblconfirm;

    @FXML
    private PasswordField txtpasswordconfirm;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtadress;

    @FXML
    void back(ActionEvent event) {
    	System.out.println("뒤로가기 버튼을 눌렀습니다.");
    	Login.instance.loadpage("/view/login/loginpane.fxml");
    }

    @FXML
    void signup(ActionEvent event) {
    	// * 컨트롤에 입력된 데이터 가져오기
    	String id = txtid.getText();
    	String password = txtpassword.getText();
    	String passwordconfirm = txtpasswordconfirm.getText();
    	String email = txtemail.getText();
    	String address = txtadress.getText();
    	
    	// 현재날짜 가져오기 [SimpleDateFormat : 날짜 모양(형식) 변환 클래스]
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String since = format.format(new Date() ) ; // 현재날짜를 형식 변환
    	
    	// * 유효성검사 [제한]
    		// 1. id 중복 체크
    	boolean result2 = MemberDao.memberDao.idcheck(id);
    	if(result2) {
    		lblconfirm.setText("이미 사용중인 아이디입니다.");
    		return;
    	}
    		// 2. id 길이 체크
    	if(id.length()<4 || id.length()>10) {
    		lblconfirm.setText("아이디의 길이는 4~10 사이로 입력해주세요.");
    		return;
    	}
    		// 3. 비밀번호 길이 체크
    	if(password.length()<4 || password.length()>10) {
    		lblconfirm.setText("비밀번호의 길이는 4~10 사이로 입력해주세요.");
    		return; // 가입 못하게 종료
    	}
    		// 4. 비밀번호 일치 체크
    	if(!password.equals(passwordconfirm)) { // 비밀번호가 일치하지 않으면 [ ! : 부정,반대 ]
    		lblconfirm.setText("비밀번호가 일치하지 않습니다.");
    		return; // 메소드 종료
    	}
    		// 5. 이메일 체크 [문자열.indexOf("문자") : 해당 문자열내 문자가 존재하면 해당 문자의 인덱스 호출 / 없으면 -1
    	if(email.indexOf("@")==-1) { // 만약에 입력한 이메일에 @가 없으면
    		lblconfirm.setText("이메일 형식으로 입력해주세요");
    		return;
    	}
    		// 6. 주소 체크
    	if(!(address.contains("시") && address.contains("구") && address.contains("동")) ) {
    		lblconfirm.setText("주소 형식으로 입력해주세요");
    		return;
    	}
    	// * 모든 유효성검사 통과시 DB에 저장
    		// 1. 객체화 [회원번호없음=0, 아이디, 패스워드, 이메일, 주소, 포인트없음=0, 가입일]
    	Member member = new Member(0, id, password, email, address, 0, since);
    		// 2. DB 객체내 메소드 호출
    	boolean result = MemberDao.memberDao.signup(member);
    		// 3. 확인
    	if(result) {
    		// 1. 메세지창 출력 [Alert : 메세지(알람) 클래스]
    		Alert alert = new Alert(AlertType.INFORMATION); // 메세지 객체
    		alert.setTitle("알림"); // 메세지 제목 설정
    		alert.setHeaderText("안산시 중고거래에 가입을 축하합니다."); // 
    		alert.setContentText("회원가입이 완료되었습니다.");
    		alert.showAndWait(); // 메세지 실행
    		
    		// 2. 화면 전환 [로그인페이지로 전환]
    		Login.instance.loadpage("/view/login/loginpane.fxml");
    	} else {
    		lblconfirm.setText("DB 오류 [관리자에게 문의]");
    		return;
    	}
    }
	
}
