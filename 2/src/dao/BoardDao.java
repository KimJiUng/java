package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import controller.board.Boardcontroller;
import controller.login.Login;
import dto.Board;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BoardDao {
	
	// 필드
	private Connection con; // DB 연결 클래스
	private PreparedStatement ps; // 연결된 DB내 SQL 조작
	private ResultSet rs; // SQL 결과 레코드 가져오기
	
	public static BoardDao boardDao = new BoardDao();
	
	public ArrayList<String> viewlist = new ArrayList<>();
	
	// 생성자
	public BoardDao() { // 생성자에서 연동하는 이유 : 객체 생성시 바로 DB와 연동하기 위해
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");
			
		} catch(Exception e) {
			System.out.println("(BoardDao)DB 연동 실패 : "+e);
		}
	}
	
	// 메소드
		// 1. 글쓰기 메소드
	public boolean write(Board board) {
		try {
			String sql = "insert into board(btitle, bcontent,bwrite,mnum) values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setString(3, board.getBwrite());
			ps.setInt(4, board.getMnum());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("글쓰기 SQL 오류 : "+e);
		}
		return false;
	}
	
		// 2. 모든 글 호출 메소드
	public ObservableList<Board> list() {
		try {
			ObservableList<Board> boardlist = FXCollections.observableArrayList();
			String sql = "select * from board order by bnum desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				// rs : 검색결과의 레코드를 하나씩 순환 
					// rs.next() : 검색결과의 다음 레코드
					// rs.get자료형(해당필드순서번호) : 현 레코드에서 해당 필드의 데이터 가져오기
			while(rs.next()) { // 다음 레코드가 없을때까지 반복
				// 객체화
				
				Board board = new Board(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6),
						rs.getInt(7));
				// 리스트에 추가
				boardlist.add(board);
			}
			return boardlist; // 성공시 리스트 반환
		} catch(Exception e){
			System.out.println("호출 SQL 오류 : "+e);
		}
		return null; // 실패시 null
	}
	
		// 3. 글 삭제 메소드
	public boolean delete(int bnum) {
		try {
			String sql = "delete from board where bnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bnum);
			ps.executeUpdate();
			
			String sql2 = "delete from reply where bnum=?";
			ps=con.prepareStatement(sql2);
			ps.setInt(1, bnum);
			ps.executeUpdate();
			
			return true;
		} catch(Exception e) {
			System.out.println("글삭제 SQL 오류 : "+e);
		}
		return false;
	}
	
		// 4. 글 수정 메소드
	public boolean update(int bnum, String title, String content) {
		try {
			String sql = "update board set btitle=?, bcontent=? where bnum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, bnum);
			ps.executeUpdate();
			return true;
		} catch(Exception e) {
			System.out.println("글 수정 SQL 오류 : "+e);
		}
		return false;
	}
	
		// 5. 조회수 증가 메소드
	public boolean viewplus() {
		try {
			load();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String now = Login.member.getMid()+format.format(new Date())+Boardcontroller.board.getBnum();
			if(Boardcontroller.board!=null) {
				boolean p = false;
				for(int i=0; i<viewlist.size(); i++) {
					if(viewlist.get(i).equals(now)) {
						p=true;
					}
				}
				if(p==true) {

				}else {
					Boardcontroller.board.setBview(Boardcontroller.board.getBview()+1);
					i = Login.member.getMid()+format.format(new Date())+Boardcontroller.board.getBnum();
					save();
				}
				String sql = "update board set bview=? where bnum=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, Boardcontroller.board.getBview());
				ps.setInt(2, Boardcontroller.board.getBnum());
				ps.executeUpdate();
			}
			
			return true;
		} catch(Exception e) {
			System.out.println("조회수 SQL 오류 : "+e);
		}
		return false;
	}
	
	public String i;
	// 파일 저장
	public void save() {
			
		try {
			FileOutputStream outputStream = new FileOutputStream("D:/java/조회수.txt", true);
			String a = i+"\n";
			outputStream.write(a.getBytes());
			
		}catch(Exception e) {
			System.out.println("알림)) 파일 저장 실패(관리자에게 문의)");
		}
	}
	// 파일 불러오기
	public void load() {
		try {
			FileInputStream fileInputStream = new FileInputStream("D:/java/조회수.txt");
			byte[] bytes = new byte[1024];
			fileInputStream.read(bytes);
			String file = new String(bytes);
			String[] view = file.split("\n");
			
			int i=0; // 인덱스용
			for(String temp : view) { 
				if(i+1==view.length) break;			
				viewlist.add(temp);
				i++; // 인덱스 증가
			}
			
		} catch(Exception e) {
			System.out.println("알림)) 파일 로드 실패(관리자에게 문의)");
		}
	}
	
	// 6. 날짜별 게시물 수 반환
	public Map<String, Integer> datetotal(String table){
		try {
			Map<String, Integer> map = new HashMap<>();
			String sql = "SELECT substring_index("+table.charAt(0)+"date,' ',1), "
					+ "count(*) FROM "+table+" group by "
					+ "substring_index("+table.charAt(0)+"date,' ',1) ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				map.put(rs.getString(1), rs.getInt(2));
			}
			return map;
		}catch(Exception e) {
			System.out.println("날짜별 게시물 수 반환 오류 : "+ e);
		}
		return null;
	}

	
	
}
