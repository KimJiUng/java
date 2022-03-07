package Day05;

import java.util.Scanner;

public class Day05_4 { // c s

	public static void main(String[] args) { // m s
		
		// 도서 대여 console 프로그램
		
			// 1. 배열
				// 1. 회원[아이디(중복x), 비밀번호]
				// 2. 도서[도서명(중복x), 도서대여여부, 대여인]
		
			// 2. 초기메뉴
				// 1. 회원가입 2. 로그인
					// 1. 회원가입시 아이디 중복체크
					// 2. 로그인 성공시 로그인메뉴, 로그인 실패시 로그인실패 출력
		
			// 3. 로그인시 메뉴
				// 1. 도서검색 2. 도서목록 3. 도서대여 4. 도서반납 5. 로그아웃
					// 1. 도서검색시 도서명이 일치하면 출력 아니면 없음 출력
					// 2. 도서목록시 모든 도서명 출력
					// 3. 도서대여시 도서대여여부가 가능할때 도서대여
					// 4. 도서반납시 본인이 대여한 도서만 반납 처리
					// 5. 로그아웃시 초기메뉴로
		
			// 4. 로그인시 아이디가 admin 이면 관리자메뉴
				// 1. 도서등록 2. 도서목록 3.로그아웃
					// 1. 도서등록시 도서명을 입력받아 도서 등록처리
					// 2. 도서목록시 모든 도서명 출력
					// 3. 도서삭제시 삭제할 도서명을 입력받아 동일한 도서명 삭제[null]
					// 4. 로그아웃시 초기메뉴로
		
		//전역변수
		Scanner scanner = new Scanner(System.in);
		String[][] memberlist = new String[100][2]; // 회원 아이디, 비밀번호
		String[][] book = new String[100][3]; // 도서명, 대여여부, 대여인
		
	
		//초기메뉴
		while(true) { // 무한루프 [종료조건 : x]
			System.out.println("-------------도서 대여 프로그램----------------");
			System.out.println("1.회원가입 2.로그인");
			System.out.println(">선택 : "); int select = scanner.nextInt();
			if(select==1) {
				System.out.println("아이디 : "); String id = scanner.next();
				System.out.println("비밀번호 : "); String pw = scanner.next();
				
				for(int i=0; i<memberlist.length; i++) {
					boolean idcheck = true;
					//id 중복체크
					if(memberlist[i][0]!=null && memberlist[i][0].equals(id)) {
						System.out.println("알림)) 동일한 아이디가 존재합니다.");
						idcheck = false;
						break;
					}
					else if(idcheck==true) {
						if(memberlist[i][0]==null) {
							memberlist[i][0]=id; memberlist[i][1]=pw; 
							System.out.println("알림)) 회원가입이 완료되었습니다.");
							break;
						}
					}
				}	
			} // if 1.회원가입 종료
			else if(select==2) {
				System.out.println("-------------로그인 페이지-------------");
				System.out.println("아이디 : "); String id = scanner.next();
				System.out.println("비밀번호 : "); String pw = scanner.next();
				
				boolean logincheck = false;
				for(int i=0; i<memberlist.length; i++) {
					if(id.equals("admin") && pw.equals("1234")) {
						System.out.println("알림)) 관리자 로그인 성공");
///////////////////////////////////////////////////////관리자 로그인 성공시 메뉴/////////////////////////////////////////////////////////
						while(true) {
							System.out.println("------------------관리자 메뉴---------------");
							System.out.println("1. 도서등록 2. 도서목록 3.로그아웃"); int admin = scanner.nextInt();
							
							if(admin==1) { // 도서등록
								System.out.println("등록할 도서명 입력 : "); String book3 = scanner.next();
								
							for(int j=0; j<book.length; j++) {
									boolean admincheck = true;
									// 도서명 중복체크
									if(book[j][0]!=null && book[j][0].equals(book3)) {
										System.out.println("알림)) 동일한 도서명이 존재합니다.");
										admincheck = false;
										break;
									}
									else if(admincheck==true) {
										if(book[j][0]==null) {
											book[j][0]=book3; book[j][1] = "대여가능";
											System.out.println("알림)) 도서 등록이 완료되었습니다.");
											break;
										}
									}
								}
							} // if 도서등록 end
							
							else if(admin==2) { // 도서목록
								System.out.println("------------------도서 목록---------------");
								System.out.println("번호\t도서명\t\t\t대여여부");
								for(int j=0; j<book.length; j++) {
									if(book[j][0]!=null) {
										System.out.printf("%d\t%s\t\t%s \n", j, book[j][0], book[j][1]);
										
									}
									else break;
								} // for end
								
							} // else if 도서목록 end
							
							else if(admin==3) {
								System.out.println("알림)) 로그아웃 되었습니다.");
								id = "0"; pw = "0";
								logincheck = true;
								break;
							} // else if 로그아웃 end
							
						} // while 관리자메뉴 end						
///////////////////////////////////////////////////////관리자 로그인 성공시 메뉴/////////////////////////////////////////////////////////
						
					}
					else if(memberlist[i][0]!=null && memberlist[i][0].equals(id) && memberlist[i][1].equals(pw)){
						System.out.println("알림)) 로그인 성공");
						logincheck = true;
////////////////////////////////////////////////////////로그인 성공시 메뉴////////////////////////////////////////////////////////		
						
						while(true) { // 로그인 성공시 [종료 조건 : 로그아웃]
							for(int j=0; j<book.length; j++) {
								
									System.out.println("--------------------메뉴-----------------------");
									System.out.println("1. 도서검색 2. 도서목록 3. 도서대여 4. 도서반납 5. 로그아웃");
									int select_2 = scanner.nextInt();
									boolean se = true;
									
									
										if(select_2==1) { // 도서검색
											
												System.out.println("도서 검색 : "); String bs =scanner.next();
										for( int bss = 0; bss < book.length; bss++) {
											if ( book[bss][0]!=null && book[bss][0].equals(bs)) {
												System.out.print("검색 결과 : "+bs+"\n");
												if(book[j][1].equals("대여가능")) System.out.print("\t대여 가능\n");
												else if(book[j][1]!=null) System.out.print("\t대여 불가능\n");												
												
											}
											else System.out.println("알림)) 검색 결과 없음");
											break;
										
										}
										}		// if 도서검색 종료
										else if(select_2==2) { // 도서목록
											if(se==true) {
												System.out.println("------------------도서 목록---------------");
												System.out.println("번호\t도서명\t\t\t대여여부");
												for(int k=0; k<book.length; k++) {
													if(book[k][0]!=null) {
														System.out.printf("%d\t%s\t\t%s \n", k, book[k][0], book[k][1]);
													}
													else se=false;
												} // for end
											} // if end
										} // else if 도서목록 종료
										else if(select_2==3) { // 도서대여
											for(int k=0; k<book.length; k++) {
												System.out.println("대여할 도서 입력 : "); String borrow = scanner.next();
											
												if(book[k][0]!=null && book[k][0].equals(borrow)) {
													if(book[k][1].equals("대여가능")) {
														System.out.println("1.대여하기 2.취소");
														int select_3 = scanner.nextInt();
														if(select_3==1) {
															System.out.println("알림)) 대여가 완료되었습니다.");
															book[j][1] = "대여불가능"; book[j][2] = memberlist[i][0];
															break;
											
														}
														if(select_3==2) {
															System.out.println("알림)) 메뉴로 돌아갑니다.");
															break;
														}
													}
												else if(book[k][1].equals("대여불가능")) {
													System.out.println("알림)) 이미 대여된 책입니다.");
												}
											}
											else System.out.println("검색 결과 없음");
											break;
											
											} // for end 
										} // else if 도서대여 종료
										else if(select_2==4) { // 도서반납
											for(int k=0; k<book.length; k++) {
												if(memberlist[i][0]!=null && memberlist[i][0].equals(book[j][2])) {
													System.out.println("반납 가능한 도서 목록");
													System.out.println(book[j][0]+"\n");
													System.out.println("반납할 도서 입력 : "); String book_2 = scanner.next();
													if(book[j][0].equals(book_2)) System.out.println("알림)) 반납이 완료되었습니다.");
													book[j][1] = "대여가능";
													break;
												}
												else System.out.println("알림)) 반납 가능한 도서가 없습니다.");
												break;
											}
										} // else if 도서반납 종료
										else if(select_2==5) { // 로그아웃
										System.out.println("알림)) 로그아웃 되었습니다.");

										break;
										} // else if 로그아웃 종료
								
							
							} // for end
							break;
						} // while end
						
////////////////////////////////////////////////////////로그인 성공시 메뉴////////////////////////////////////////////////////////
						
					}
					
				}
				if(logincheck==false) System.out.println("알림)) 로그인 실패");
			} // else if 2.로그인 페이지 종료
		} // while 초기메뉴 종료
		
		
		
		
		
	} // m e
	
} // c e
