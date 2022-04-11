package controller;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import dao.BoardDao;
import dao.MemberDao;
import dao.ProductDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class Record implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 전체 회원수
		int mtotal = MemberDao.memberDao.membertotal();
		lblmtotal.setText(mtotal+"명");
		// 전체 제품수
		int ptotal = ProductDao.productDao.list(null, null).size();
		lblptotal.setText(ptotal+"개");
		// 전체 게시물수
		int btotal = BoardDao.boardDao.list().size();
		lblbtotal.setText(btotal+"개");
		
		// 날짜별 회원가입 수
		String a = "msince";
		String table = "member";
			// 1. x,y축 계열 생성
		XYChart.Series series = new XYChart.Series<>();
			// XYChart.Series : 계열 클래스
				// XYChart.Data : 계열데이터 클래스 [x축의 값, y축의 값]
		series.setName("날짜별 회원가입 수");
			// 2. 날짜별로 회원가입 수 체크 [2022-04-11, 3]
				// Map 컬렉션 -> 키[날짜], 값[가입자 수]으로 하나의 엔트리 구성
		Map<String, Integer> datemtotal = MemberDao.memberDao.total(a,table);
			// 3. 데이터를 계열에 추가
		for(String key : datemtotal.keySet()) { // 반복문
				// 3-1 : 데이터 계열 선언(생성자 : key=날짜, value=가입자수)
			XYChart.Data data = new XYChart.Data<>(key, datemtotal.get(key));
				// 3-2 : 해당 데이터 객체를 계열에 추가
			series.getData().add(data);
		}
			// 4. 해당 계열을 막대차트에 추가
		mbc.getData().add(series);
	
		// 날짜별 게시물 수
		XYChart.Series series2 = new XYChart.Series<>();
		series2.setName("날짜별 게시물 수");
		table = "board";
		Map<String, Integer> datebtotal = BoardDao.boardDao.datetotal(table);
		for(String key : datebtotal.keySet()) {
			XYChart.Data data = new XYChart.Data<>(key, datebtotal.get(key));
			series2.getData().add(data);
		}
		bbc.getData().add(series2);
		
		// 날짜별 제품 수
		table = "product";
		XYChart.Series series3 = new XYChart.Series<>();
		series3.setName("날짜별 제품 수");
		Map<String, Integer> dateptotal = BoardDao.boardDao.datetotal(table);
		for(String key : dateptotal.keySet()) {
			XYChart.Data data = new XYChart.Data<>(key, dateptotal.get(key));
			series3.getData().add(data);
		}
		pbc.getData().add(series3);
		
		// 원형차트 : 카테고리별 개수
		a = "pcategory";
		table = "product";
			// * ObservableList 사용이유 : 원형차트에 리스트를 추가시
			// 1. ObservableList<원형차트 데이터 자료형> 리스트명 선언
		ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
			// 2. db에서 카테고리별 개수
		Map<String, Integer> categorytotal = MemberDao.memberDao.total(a,table);
			// 3. 원형차트 데이터 추가
		for(String key : categorytotal.keySet()) {
			PieChart.Data data = new Data(key, categorytotal.get(key));
			// * 데이터를 리스트에 추가
			list.add(data);
		}
			// 4. 리스트를 원형차트에 추가
		ppc.setData(list);
		
	}
	
    @FXML
    private Label lblmtotal;

    @FXML
    private Label lblptotal;
	
    @FXML
    private Label lblbtotal;
    
    @FXML
    private BarChart mbc;

    @FXML
    private BarChart pbc;
    
    @FXML
    private BarChart bbc;
    
    @FXML
    private PieChart ppc;
	
}
