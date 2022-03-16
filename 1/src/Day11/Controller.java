package Day11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;



public class Controller { // c s
	
	// 모든 메소드는 static 
	
	// 게시물 리스트
	public static ArrayList<Board> boardlist = new ArrayList<>();
	// 댓글 리스트
	public static ArrayList<Reply> replist = new ArrayList<>();

	
	
	// 2. 쓰기메소드
	public static void write(String title, String content, String writer, String pw) {
		// 1. 객체화
		Board board = new Board(title, content, pw, writer);
		// 2. 리스트에 저장 
		boardlist.add(board);
		// 3. 파일에 저장
		boardsave();
	}	
	
	// 4. 수정메소드
	public static boolean update(int ch3, String pw, String title, String content) {
		if(boardlist.get(ch3).getPw().equals(pw)) {
			boardlist.get(ch3).setTitle(title);
			boardlist.get(ch3).setContent(content);
			boardsave();
			return true;
		}
		else return false;
	}
	// 5. 삭제메소드
	public static boolean delete(int ch3, String pw) {
		if(boardlist.get(ch3).getPw().equals(pw)) {
			boardlist.remove(ch3);
			boardsave();
			return true;
		}
		else return false;
	}
	// 6. 댓글쓰기메소드
	public static void replywrite(int ch3, String content, String writer, String pw) {
		
		Reply reply = new Reply(content, pw, writer,ch3);
		replist.add(reply);
		replysave();
		
	}
	// 7. 게시물 저장/수정 메소드
	public static void boardsave() {
		
		// 리스트내 모든 게시물을 파일에 저장
		try {
			// 1. 파일출력 클래스
			FileOutputStream outputStream = new FileOutputStream("D:/java/게시물파일.txt");
			// 2. 파일에 작성할 내용 [ 한줄씩 = 게시물 1개씩 = 객체 1개씩 ]
			for(Board board : boardlist) {
				String 작성내용 = board.getTitle()+","+board.getContent()+","+board.getPw()+","
						+board.getWriter()+","+board.getViewcount()+","+board.getDate()+"\n";
			// 3. 내용[문자열] -> 바이트열 변환 [ 외부통신(스트림) : 통신단위 : 바이트 ]
			// 4. 내보내기 [ write() ]
				outputStream.write(작성내용.getBytes());
			}
		}catch(Exception e) {
			System.out.println("알림)) 파일 저장 실패(관리자에게 문의)");
		}
	}
	// 8. 게시물불러오기메소드 [프로그램 시작] 파일 --> 리스트
	public static void boardload() {
		try {
			// 1. 파일 입력 클래스
			FileInputStream fileInputStream = new FileInputStream("D:/java/게시물파일.txt");
			// 2. 바이트 배열 선언
			byte[] bytes = new byte[1024];
			// 3. 모든 바이트 읽어와서 바이트에 저장
			fileInputStream.read(bytes);
			// 4. 바이트 -> 문자열 변환
			String file = new String(bytes);
			// 5. 문자열 자르기 [ 한줄씩(\n) -> 1개객체 ]
			String[] boards = file.split("\n");
			// 6. 문자열 자르기 [ (,) -> 각 필드 ]
			int i=0; // 인덱스용
			for(String temp : boards) { 
				if(i+1==boards.length) break;			
				String[] field = temp.split(",");
				// 7. 객체화
				Board board = new Board(field[0], field[1], field[2], field[3],Integer.parseInt(field[4]),field[5], null);
				// 8. 리스트 담기
				boardlist.add(board);
				i++; // 인덱스 증가
			}
			
		} catch(Exception e) {
			System.out.println("알림)) 파일 로드 실패(관리자에게 문의)");
		}
	}
	// 9. 댓글저장메소드
	public static void replysave() {
		// 리스트내 모든 게시물을 파일에 저장
				try {
					// 1. 파일출력 클래스
					FileOutputStream outputStream = new FileOutputStream("D:/java/댓글파일.txt");
					// 2. 파일에 작성할 내용 [ 한줄씩 = 댓글 1개씩 = 객체 1개씩 ]
					for(Reply reply : replist) {
						String 작성내용 = reply.getContent()+","+reply.getPw()+","+reply.getWriter()+","+reply.getDate()+","+reply.getIndex()+"\n";
					// 3. 내용[문자열] -> 바이트열 변환 [ 외부통신(스트림) : 통신단위 : 바이트 ]
					// 4. 내보내기 [ write() ]
						outputStream.write(작성내용.getBytes());
					}
				}catch(Exception e) {
					System.out.println("알림)) 댓글 저장 실패(관리자에게 문의)");
				}
	}
	// 10. 댓글불러오기메소드
	public static void replyload() {
		try {
			// 1. 파일 입력 클래스
			FileInputStream fileInputStream = new FileInputStream("D:/java/댓글파일.txt");
			// 2. 바이트 배열 선언
			byte[] bytes = new byte[1024];
			// 3. 모든 바이트 읽어와서 바이트에 저장
			fileInputStream.read(bytes);
			// 4. 바이트 -> 문자열 변환
			String file = new String(bytes);
			// 5. 문자열 자르기 [ 한줄씩(\n) -> 1개객체 ]
			String[] replis = file.split("\n");
			// 6. 문자열 자르기 [ (,) -> 각 필드 ]
			int i=0; // 인덱스용
			for(String temp : replis) { 
				if(i+1==replis.length) break;			
				String[] field = temp.split(",");
				// 7. 객체화
				Reply reply = new Reply(field[0], field[1], field[2], field[3],Integer.parseInt(field[4]));
				// 8. 리스트 담기
				replist.add(reply);
				i++; // 인덱스 증가
			}
			
		} catch(Exception e) {
			System.out.println("알림)) 파일 로드 실패(관리자에게 문의)");
		}
	}
	
	// 11. 댓글 수정메소드
		public static boolean replyupdate(int ch4, String pw, String content) {
			if(replist.get(ch4).getPw().equals(pw)) {
				replist.get(ch4).setContent(content);
				replysave();
				return true;
			}
			else return false;
		}
		// 12. 댓글 삭제메소드
		public static boolean replydelete(int ch4, String pw) {
			if(replist.get(ch4).getPw().equals(pw)) {
				replist.remove(ch4);
				replysave();
				return true;
			}
			else return false;
		}
	
	
	
	
	
} // c e
