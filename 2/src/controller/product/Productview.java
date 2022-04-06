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
		
		// 1. ��Ͽ��� ���õ� ��ǰ�� ��ü�� ȣ��
		Product product = Productcontrol.select;
		// 2. �� ��Ʈ�ѿ� �� �ֱ�
		img.setImage(new Image(product.getPimg()));
		txtpname.setText(product.getPname());
		txtpcontent.setText(product.getPcontent());
			// * õ���� ��ǥ
			DecimalFormat decimalFormat = new DecimalFormat("���� : #,### ��");
		lblpprice.setText(decimalFormat.format(product.getPprice()));
		if(product.getPactivation() == 1) {lblpactivation.setText("���� : �Ǹ���");}
		if(product.getPactivation() == 2) {lblpactivation.setText("���� : �ŷ���");}
		if(product.getPactivation() == 3) {lblpactivation.setText("���� : �ǸſϷ�");}
		lblpdate.setText(product.getPdate());
		// * ȸ�������� �̿��� ȸ�� id ã�� [DAO���� �޼ҵ� �̿�]
		lblpname.setText("��ǰ ���ȸ�� : "+MemberDao.memberDao.getmid(product.getMnum()));
		
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
    	alert.setHeaderText("���� �����Ͻðڽ��ϱ�?");
    	Optional<ButtonType> optional = alert.showAndWait();
    	if(optional.get()==ButtonType.OK) {
    		boolean result = ProductDao.productDao.delete(Productcontrol.select.getPnum());
    		if(result) {
    			Alert alert2 = new Alert(AlertType.INFORMATION);
    			alert2.setHeaderText("������ �Ϸ�Ǿ����ϴ�.");
    			alert2.showAndWait();
    			Productcontrol.select=null;
    			Home.instance.loadpage("/view/product/product.fxml");
    		}else {
    			System.out.println("�������� DB ����");
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
