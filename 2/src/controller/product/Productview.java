package controller.product;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.MemberDao;
import dao.ProductDao;
import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Productview implements Initializable {

	public static boolean update=false;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		txtpname.setEditable(false);
		txtpcontent.setEditable(false);
		
		if(Login.member.getMnum()==(Productcontrol.select.getMnum())) {
			
		}else {
			btndelete.setVisible(false);
			btnupdate.setVisible(false);
		}
		
		// 1. 목록에서 선택된 제품의 객체를 호출
		Product product = Productcontrol.select;
		// 2. 각 컨트롤에 값 넣기
		img.setImage(new Image(product.getPimg()));
		txtpname.setText(product.getPname());
		txtpcontent.setText(product.getPcontent());
			// * 천단위 쉼표
			DecimalFormat decimalFormat = new DecimalFormat("가격 : #,### 원");
		lblpprice.setText(decimalFormat.format(product.getPprice()));
		if(product.getPactivation() == 1) {lblpactivation.setText("상태 : 판매중");}
		if(product.getPactivation() == 2) {lblpactivation.setText("상태 : 거래중");}
		if(product.getPactivation() == 3) {lblpactivation.setText("상태 : 판매완료");}
		lblpdate.setText(product.getPdate());
		// * 회원정보를 이용한 회원 id 찾기 [DAO에서 메소드 이용]
		lblpname.setText("제품 등록회원 : "+MemberDao.memberDao.getmid(product.getMnum()));
		
	}
	
    @FXML
    private TextField txtpname;

    @FXML
    private TextArea txtpcontent;

    @FXML
    private Button btnback;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btndelete;

    @FXML
    private ImageView img;

    @FXML
    private Label lblpname;

    @FXML
    private Label lblpdate;

    @FXML
    private Label lblpactivation;
    
    @FXML
    private Label lblpprice;

    @FXML
    private TableView<?> replytable;

    @FXML
    private TextArea txtrecontent;

    @FXML
    private Button btnrewrite;

    @FXML
    void accdelete(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("정말 삭제하시겠습니까?");
    	Optional<ButtonType> optional = alert.showAndWait();
    	if(optional.get()==ButtonType.OK) {
    		boolean result = ProductDao.productDao.delete(Productcontrol.select.getPnum());
    		if(result) {
    			Alert alert2 = new Alert(AlertType.INFORMATION);
    			alert2.setHeaderText("삭제가 완료되었습니다.");
    			alert2.showAndWait();
    			Productcontrol.select=null;
    			Home.instance.loadpage("/view/product/product.fxml");
    		}else {
    			System.out.println("삭제실패 DB 오류");
    		}
    	}
    	
    }

    @FXML
    void accrewrite(ActionEvent event) {

    }

    @FXML
    void accupdate(ActionEvent event) {
    	update=true;
    	Home.instance.loadpage("/view/product/productadd.fxml");
    }

    @FXML
    void back(ActionEvent event) {
    	Home.instance.loadpage("/view/product/product.fxml");
    }
	
}
