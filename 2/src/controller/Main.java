package controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable {
					// Initializable : view �� �������� �ʱⰪ ���� �޼ҵ� ����

    @FXML
    private BorderPane borderpane; // fx:id
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { // �ش� fxml�� �������� �ʱⰪ
		loadpage("/view/login.fxml"); // loadpage �޼ҵ� ȣ��( ��Ű��/���ϸ� )
	}
	
	public void loadpage(String page) { // loadpage(���ϰ��)
		try {
			// ������(fxml) ��üȭ
			Parent parent = FXMLLoader.load(getClass().getResource(page)); // ������ ����ó��
			borderpane.setCenter(parent); // �����̳� ����� ������ �ֱ�
		} catch (Exception e) {
			System.out.println("������ ���� ���� ���� : "+e);
		} 
	}
	
	
	
}
