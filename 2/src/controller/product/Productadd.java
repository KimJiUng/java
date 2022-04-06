package controller.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.ProductDao;
import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Productadd implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(Productview.update==true) {
			Product product = Productcontrol.select;
			btnadd.setText("수정완료");
			txtpname.setText(product.getPname());
			txtpcontent.setText(product.getPcontent());
			img.setImage(new Image(product.getPimg()));
			txtpprice.setText(Integer.toString(product.getPprice()) );
			if(product.getPcategory().equals("남성의류")) {opt1.setSelected(true);}
			if(product.getPcategory().equals("여성의류")) {opt2.setSelected(true);}
			if(product.getPcategory().equals("생활용품")) {opt3.setSelected(true);}
			if(product.getPcategory().equals("전자제품")) {opt4.setSelected(true);}
		}
		
	}
	
    @FXML
    private Button btnadd;

    @FXML
    private TextField txtpname;

    @FXML
    private TextArea txtpcontent;

    @FXML
    private TextField txtpprice;

    @FXML
    private Button btnimg;

    @FXML
    private RadioButton opt1;

    @FXML
    private ToggleGroup category;

    @FXML
    private RadioButton opt2;

    @FXML
    private RadioButton opt3;

    @FXML
    private RadioButton opt4;

    @FXML
    private ImageView img;

    @FXML
    private Button btnback;

    @FXML
    private Label txtpath;

    @FXML
    void add(ActionEvent event) {
    	if(Productview.update==true) {
    		if(pimage==null) {
    			pimage=Productcontrol.select.getPimg();
    		}
    		Alert alert = new Alert(AlertType.INFORMATION);
        	try {
        		
            	// 1. 컨트롤에 입력된 데이터 가져오기
        		int pnum = Productcontrol.select.getPnum();
            	String pname = txtpname.getText();
            	String pcontent = txtpcontent.getText();
            	int pprice = Integer.parseInt(txtpprice.getText());
            		// * 카테고리
            	String pcategory = null;
            		if(opt1.isSelected()) { // 만약에 opt1이라는 fxid의 컨트롤(라디오버튼)이 선택되었으면
            			pcategory="남성의류";
            		}
            		if(opt2.isSelected()) {pcategory="여성의류";}
            		if(opt3.isSelected()) {pcategory="생활용품";}
            		if(opt4.isSelected()) {pcategory="전자제품";}
            	int mnum = Login.member.getMnum();
            	// 2. (유효성검사)
            	if(pname.length()<1) {
            		alert.setHeaderText("제품명을 입력하셔야 합니다.");
            		alert.showAndWait();
            		return;
            	}
            	if(pcontent.length()<1) {
            		alert.setHeaderText("제품설명을 입력하셔야 합니다.");
            		alert.showAndWait();
            		return;
            	}
            	if(txtpprice.getText().length()<1) {
            		alert.setHeaderText("제품가격을 입력하셔야 합니다.");
            		alert.showAndWait();
            		return;
            	}
            	if(!(opt1.isSelected() || opt2.isSelected() || opt3.isSelected() || opt4.isSelected() ) ) {
            		alert.setHeaderText("카테고리를 선택하셔야 합니다.");
            		alert.showAndWait();
            		return;
            	}
            	// 3. 객체화
            	Product product = new Product(pnum, pname, pimage, pcontent, pcategory, pprice, 1, null, mnum);
            	boolean result = ProductDao.productDao.update(product);
            	if(result) {
            		alert.setHeaderText("수정 완료");
            		alert.showAndWait();
            		Productview.update=false;
            		Home.instance.loadpage("/view/product/product.fxml");
            	}else {
            		alert.setHeaderText("수정 실패[관리자에게 문의]");
            		alert.showAndWait();
            		Productview.update=false;
            	}
            	// 4. DB처리
            	
            	// 5. 결과처리
        	} catch(NumberFormatException e) {
        		alert.setHeaderText("제품가격은 숫자만 입력가능합니다.");
        		alert.showAndWait();
        	}
    	}else {
    		Alert alert = new Alert(AlertType.INFORMATION);
        	try {
        		
            	// 1. 컨트롤에 입력된 데이터 가져오기
            	String pname = txtpname.getText();
            	String pcontent = txtpcontent.getText();
            	int pprice = Integer.parseInt(txtpprice.getText());
            		// * 카테고리
            	String pcategory = null;
            		if(opt1.isSelected()) { // 만약에 opt1이라는 fxid의 컨트롤(라디오버튼)이 선택되었으면
            			pcategory="남성의류";
            		}
            		if(opt2.isSelected()) {pcategory="여성의류";}
            		if(opt3.isSelected()) {pcategory="생활용품";}
            		if(opt4.isSelected()) {pcategory="전자제품";}
            	int mnum = Login.member.getMnum();
            	// 2. (유효성검사)
            	if(pname.length()<1) {
            		alert.setHeaderText("제품명을 입력하셔야 합니다.");
            		alert.showAndWait();
            		return;
            	}
            	if(pcontent.length()<1) {
            		alert.setHeaderText("제품설명을 입력하셔야 합니다.");
            		alert.showAndWait();
            		return;
            	}
            	if(txtpprice.getText().length()<1) {
            		alert.setHeaderText("제품가격을 입력하셔야 합니다.");
            		alert.showAndWait();
            		return;
            	}
            	if(!(opt1.isSelected() || opt2.isSelected() || opt3.isSelected() || opt4.isSelected() ) ) {
            		alert.setHeaderText("카테고리를 선택하셔야 합니다.");
            		alert.showAndWait();
            		return;
            	}
            	// 3. 객체화
            	Product product = new Product(0, pname, pimage, pcontent, pcategory, pprice, 1, null, mnum);
            	boolean result = ProductDao.productDao.add(product);
            	if(result) {
            		alert.setHeaderText("제품 등록 완료");
            		alert.showAndWait();
            		Home.instance.loadpage("/view/product/product.fxml");
            	}else {
            		alert.setHeaderText("제품 등록 실패[관리자에게 문의]");
            		alert.showAndWait();
            	}
            	// 4. DB처리
            	
            	// 5. 결과처리
        	} catch(NumberFormatException e) {
        		alert.setHeaderText("제품가격은 숫자만 입력가능합니다.");
        		alert.showAndWait();
        	}
    	}
    	
    	
    	
    	
    }

    @FXML
    void back(ActionEvent event) {
    	if(Productview.update==true) {
    		Productview.update=false;
    		Home.instance.loadpage("/view/product/productview.fxml");
    	}else {
    		Home.instance.loadpage("/view/product/product.fxml");
    	}
    	
    }

    private String pimage = null; // 메소드밖에서 선언하는 이유 : imgadd 메소드와 add 메소드에서 사용하기 위해
    
    @FXML
    void imgadd(ActionEvent event) { // 이미지 등록버튼 클릭했을때
    	// 1. 파일 선택 클래스 객체 생성
    	FileChooser fileChooser = new FileChooser();
    	
    	// 2. 파일 선택[필터] 형식
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("이미지파일:image file", "*png","*jpg","*jpeg","*gif"));
    	
    	// 3. 새로운 stage(윈도우창)
    	File file = fileChooser.showOpenDialog(new Stage());
    		// 파일선택객체.showOpenDialog(스테이지이름);
    		// fileChooser 에서 선택한 파일을 file 클래스 객체화
    	
    	// 4. 선택한 파일의 경로 표시
    	txtpath.setText("파일 경로 : "+file.getPath());
    	txtpath.setWrapText(true);
    	// 5. 파일경로
    	pimage = file.toURI().toString();
    	//	System.out.println(file.getPath());				// 경로 구분선 : \
    	//	System.out.println(file.toURI());				// 경로 구분선 : /
    	//	System.out.println(file.toURI().toString());	// 문자열로 변환
    	
    	// 5. 미리보기 이미지컨트롤에 띄우기
    	Image image = new Image(pimage); // 해당 이미지의 경로값이 / 로 구분되어 있어야함
    	img.setImage(image);
    	
    	// * 선택한 파일을 현재 프로젝트 폴더로 복사(이동)해오기
    	try {
    		// 1. 파일 입력 스트림 [ 이동 단위 : 바이트 ]
        	FileInputStream fileInputStream = new FileInputStream(file); // file : fileChooser에서 선택된 파일 객체
        	// 2. 파일 출력 스트림
        		// 1. 새로운 경로 설정
        	File copyfile = new File("C:\\Users\\504\\git\\java\\2\\src\\img\\product\\"+file.getName());
        	FileOutputStream fileOutputStream = new FileOutputStream(copyfile);
        	// 3. 바이트 배열 선언
        	byte[] bytes = new byte[1024*1024*1024]; // 1024byte = 1KB -> 1024KB = 1MB -> 1024MB = 1GB
        	// 4. 반복문을 이용한 inputStream의 파일 스트림 모두 읽어오기
        	int size;
        	while( (size=fileInputStream.read(bytes)) >0 ) { // 읽어온 바이트가 0보다 작으면 반복문 종료
        		fileOutputStream.write(bytes, 0, size);
        	}
        	// 5. 용량 큰 경우에는 스트림 종료 필수 !
        	fileInputStream.close();
        	fileOutputStream.close();
    	// *파일명 DB 저장
        	pimage = copyfile.toURI().toString();
    	} catch(Exception e) {
    		System.out.println("파일 오류 : "+e);
    	}
    	
    	
    }

	
}
