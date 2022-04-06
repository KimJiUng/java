package controller.home;

import java.net.URL;
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
		for(int i=0; i<ProductDao.productDao.list().size(); i++) {
			if(Login.member.getMnum()==ProductDao.productDao.list().get(i).getMnum()) {
				pboardlist.add(ProductDao.productDao.list().get(i));
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
		tc2.setCellValueFactory(new PropertyValueFactory<>("pname"));
		
		tc2 = pboardtable.getColumns().get(2);
		tc2.setCellValueFactory(new PropertyValueFactory<>("pprice"));
		
		tc2 = pboardtable.getColumns().get(3);
		tc2.setCellValueFactory(new PropertyValueFactory<>("pdate"));

		
		boardtable.setItems(boardlist);
		pboardtable.setItems(pboardlist);
		
		boardtable.setOnMouseClicked(e ->{
			Boardcontroller.board = boardtable.getSelectionModel().getSelectedItem();
			Home.instance.loadpage("/view/board/boardview.fxml");
		});
		pboardtable.setOnMouseClicked(e ->{
			Productcontrol.select = pboardtable.getSelectionModel().getSelectedItem();
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
