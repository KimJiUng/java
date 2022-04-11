package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Room;
import dto.Roomlive;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RoomDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static ArrayList<Room> mcountlist = new ArrayList<>();
	
	public static RoomDao roomDao = new RoomDao();
	
	public RoomDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");
		} catch(Exception e) {
			System.out.println("RoomDao 오류 : "+e);
		}			
	}
	
	// 1. 방 저장 메소드
	public boolean roomadd(Room room) {
		try {
			String sql = "insert into room(roomname,roomip) values(?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, room.getRoomname());
			ps.setString(2, room.getRoomip());
			ps.executeUpdate();
			return true;
		} catch(Exception e) {
			System.out.println("roomadd error : "+ e);
		}
		return false;
	}
	
	// 2. 방번호[=포트번호] 호출 메소드
	public int getroomnum() {
		try {
			// 가장 최근에 등록된 방 번호 가져오기
			String sql = "select max(roomnum) from room"; // max(필드명) : 해당 필드의 가장 최근값
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch(Exception e) {
			System.out.println("getroomnum error : "+e);
		}
		return 0;
	}
	
	// 3. 모든 방 호출 메소드 [tableview -> observableList]
	public ObservableList<Room> roomlist(){
		ObservableList<Room> roomlist = FXCollections.observableArrayList();
		try {
			String sql = "select * from room order by roomnum desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Room room = new Room(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						0);
				roomlist.add(room);
			}
			return roomlist;
		} catch(Exception e){
			System.out.println("roomlist error : "+e);
		}
		return null;
	}
	
	// 4. 채팅방 접속 명단 추가
	public boolean addroomlive(Roomlive roomlive) {
		try {
			String sql = "insert into roomlive(roomnum,mid)values(?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, roomlive.getRoomnum());
			ps.setString(2, roomlive.getMid());
			ps.executeUpdate();
			return true;
		} catch(Exception e) {
			System.out.println("채팅방 접속명단 추가 오류 : "+e);
		}
		return false;
	}
	
	// 5. 채팅방 접속된 모든 명단 호출
	public ArrayList<Roomlive> getRoomlivelist(int roomnum){
		ArrayList<Roomlive> roomlivelist = new ArrayList<>();
		try {
			String sql = "select * from roomlive where roomnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, roomnum);
			rs = ps.executeQuery();
			int i=0;
			while(rs.next()) {
				
				Roomlive roomlive = new Roomlive(rs.getInt(1), rs.getInt(2), rs.getString(3));
				roomlivelist.add(roomlive);
				i++;
			}
			Room room = new Room(roomnum, i);
			mcountlist.add(room);
			return roomlivelist;
		} catch(Exception e) {
			System.out.println("채팅방 명단 호출 메소드 오류 : "+e);
		}
		return null;
	}
	
	// 6. 채팅방 접속 명단 삭제
	public boolean roomlivedelete(String mid) {
		try {
			String sql = "delete from roomlive where mid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.executeUpdate();
			return true;
		} catch(Exception e) {
			System.out.println("채팅방 접속 명단 삭제 오류 : "+e);
		}
		return false;
	}
	
	// 7. 채팅방 삭제 [조건 : 해당방의 접속명단이 0명일때]
	public boolean roomdelete(int roomnum) {
		try {
			String sql = "select * from roomlive where roomnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, roomnum);
			rs = ps.executeQuery();
			if(rs.next()) {
				return false;
			}else {
				String sql2 = "delete from room where roomnum=?";
				ps = con.prepareStatement(sql2);
				ps.setInt(1, roomnum);
				ps.executeUpdate();
				return true;
			}
		} catch(Exception e) {
			System.out.println("채팅방 삭제 오류 : "+e);
		}
		return false;
	}
	
	
	
}
