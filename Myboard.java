package controller.home;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.Main;
import controller.board.Boardcontroller;
import controller.login.Login;
import controller.product.Productcontrol;
import dao.BoardDao;
import dao.ProductDao;
import dto.Board;
import dto.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Myboard implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Board> boardlist = FXCollections.observableArrayList();
		ObservableList<Product> pboardlist = FXCollections.observableArrayList();
		for(int i=0; i<BoardDao.boardDao.list().size(); i++) {
			if(Login.member.getMnum()==BoardDao.boardDao.list().get(i).getMnum()) {
				boardlist.add(BoardDao.boardDao.list().get(i));
			}
		}
		ArrayList<Product> pd = ProductDao.productDao.list(null,null);
		for(int i=0; i<pd.size(); i++) {
			if(Login.member.getMnum()==pd.get(i).getMnum()) {
				if(pd.get(i).getPactivation()==1) {
					Product product = new Product(pd.get(i).getPnum(), 
							pd.get(i).getPname(), 
							"판매중", 
							pd.get(i).getPcontent(), 
							pd.get(i).getPcategory(), 
							pd.get(i).getPprice(), 
							pd.get(i).getPactivation(), 
							pd.get(i).getPdate(), 
							pd.get(i).getPnum());
					pboardlist.add(product);
				}
				else if(pd.get(i).getPactivation()==2) {
					Product product = new Product(pd.get(i).getPnum(), 
							pd.get(i).getPname(), 
							"거래중", 
							pd.get(i).getPcontent(), 
							pd.get(i).getPcategory(), 
							pd.get(i).getPprice(), 
							pd.get(i).getPactivation(), 
							pd.get(i).getPdate(), 
							pd.get(i).getPnum());
					pboardlist.add(product);
				}
				else if(pd.get(i).getPactivation()==3) {
					Product product = new Product(pd.get(i).getPnum(), 
							pd.get(i).getPname(), 
							"판매완료", 
							pd.get(i).getPcontent(), 
							pd.get(i).getPcategory(), 
							pd.get(i).getPprice(), 
							pd.get(i).getPactivation(), 
							pd.get(i).getPdate(), 
							pd.get(i).getPnum());
					pboardlist.add(product);
				}
			}
		}
		
		TableColumn tc = boardtable.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("bnum"));
		
		tc = boardtable.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		
		tc = boardtable.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("bdate"));
		
		tc = boardtable.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("bview"));
		
		TableColumn tc2 = pboardtable.getColumns().get(0);
		tc2.setCellValueFactory(new PropertyValueFactory<>("pnum"));
		
		tc2 = pboardtable.getColumns().get(1);
		tc2.setCellValueFactory(new PropertyValueFactory<>("pcategory"));
		
		tc2 = pboardtable.getColumns().get(2);
		tc2.setCellValueFactory(new PropertyValueFactory<>("pname"));
		
		tc2 = pboardtable.getColumns().get(3);
		tc2.setCellValueFactory(new PropertyValueFactory<>("pprice"));
		
		tc2 = pboardtable.getColumns().get(4);
		tc2.setCellValueFactory(new PropertyValueFactory<>("pimg"));
		
		tc2 = pboardtable.getColumns().get(5);
		tc2.setCellValueFactory(new PropertyValueFactory<>("pdate"));

		
		boardtable.setItems(boardlist);
		pboardtable.setItems(pboardlist);
		
		boardtable.setOnMouseClicked(e ->{
			Boardcontroller.board = boardtable.getSelectionModel().getSelectedItem();
			Home.instance.loadpage("/view/board/boardview.fxml");
		});
		pboardtable.setOnMouseClicked(e ->{
			int selectpnum = pboardtable.getSelectionModel().getSelectedItem().getPnum();
			Home.category = pboardtable.getSelectionModel().getSelectedItem().getPcategory();
			Product result = ProductDao.productDao.pnumserch(selectpnum);
			Productcontrol.select = result;
			Home.instance.loadpage("/view/product/productview.fxml");
		});
		
		
	}
	
    @FXML
    private Button btnback;
    	
    @FXML
    private TableView<Product> pboardtable;

    @FXML
    private TableView<Board> boardtable;

    @FXML
    void accback(ActionEvent event) {
    	Main.instance.loadpage("/view/home/home.fxml");
    }
}
