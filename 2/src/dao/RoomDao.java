package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoomDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public RoomDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");
		} catch(Exception e) {
			System.out.println("RoomDao ���� : "+e);
		}			
	}
	
	
	
	
	
}
