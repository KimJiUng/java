package application.Day22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Day22_2 {

	// 1. 필드
		private Connection connection; // 연동 객체
	// 2. 생성자
		public Day22_2() {
			try { // JAVA외 연결시 무조건 일반예외 발생
				// 1. DB 드라이브 클래스 호출 [ DB 회사마다 다름 ]
				Class.forName("com.mysql.cj.jdbc.Driver");
				// 2. DB 연결
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC", "root","1234");
					// JDBC : JAVA DATABASE CONNECTION
					// jdbc:mysql://IP주소(로컬[본인PC]이면 localhost):port번호/DB이름?DB시간설정
					// "계정명", "DB비밀번호"
				// 3. 확인
				System.out.println("DB 연동 성공");
			}catch(Exception e) {
				System.out.println("DB 연동 실패");
			}
			
			
		}
	// 3. 메소드
		// 데이터 저장 메소드
		public boolean write(String writer, String content) {
			try {
				// 1. SQL 작성 [DB에 쓰기]
				// db내 테이블에 데이터 저장 : insert into 테이블명(필드명1,필드명2) values(필드명1의 값, 필드명2의 값)
			String sql = "insert into test(writer,content) values(?,?)";
			// 2. SQL 설정 [연결된 DB에 SQL설정]
			PreparedStatement ps = connection.prepareStatement(sql);
				// PreparedStatement : 연결된 DB에서 테이블 조작(삽입, 삭제, 수정, 생성)할때 쓰는 인터페이스
			ps.setString(1, writer); // sql내 작성한 첫번째 ? 에 변수 넣기 [ 1 : 첫번째 ? ]
			ps.setString(2, content); // [ 2 : 두번째 ? ]
			// 3. SQL 실행
			ps.executeUpdate(); // sql 삽입 실행
			// * 성공시 true
			return true;
			
			} catch(Exception e) {
				System.out.println("SQL 연결 실패 사유 : "+e);
			}
			
			
			
			// * 실패시 false
			
			return false;
		}
	
		// 데이터 호출 메소드
		public ArrayList<data> get(){
			try {
				// DB에서 가져온 데이터를 저장할 리스트 선언
				ArrayList<data> datalist = new ArrayList<>();
				
				// 1. SQL 작성 [데이터 호출]
					// select *(모든필드)from 테이블명 : 모든 데이터를 가져오기
				String sql ="select*from test";
				// 2. SQL 조작 [DB와 연결된 객체와 조작인터페이스 연결]
				PreparedStatement ps = connection.prepareStatement(sql);
				// 3. SQL 실행 [ ResultSet 인터페이스 java.sql 패키지 ]
			    ResultSet rs = ps.executeQuery(); // 결과를 [한줄씩=레코드] 가져오기
			    
			    // * 결과가 하나가 아니고 여러개이므로 반복문 사용해서
			    	// 한줄씩 객체화 -> 리스트에 저장
			    while(rs.next() ) { // 다음 줄[레코드]이 있으면
			    	// 1. 한줄씩[레코드]단위 객체화
			    	data temp = new data(
			    	rs.getInt(1), // 해당 줄[레코드]의 첫번째 필드[세로]
			    	rs.getString(2),
			    	rs.getString(3)
			    	);
			    	
			    	// 2. 객체를 리스트에 담기
			    	datalist.add(temp);
			    }
			    // 반복문 종료되면 리스트 반환
			    return datalist;
				
			} catch(Exception e) {
				System.out.println("sql 연결 실패 사유 : "+e);
			}
			// * 실패시
			System.out.println("실패");
			return null;
		}
		
	
}
