package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Product;

public class ProductDao {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static ProductDao productDao = new ProductDao();
	
	public ProductDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
					"root","1234");
		}catch(Exception e ) { System.out.println("ProductDao 오류 : "+e);}
	}
	
	// 1. 제품 등록
	public boolean add(Product product) {
		try {
			String sql = "insert into product(pname,pimg,pcontent,pcategory,pprice,pactivation,mnum) values(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getPname());
			ps.setString(2, product.getPimg());
			ps.setString(3, product.getPcontent());
			ps.setString(4, product.getPcategory());
			ps.setInt(5, product.getPprice());
			ps.setInt(6, product.getPactivation());
			ps.setInt(7, product.getMnum());
			ps.executeUpdate();
			return true;
		} catch(Exception e) {
			System.out.println("제품등록 SQL 오류 : "+e);
		}
		
		return false;
	}
	// 2. 모든 제품 출력
	public ArrayList<Product> list(String category, String serch) {
		ArrayList<Product> productlist = new ArrayList<>();
		try {
			String sql = null;
			if(category==null && serch==null) { // 카테고리선택,검색이 없을경우
				sql = "select * from product order by pnum desc";
				ps = con.prepareStatement(sql);
			}
			else if(serch==null) { // 검색이 없을경우
				sql = "select * from product where pcategory=? order by pnum desc";
				ps = con.prepareStatement(sql);
				ps.setString(1, category);
			}else { // 검색이 있을경우						// 필드명 = 값 [=비교연산자] // 필드명 like %값% [값이 포함된 비교연산자]
				sql = "select * from product where pcategory=? and pname like '%"+serch+"%' order by pnum desc";
				ps = con.prepareStatement(sql);
				ps.setString(1, category);
			}
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Product product = new Product(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6), 
						rs.getInt(7), 
						rs.getString(8), 
						rs.getInt(9));
				productlist.add(product);
				
			}
			return productlist;
		} catch(Exception e) {
			System.out.println("제품출력 SQL 오류 : "+e);
		}
		return null;
	}
	// 3. 제품 조회
	public Product pnumserch(int pnum) {
		try {
			String sql = "select * from product where pnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pnum);
			rs = ps.executeQuery();
			if(rs.next()) {
				Product product = new Product(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6), 
						rs.getInt(7), 
						rs.getString(8), 
						rs.getInt(9));
				return product;
			}
		} catch(Exception e) {
			System.out.println("제품조회 SQL 오류 : "+e);
		}
		return null;
	}
	// 4. 제품 삭제
	public boolean delete(int pnum) {
		try {
			String sql = "delete from product where pnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pnum);
			ps.executeUpdate();
			return true;
		} catch(Exception e) {
			System.out.println("제품삭제 SQL 오류 : "+e);
		}
		return false;
	}
	// 5. 제품 수정
	public boolean update(Product product) {
		try {
			String sql = "update product set pname=?, pcontent=?, pcategory=?, pimg=?, pprice=? where pnum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getPname());
			ps.setString(2, product.getPcontent());
			ps.setString(3, product.getPcategory());
			ps.setString(4, product.getPimg());
			ps.setInt(5, product.getPprice());
			ps.setInt(6, product.getPnum());
			ps.executeUpdate();
			return true;
			
		} catch(Exception e) {
			System.out.println("제품수정 SQL 오류 : "+e);
		}
		return false;
	}
	
	// 6. 제품 판매상태 변경
	public boolean activation(int pnum) {
		try {
			String sql = "select pactivation from product where pnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pnum);
			rs = ps.executeQuery();
			if(rs.next()) { // 검색결과가 존재하면 다음 레코드 가져오기
				String usql=null;
				if(rs.getInt(1)==1) { // 현재 판매상태가 1이면
					usql = "update product set pactivation=2 where pnum=?";
				}
				else if(rs.getInt(1)==2) {
					usql = "update product set pactivation=3 where pnum=?";
				}
				else if(rs.getInt(1)==3) {
					usql = "update product set pactivation=1 where pnum=?";
				}
				ps = con.prepareStatement(usql);
				ps.setInt(1, pnum);
				ps.executeUpdate();
				return true;
			}
		} catch(Exception e) {
			System.out.println("판매상태변경 SQL 오류 : "+e);
		}
		return false;
	}
	
}
