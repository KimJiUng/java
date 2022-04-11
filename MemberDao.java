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

import controller.login.Login;
import dto.Member;



public class MemberDao { // DB 접근객체
	
	private Connection con; // DB 연동시 사용되는 클래스 : DB 연동 클래스
	private PreparedStatement ps; // 연결된 DB내 SQL 조작 할때 사용되는 인터페이스 : DB조작인터페이스
	private ResultSet rs; // 결과물을 조작하는 인터페이스
	
	public static MemberDao memberDao = new MemberDao(); // DB 연동 객체;
	public static ArrayList<String> pointlist = new ArrayList<>();
	public MemberDao() {
		try {
			// DB 연동
				// 1. DB 드라이버 가져오기
			Class.forName("com.mysql.cj.jdbc.Driver");
				// 2. DB 주소 연결
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC", "root", "1234");
			
			
			
		} catch(Exception e) {
			System.out.println("DB연동 실패 : "+ e);
		}

	}
	
	// 메소드
		
		// *아이디 중복체크 메소드(인수 : 아이디를 인수로 받아 DB에 존재하는지 체크)
	public boolean idcheck(String id) {
		try {
			// 1. SQL 작성
				// 검색 : select * from 테이블명 where 조건(필드명=값)
			String sql = "select * from member where mid=?";
			// 2. SQL 조작
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			// 3. SQL 실행
			rs = ps.executeQuery(); // select 실행 -> 검색은 결과물 존재 -> resultset o
				// resultset 처음 기본값 : null ----next()---> 결과 레코드
			// 4. SQL 결과
			if(rs.next()) { // 만약에 다음 결과물이 존재하면 -> 해당 아이디가 존재 -> 중복
				return true; // 아이디 중복
			}
		}catch(Exception e) {
			System.out.println("SQL 오류 : "+e);
		}
			
		return false; // 중복 존재하지 않음
	}
	
