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
    void accadd(ActionEvent event) {
    	Home.instance.loadpage("/view/product/productadd.fxml");
    }

    public static Product select;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 1. 모든 제품 가져오기
		ArrayList<Product> productlist = ProductDao.productDao.list();
		
		// 2. 그리드 클래스 [행/열]
		GridPane gridPane = new GridPane();
			// * 그리드 여백
			gridPane.setPadding(new Insets(10));
			// * 버튼들 여백
			gridPane.setHgap(10); // 세로여백
			gridPane.setVgap(10); // 가로여백
		// 3. 반복문
		int i=0; // 인덱스용 변수
		for(int row=0; row<productlist.size(); row++) { // 행
			
			for(int col=0; col<3; col++) { // 열
				// 1. 이미지
				ImageView imageView = new ImageView(new Image(productlist.get(i).getPimg() ) );
					imageView.setFitHeight(250); // 이미지 가로길이
					imageView.setFitWidth(200); // 이미지 세로길이
				// 2. 버튼 생성
				Button button = new Button(null, imageView);
					// * 버튼 배경제거 [transparent : 투명색]
					button.setStyle("-fx-background-color:transparent");
					// * 버튼 클릭이벤트
					button.setOnAction(e ->{
						
						// 1. 클릭한 버튼의 id 가져오기
						int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2]);
						// 2. 클릭한 제품 저장
						select = productlist.get(id);
						
					});
				gridPane.add(button, col, row); // 그리드내 해당 열번호, 행번호에 버튼 추가
//				i++;
			}
		}
		// 4.
		vbox.getChildren().add(gridPane);
		
	}
}
