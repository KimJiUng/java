package Day10;

import java.util.ArrayList;
import java.util.Scanner;

public class Day10_5_도서관리_리스트버전 { // c s

	
	public static void main(String[] args) { // m s
		
		// 1. 리스트[객체] 생성
		ArrayList<Book> booklist = new ArrayList<>();
	// 리스트클래스<리스트안에 저장할 클래스>
		// <클래스> : 해당 클래스의 여러 객체를 리스트에 저장
		// 길이는 가변[기본 : 10]
		
		while(true) { // 무한루프 [종료x]
			Scanner scanner = new Scanner(System.in);
			System.out.println("1.등록 2.목록 3.삭제 4.수정");
			int ch = scanner.nextInt();
			
			if(ch==1) {
				// 1. 변수 입력받기
				System.out.println("도서명 : "); String 도서명 = scanner.next();
				System.out.println("저자 : "); String 저자 = scanner.next();
				
				// 2. 객체화 [여러개 변수를 묶어서 관리]
				Book book = new Book(도서명, 저자);
				
				// 3. 배열저장[공백을 찾아서]
				booklist.add(book); // 리스트에 저장
				// .add(객체명) : 마지막 인덱스에 자동적으로 객체가 추가
				
				
				
			}
			else if(ch==2) {
				// 1.배열[null 제외] vs 리스트
				System.out.println("도서명\t저자");
				for(Book book : booklist) {
					System.out.println(book.get도서명()+"\t"+book.get저자());
				}
			}
			else if(ch==3) {
				// 1.배열[삭제 후에 뒤 인덱스 당기기] vs 리스트[자동]
				System.out.println("삭제할 도서 : "); String 도서명 = scanner.next();
				for(Book temp : booklist) {
					if(temp.get도서명().equals(도서명)) {
						booklist.remove(temp);
						break; // 삭제 성공했으면 반복문 탈출
					}
				}
			}
			else if(ch==4) {
				System.out.println("수정할 도서명 : "); String 도서명 = scanner.next();
				for(Book book : booklist) {
					if(book.get도서명().equals(도서명)) {
						System.out.println("수정 저자이름 : "); String 저자 = scanner.next();
						book.set저자(저자);
						break;
					}
				}
			}
			
		} // while end
		
		
		
		
		
	} // m e
	
	
	
} // c e
