package Day05;

import java.util.Scanner;

import javax.swing.BoundedRangeModel;

public class Day05_2 { // c s

	public static void main(String[] args) { // m s
		
		// 회원제 방문록 프로그램 [2차원배열]
			// 1. 초기메뉴[1. 회원가입 2.로그인]
				// 1. 회원가입 [아이디, 비밀번호, 이름]
				// 2. 로그인 [아이디, 비밀번호 동일하면 로그인처리]
			// 2. 로그인시 메뉴 [1.방문록쓰기 2.로그아웃]
				// 1. 방문록쓰기 [제목, 내용, 작성자(로그인된아이디)]
				// 2. 로그아웃 [로그아웃시 초기메뉴로 돌아가기]
		
		// 준비[전역변수]
		Scanner scanner = new Scanner(System.in);
			// 회원 100명[id,pw,name] 저장하는 배열
		String[][] memberlist = new String[100][3]; // 100행 3열 => 회원당 1행 [1열=id][2열=pw][3열=이름]
			// 방문록 100개[title, contents, writer] 저장하는 배열
		String[][] boardlist = new String[100][3]; // 게시물당 1행
		
		// 초기메뉴
		while(true) { // 무한루프 [종료 x]
			System.out.println("------------------------------------");
			System.out.println("-------------회원제 방문록--------------");
			System.out.println("------------------------------------");
			System.out.println("1.회원가입 2.로그인 		선택 : ");
			int ch = scanner.nextInt();
			
			if(ch==1) { // 회원가입
				System.out.println("아이디 : "); String id = scanner.next();
				System.out.println("비밀번호 : "); String pw = scanner.next();
				System.out.println("이름 : "); String name = scanner.next();
				// String 3개 변수를 입력받아 memberlist 2차원 배열에 저장
					// 1. 빈 공간[객체(문자열)=null, 정수=0, 실수=0.0]을 찾아서 저장 [만약에 빈 공간이 없으면 회원 100명 초과 가입불가]
					// 2. 아이디 중복체크
				
				// 저장부분
				for(int i=0; i<memberlist.length; i++) {
					
					// 아이디 중복체크 [기존 회원의 id와 동일하면 회원가입 불가]
					boolean idcheck = true;
					if(memberlist[i][0] != null && memberlist[i][0].equals(id)) {
						// ==null : 회원 없다. // != null : 회원 있다
					 System.out.println("알림)) 동일한 아이디가 존재합니다.");
					 idcheck = false; // 저장x
					 break;
					}
					else if(idcheck==true) {
						if(memberlist[i][0]==null) {
							// 만약에 memberlist i번째 행에 id가 없으면 = 빈공간
							memberlist[i][0] = id; memberlist[i][1] = pw; memberlist[i][2] = name;
							// i번째 각 열에 데이터 저장
							System.out.println("알림)) 회원가입이 되었습니다.");
							break; // 저장했으면 끝[1번 저장]
						}
						else System.out.println("알림)) 더 이상 회원가입이 불가능합니다.");
					
					}
				}
				
			} // 회원가입 종료
			
			else if(ch==2) { // 로그인
				System.out.println("-------------로그인 페이지-------------");
				System.out.println("아이디 : "); String id = scanner.next();
				System.out.println("비밀번호 : "); String pw = scanner.next();
				
				// 배열내 데이터가 입력받은 id와 pw 가 동일하면 로그인철기
				boolean login = false;
				for(int i=0; i<memberlist.length; i++) {
					
					if(memberlist[i][0] != null && memberlist[i][0].equals(id) && memberlist[i][1].equals(pw)) {
						// i번째 행에 id와 pw가 입력받은 값과 같으면(equals)
							// null은 객체가 아니기 때문에 equals가 불가능 => 비교연산자 사용(== != ...)
						System.out.println("알림)) 로그인 성공"); 
												
						login = true; // 로그인 성공 값 저장
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
						while(true) { // 로그인시 메뉴 무한루프 [종료조건 : 2.로그아웃]
							System.out.println("-----------------------------------");
							System.out.println("----------------방문록---------------");
							System.out.println("번호\t작성자\t제목\t내용");
								// 모든 방문록 출력
								for(int j=0; j<boardlist.length; j++) {
									if(boardlist[j][0]!=null) { // 게시물이 없는 인덱스는 제외
									System.out.printf("%d\t%s\t%s\t%s \n",
											j+1, boardlist[j][2],boardlist[j][0],boardlist[j][1]);
									}
								}
							
							System.out.println("---------------회원 메뉴--------------");
							System.out.println("1.방문록 작성 2.로그아웃   선택 : "); int ch2 = scanner.nextInt();
							if(ch2==1) { // 방문록 작성
								System.out.println("-------------글쓰기----------------");
								System.out.println("제목 : "); String title = scanner.next();
								System.out.println("내용 : "); String contents = scanner.next();
								// 배열 내 공백찾아서 저장
								for(int j = 0; j<boardlist.length; j++) {
									if(boardlist[j][0]==null) { // 배열내 j번째 인덱스 게시물이 공백이면
										boardlist[j][0] = title; 
										boardlist[j][1] = contents; 
										boardlist[j][2] = id; // 로그인시 사용된 id를 대입
										System.out.println("방문록이 작성되었습니다.");
										break;
									}
								}
							} // 방문록 끝
							else if(ch2==2) {
								System.out.println("알림)) 로그아웃");
								break; // 가장 가까운 반복문 탈출
							}
							else System.out.println("알림)) 알 수 없는 번호입니다.");
						} // while2 end
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					} // if end	 
				} // for end
				
				// 로그인 실패시
				if(login==false) System.out.println("알림)) 회원정보가 없거나 다릅니다.");				
			} // 로그인 종료
			else System.out.println("알림)) 알 수 없는 번호입니다.");
		} // while end
		
		
		
		
		
		
	} // m e
	
	
} // c e