		// 1. 회원가입 메소드 (인수 : DB에 넣을 아이디,비밀번호,이메일주소)
	public boolean signup(Member member) {
		try {
			// 1. SQL 작성 [회원번호(자동번호=auto) 제외한 모든 필드 삽입]
			String sql = "insert into member(mid, mpassword, memail, maddress, mpoint, msince) values(?,?,?,?,?,?)";
			// 2. SQL 조작
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMid()); // 1번 ?에 아이디 넣어주기
			ps.setString(2, member.getMpassword()); // 2번 ?에 비밀번호 넣어주기
			
			ps.setString(3, member.getMemail()); // 3번 ?에 이메일 넣어주기
			ps.setString(4, member.getMaddress()); // 4번 ?에 주소 넣어주기
			ps.setInt(5, member.getMpoint()); // 5번 ?에 포인트 넣어주기
			ps.setString(6, member.getMsince()); // 6번 ?에 가입일 넣어주기
			// 3. SQL 실행
			ps.executeUpdate(); // insert 실행
			return true;
			
		} catch(Exception e) {
			System.out.println("SQL 오류 : "+e);
		}

		
		return false;
	}
		// 2. 로그인 메소드 (인수 : 로그인시 필요한 아이디,비밀번호)
	public boolean login(String id, String password) {
		try {
			// 1. SQL 작성
				// and = &&
				// or = ||
			String sql = "select * from member where mid=? and mpassword=?";
			// 2. SQL 조작
			ps = con.prepareStatement(sql);
			ps.setString(1, id); // 첫번째 ?에 id 변수 넣기
			ps.setString(2, password); // 두번째 ?에 password 변수 넣기
			// 3. SQL 실행
			rs = ps.executeQuery(); // select 실행
			// 4. SQL 결과
			if(rs.next()) { // select시 결과물이 있으면
				return true; // 아이디와 비밀번호가 동일하면 -> 로그인 성공
			}
		} catch(Exception e) {
			System.out.println("SQL 오류 : "+e);
		}
		return false; // 로그인 실패
	}
		// 3. 아이디찾기 메소드 (인수 : 아이디찾기시 필요한 이메일)
	public String findid(String email) {
		try {
			// 1. SQL 작성
			String sql = "select * from member where memail=?";
			// 2. SQL 조작
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			// 3. SQL 실행
			rs = ps.executeQuery();
			// 4. SQL 결과
			if(rs.next()) {
				
				return rs.getString(2);
			}
		} catch(Exception e) {
			System.out.println("SQL 오류 : "+e);
		}
		
		
		return null;
	}
		// 4. 비밀번호찾기 메소드 (인수 : 비밀번호찾기시 필요한 이메일, 아이디)
	public String findpw(String email, String id) {
		try {
			// 1. SQL 작성
			String sql = "select * from member where memail=? && mid=?";
			// 2. SQL 조작
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, id);
			// 3. SQL 실행
			rs = ps.executeQuery();
			// 4. SQL 결과
			if(rs.next()) {
				
				return rs.getString(3);
			}
		} catch(Exception e) {
			System.out.println("SQL 오류 : "+e);
		}
		
		return null;
	}
	
	// 5. 아이디로 회원정보 호출
	public Member getMember(String id) {
		try {
			// 1. SQL 작성
			String sql = "select * from member where mid=?";
			// 2. SQL 조작
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			// 3. SQL 실행
			rs = ps.executeQuery();
			// 4. SQL 결과
			if(rs.next()) {
				// 1. 객체선언
				Member member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
				// rs.next() : 결과내 다음 레코드(줄,가로)
				// rs.getInt(필드순서번호) : 해당 필드의 자료형이 정수형으로 가져오기
				// rs.getString(필드순서번호) : 해당 필드의 자료형이 문자열로 가져오기
				// 2. 반환
				return member;
			}
			
			
		} catch(Exception e) {
			System.out.println("SQL 오류 : "+e);
		}
		return null;
		
		
	}
	// 6. 회원탈퇴 [ 회원번호를 인수로 받아 해당 회원번호의 레코드 삭제 ]
	public boolean delete(int num) {
		try {
			// 1. SQL 작성
					// 레코드 삭제 : delete from 테이블명 where 조건
			String sql = "delete from member where mnum=?";
			// 2. SQL 조작
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			// 3. SQL 실행
			ps.executeUpdate();
			// 4. SQL 결과
			return true;
		} catch(Exception e) {
			System.out.println("SQL 오류 : "+e);
		}
		return false;
	}
	// 7. 회원정보수정
	public boolean modify(String pw, String newpw, String newpwcheck, String newemail, String newaddress) {
		try {
						// 수정 : update 테이블명 set 필드명1=수정값1, 필드명2=수정값2 where 조건
			String sql2 = "update member set mpassword=?,memail=?,maddress=? where mnum=?";
			ps = con.prepareStatement(sql2);
			ps.setString(1, newpw);
			ps.setString(2, newemail);
			ps.setString(3, newaddress);
			ps.setInt(4, Login.member.getMnum());
			ps.executeUpdate();
			return true;

		} catch(Exception e) {
			System.out.println("!!!! " + e);
		}
		return false;
	}
	
	
	
	
	// 8. 로그인시 포인트+10
	public boolean pointplus() {
		try {
			load();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			String now =Login.member.getMid()+format.format(new Date());
			String sql = "update member set mpoint=? where mnum=?";
			ps = con.prepareStatement(sql);
			boolean p = false;
			for(int i=0; i<pointlist.size(); i++) {
				if(pointlist.get(i).equals(now)) {
					p=true;
				}
			}
			if(p==true) {
				ps.setInt(1, Login.member.getMpoint());
			}else {
				ps.setInt(1, (Login.member.getMpoint()+10));
				i = Login.member.getMid()+format.format(new Date());
				save();
			}
			ps.setInt(2, Login.member.getMnum());
			ps.executeUpdate();
			
			
			return true;
		} catch(Exception e) {
			System.out.println("sql 오류 : "+ e);
		}
		return false;
	}
	
	public static String i;
	
	// 파일 저장
	public static void save() {
		
		try {
			FileOutputStream outputStream = new FileOutputStream("D:/java/포인트.txt", true);
			String a = i+"\n";
			outputStream.write(a.getBytes());
			
		}catch(Exception e) {
			System.out.println("알림)) 파일 저장 실패(관리자에게 문의)");
		}
	}
	// 파일 불러오기
	public static void load() {
		try {
			FileInputStream fileInputStream = new FileInputStream("D:/java/포인트.txt");
			byte[] bytes = new byte[1024];
			fileInputStream.read(bytes);
			String file = new String(bytes);
			String[] point = file.split("\n");

			int i=0; // 인덱스용
			for(String temp : point) { 
				if(i+1==point.length) break;			
				pointlist.add(temp);
				i++; // 인덱스 증가
			}
			
		} catch(Exception e) {
			System.out.println("알림)) 파일 로드 실패(관리자에게 문의)");
		}
	}
	
	// 9. 해당 회원번호로 해당 id 찾기
	public String getmid(int mnum) {
		try {
			String sql = "select mid from member where mnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, mnum);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch(Exception e) {
			System.out.println("회원id찾기 SQL 오류 : "+e);
		}
		return null;
	}
	
	// 10. 전체 회원수 반환
	public int membertotal() {
		try {
			String sql = "select count(*) from member"; 
							// count(*) : 모든 레코드 수(공백포함)
							// count(필드명) : 모든 레코드 수(공백미포함)
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch(Exception e) {
			System.out.println("전체 회원수 반환 오류 : "+e);
		}
		return 0;
	}
	
	// 11. 날짜별 회원가입 수 반환
	public Map<String, Integer> total(String a, String table) {
		try {
			Map<String , Integer> map = new HashMap<>();
			String sql = "select "+a+", count(*) from "+table+" group by "+a;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				map.put(rs.getString(1), rs.getInt(2));
			}
			return map;
		} catch(Exception e) {
			System.out.println("날짜별 회원가입수 반환 오류 : "+e);
		}
		return null;
	}
	


}
