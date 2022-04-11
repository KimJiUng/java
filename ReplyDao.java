package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.board.Boardcontroller;
import controller.login.Login;
import dto.Reply;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReplyDao {

	private Connection con; // DB 연동시 사용되는 클래스 : DB 연동 클래스
	private PreparedStatement ps; // 연결된 DB내 SQL 조작 할때 사용되는 인터페이스 : DB조작인터페이스
	private ResultSet rs; // 결과물을 조작하는 인터페이스
	
	public static ReplyDao replyDao = new ReplyDao();
	
	public ReplyDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");	
		} catch(Exception e) {
			System.out.println("Reply DB연동 실패 : "+e);
		}

	}
	
	// 댓글 작성 메소드
	public boolean wirte(Reply reply) {
		try {
			String sql = "insert into reply(rcontent,rwriter,bnum) values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, reply.getRcontent());
			ps.setString(2, reply.getRwriter());
			ps.setInt(3, reply.getBnum());
			ps.executeUpdate();
			return true;
		} catch(Exception e) {
			System.out.println("댓글쓰기 SQL 오류 : "+e);
		}
		return false;
		
	}
	
	// 댓글 불러오기 메소드
	public ObservableList<Reply> list() {
		ObservableList<Reply> replylist = FXCollections.observableArrayList();
		try {
			String sql = "select * from reply";
			ps=con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(5)==Boardcontroller.board.getBnum()) {
					Reply reply = new Reply(
							rs.getInt(1), 
							rs.getString(2), 
							rs.getString(3), 
							rs.getString(4), 
							rs.getInt(5));
					replylist.add(reply);
				}
			}
			return replylist;
		} catch(Exception e) {
			System.out.println("댓글 불러오기 SQL 오류 : "+e);
		}
		return null;
	}
	
	// 댓글 수정 메소드
	public boolean replyupdate(int rnum, String rcontent) {
		try {
			String sql = "update reply set rcontent=? where rnum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, rcontent);
			ps.setInt(2, rnum);
			ps.executeUpdate();
			return true;
		} catch(Exception e) {
			System.out.println("댓글 수정 SQL 오류 : "+e);
		}
		return false;
	}
	
	// 댓글 삭제 메소드
	public boolean replydelete(int rnum) {
		try {
			String sql = "delete from reply where rnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, rnum);
			ps.executeUpdate();
			return true;
		} catch(Exception e) {
			System.out.println("댓글삭제 SQL 오류 : "+e);
		}
		
		return false;
	}
	
}
