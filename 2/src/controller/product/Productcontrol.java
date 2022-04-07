package controller.product;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.home.Home;
import dao.ProductDao;
import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Productcontrol implements Initializable {
						// 인터페이스=구현하다
    @FXML
    private Button btnadd;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private VBox vbox;
    
    @FXML
    private TextField txtserch;

    @FXML
    private Button btnserch;
    
    @FXML
    void accserch(ActionEvent event) { // 검색 버튼 눌렀을때
    	String serch = txtserch.getText(); // 검색창에 입력된 데이터 가져오기
    	show(serch);
    	
    }

    @FXML
    void accadd(ActionEvent event) {
    	Home.instance.loadpage("/view/product/productadd.fxml");
    }

    public static Product select;
    
    void show(String serch) {
    	if(vbox.getChildren().isEmpty() == false) { // .isEmpty() : 해당 객체내 비어있는지 확인 [vbox내 비어 있는지 확인]
    		// vbox내 객체가 비어있으면 true 비어있지않으면 false
    		vbox.getChildren().remove(0); // vbox내 기존 객체 삭제
    	}
    	// 1. 모든 제품 가져오기
		ArrayList<Product> productlist = ProductDao.productDao.list(Home.category,serch);
		
		// 2. 그리드 클래스 [행/열]
		GridPane gridPane = new GridPane();
			// * 그리드 여백
			gridPane.setPadding(new Insets(10));
			// * 버튼들 여백
			gridPane.setHgap(20); // 세로여백
			gridPane.setVgap(20); // 가로여백
		// 3. 반복문
		int i=0; // 인덱스용 변수
		for(int row=0; row<productlist.size()/3; row++) { // 행		
			for(int col=0; col<3; col++) { // 열
				// 1. 이미지
				ImageView imageView = new ImageView(new Image(productlist.get(i).getPimg() ) );
					imageView.setFitHeight(250); // 이미지 가로길이
					imageView.setFitWidth(200); // 이미지 세로길이
				// 2. 버튼 생성
				Button button = new Button(null, imageView);
					// * 버튼 배경제거 [transparent : 투명색]
					button.setStyle("-fx-background-color:transparent");
					// * 버튼 id값 넣기 [제품식별 = index]
					button.setId(i+"");
					// * 버튼 클릭이벤트
					button.setOnAction(e ->{
						// 1. 클릭한 버튼의 id 가져오기
						int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2]);
						// 2. 클릭한 제품 저장
						select = productlist.get(id);
						Home.instance.loadpage("/view/product/productview.fxml");
					});
				gridPane.add(button, col, row); // 그리드내 해당 열번호, 행번호에 버튼 추가
				i++; // 인덱스 증가
			}
		}
		// * 3의배수 나머지값
		int row = productlist.size()/3; // 마지막행
		int remain = productlist.size()%3;
		if(remain !=0) {
			for(int col=0; col<remain; col++) { // 열
				// 1. 이미지
				ImageView imageView = new ImageView(new Image(productlist.get(i).getPimg() ) );
					imageView.setFitHeight(250); // 이미지 가로길이
					imageView.setFitWidth(200); // 이미지 세로길이
				// 2. 버튼 생성
				Button button = new Button(null, imageView);
					// * 버튼 배경제거 [transparent : 투명색]
					button.setStyle("-fx-background-color:transparent");
					// * 버튼 id값 넣기 [제품식별 = index]
					button.setId(i+"");
					// * 버튼 클릭이벤트
					button.setOnAction(e ->{
						// 1. 클릭한 버튼의 id 가져오기
						int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2]);
						// 2. 클릭한 제품 저장
						select = productlist.get(id);
						Home.instance.loadpage("/view/product/productview.fxml");
					});
				gridPane.add(button, col, row); // 그리드내 해당 열번호, 행번호에 버튼 추가
				i++; // 인덱스 증가
			}
		}
		// 4. vbox에 그리드 넣기
		vbox.getChildren().add(gridPane);
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		show(null); // 화면이 처음 열렸을때는 검색어에 null값 넣어주기
	}
	
	
	
}
