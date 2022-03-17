package Day12;

import java.util.Arrays;

public class Day12_3 { // c s

	public static void main(String[] args) { // m s
		
		// 도서 검색 프로그램
			// [조건]
			// 1. 입력받기 [ System.in.read() ]
			// 2. String 배열을 이용한 도서명을 여러개 저장
				// String[] 도서목록 = {	
				//	"된다! 네이버 블로그&포스트",
				//	"스프링 부트 실전 활용 마스터",
				//	"Tucker의 Go 언어 프로그래밍",
				//	"혼자 공부하는 C 언어"
			// 3. 검색기능 , 수정기능
				// 검색기능 : 특정 문자를 입력받아 도서내 포함된 문자가 있으면 모두 출력
					// '언어' 검색 -> "혼자 공부하는 C 언어" , "Tucker의 Go 언어 프로그래밍"
					// '수정' 수정 -> 선택된 도서명의 수정할 문자와 새로운 문자 입력받아 -> 수정 완료
		
		String[] book = new String[4];
		byte[] bytes = new byte[100];
		book[0] = "된다! 네이버 블로그&포스트";
		book[1] = "스프링 부트 실전 활용 마스터";
		book[2] = "Tucker의 Go 언어 프로그래밍";
		book[3] = "혼자 공부하는 C 언어";
		
		while(true) {
			try {
				System.out.println("---------------------도서 검색 프로그램---------------------");
				System.out.println("도서번호\t도서명");
				for(int i=0; i<book.length; i++) {
					
					System.out.println(i+"\t"+book[i]);
				}
				System.out.println("------------------------------------------------------");
				System.out.println("메뉴 : 1. 도서검색 2. 도서수정");
				int count = System.in.read(bytes);
				String ch = new String(bytes,0,count-2);
				if(ch.equals("1")) {
					System.out.print("도서 검색 : "); int serch = System.in.read(bytes);
					
					String serchbook = new String(bytes,0,serch-2);
					
					System.out.println("---------------------검색 결과---------------------------");
					
					System.out.println("도서번호\t도서명");
					for( int i=0; i<book.length; i++) {
						
						if(book[i].indexOf(serchbook)!=-1) {
							
							System.out.println(i+"\t"+book[i]);
						}
					}
				} // if end
				else if(ch.equals("2")) {
					System.out.println("수정할 도서 번호 입력 : ");
					int update = System.in.read(bytes);
					String num = new String(bytes, 0, update-2);
					
					System.out.println("기존 문자 입력 : "); 
					int update2 = System.in.read(bytes);
					String oldbook = new String(bytes,0,update2-2);
					boolean check = false;	
						if(book[Integer.parseInt(num)].indexOf(oldbook)!=-1) {
							System.out.println("새로운 문자 입력 : ");
							int update3 = System.in.read(bytes);
							String newbook = new String(bytes,0,update3-2);
							
							book[Integer.parseInt(num)] = book[Integer.parseInt(num)].replace(oldbook, newbook);
							System.out.println("수정이 완료되었습니다.");
							check = true;
							
						}
					if(check==false) System.out.println("입력한 문자가 존재하지 않습니다.");
					
					
				}
				else System.out.println("잘못된 입력입니다.");
				
			
			} catch(Exception e) {
				System.out.println("잘못된 입력입니다.");
			}
			
		} // while end
		
		
		
		
	} // m e
	
	
} // c e
