package Day07;

public class Book { // c s

	// 1. 필드
	String ISBN; // 도서번호
	String bookname; // 도서명
	String writer; // 작가
	boolean borrow; // 도서대여여부
	String memberid; //대여인id
	
	// 2. 생성자
	public Book() {}
	
	public Book(String ISBN, String bookname, String writer, boolean borrow, String memberid) {
		this.ISBN = ISBN;
		this.bookname = bookname;
		this.writer = writer;
		this.borrow = borrow;
		this.memberid = memberid;
	}

	// 3. 메소드
		
		// 1. 도서검색
	void 도서검색() {
		System.out.println("----------------도서검색 페이지------------------");
		System.out.println("검색할 도서의 ISBN 입력 : "); String ISBN = Day07_5_BookApplication.scanner.next();
		
		for(Book temp : Day07_5_BookApplication.books) {
			if(temp!=null && temp.ISBN.equals(ISBN)) {
				System.out.println("검색 결과 : ");
				System.out.println("ISBN\t도서명\t작가\t도서대여여부");
				if(temp.borrow) {
					System.out.println(temp.ISBN+"\t"+temp.bookname+"\t"+temp.writer+"\t"+"대여가능");
					return;	
				}
				else System.out.println(temp.ISBN+"\t"+temp.bookname+"\t"+temp.writer+"\t"+"대여중");
					return;
			}
			
		}
		
	}
		// 2. 도서목록
	void 도서목록() {
		System.out.println("----------------도서목록 페이지------------------");
		System.out.println("ISBN\t도서명\t작가\t대여가능여부");
		for(Book temp : Day07_5_BookApplication.books) {
			if(temp!=null) {
				if(temp.borrow) { // 해당도서의 도서대여여부가 true 이면
					System.out.println(temp.ISBN+"\t"+temp.bookname+"\t"+temp.writer+"\t"+"대여가능");
				}
				else { // 해당도서의 도서대여여부가 false 이면
					System.out.println(temp.ISBN+"\t"+temp.bookname+"\t"+temp.writer+"\t"+"대여중");	
				}
			}
			
		} // for end
			
	}
		// 3. 도서대여
	void 도서대여(String loginid) {
		System.out.println("----------------도서대여 페이지------------------");
		System.out.println("대여할 도서의 ISBN 입력 : "); String ISBN = Day07_5_BookApplication.scanner.next();
		
		for(Book temp : Day07_5_BookApplication.books) {
			if(temp!=null) {
				if(temp.ISBN.equals(ISBN)) {
					if(temp.borrow) {
						System.out.println("알림)) 대여가 완료되었습니다.");
						temp.borrow = false; temp.memberid = loginid;
						return;
					}
					else System.out.println("알림)) 현재 대여중인 도서입니다.[대여불가능]");
					return;
				}
				
			}
				
		} // for end
		System.out.println("알림)) 동일한 도서 ISBN이 없습니다.");		
	}
		// 4. 도서반납
	void 도서반납(String loginid) {
		System.out.println("----------------도서반납 페이지------------------");
		도서대여목록(loginid);
		System.out.println("반납할 도서 ISBN 입력 : "); String ISBN = Day07_5_BookApplication.scanner.next();
		
		for(Book temp : Day07_5_BookApplication.books) {
			if(temp!=null && temp.ISBN.equals(ISBN)) { // 입력한 isbn이 있으면
				if(temp.memberid.equals(loginid)) { // 대여인 id와 현재 로그인된 id가 동일하면
					if(temp.borrow) {
						System.out.println("알림)) 현재 도서가 대여중이 아닙니다.");
					}
					else System.out.println("알림)) 도서 반납이 완료되었습니다.");
					temp.borrow=true; temp.memberid="admin"; // 대여중 -> 대여가능 변경 / 대여한 사람의 id를 없음으로 변경[null]
					return;
				}
				else System.out.println("알림)) 회원님이 대여한 도서가 아닙니다.");
				return;
			}
		}
		System.out.println("알림)) 동일한 도서 ISBN이 없습니다.");	
	}
	 	// * 현재 로그인 한 회원이 대여중인 도서 목록
	void 도서대여목록(String loginid) {
		System.out.println("----------------도서대여목록 페이지------------------");
		System.out.println("ISBN\t도서명\t작가\t대여가능여부");
		for(Book temp : Day07_5_BookApplication.books) {
			if(temp!=null && temp.memberid.equals(loginid)) {
				// * 도서가 존재하면서 대여 id 와 현재 로그인된 id가 같으면 
					System.out.println(temp.ISBN+"\t"+temp.bookname+"\t"+temp.writer+"\t"+"대여중");	
			}
			
		} // for end

	}
		// 5. 도서등록
	void 도서등록() {
		System.out.println("----------------도서등록 페이지------------------");
		// 1. 입력받기
		System.out.println("ISBN : "); String ISBN = Day07_5_BookApplication.scanner.next();
		System.out.println("도서명 : "); String bookname = Day07_5_BookApplication.scanner.next();
		System.out.println("작가 : "); String writer = Day07_5_BookApplication.scanner.next();
		
		// * 중복체크
		for(Book temp : Day07_5_BookApplication.books) {
			if(temp!=null && temp.ISBN.equals(ISBN)) {
				System.out.println("알림)) 현재 사용중인 ISBN 입니다.[등록실패]");
				return; // 도서등록 메소드 종료 (등록실패)
			}
		}
		
		// 2. 객체화 [ 도서대여여부 = true, 대여회원id = null ]
		Book book = new Book(ISBN, bookname, writer, true, null);
		
		// 3. 배열 대입[넣기]
		int index = 0;
		for(Book temp : Day07_5_BookApplication.books) {
			if(temp==null) {
				System.out.println("알림)) 도서등록이 완료되었습니다.");
				Day07_5_BookApplication.books[index]=book;
				return; // 등록 성공시 메소드 종료
			}
			index++;
		}
	}
		// 6. 도서삭제
	void 도서삭제() {
		System.out.println("----------------도서삭제 페이지------------------");
		System.out.println("삭제할 도서 ISBN 입력 : "); String ISBN = Day07_5_BookApplication.scanner.next();
		
		
		int a =0;
		for(Book temp : Day07_5_BookApplication.books) {
			if(temp!=null && temp.ISBN.equals(ISBN)) {
				System.out.println("검색 결과 : ");
				System.out.println("ISBN\t도서명\t작가");
				System.out.println(temp.ISBN+"\t"+temp.bookname+"\t"+temp.writer);
				System.out.println("1.삭제 2.취소"); int ch = Day07_5_BookApplication.scanner.nextInt();
				
				if(ch==1) {
					System.out.println("알림)) 해당 도서가 삭제되었습니다.");
					Day07_5_BookApplication.books[a]=null;
					int j = 0;	
					for(Book temp2 : Day07_5_BookApplication.books) {
						if(temp2==null) {
							for(int i=j; i<Day07_5_BookApplication.books.length; i++) {
								if(i==Day07_5_BookApplication.books.length-1) {
									Day07_5_BookApplication.books[Day07_5_BookApplication.books.length-1] = null;
								}
								else {
									Day07_5_BookApplication.books[i]=Day07_5_BookApplication.books[i+1];
								}
							}
						}
						j++;	
					} // for end
					return;
				} // if end
				else if(ch==2) {
					System.out.println("알림)) 관리자 메뉴로 돌아갑니다.");
					return;
				}
				else System.out.println("알림)) 알 수 없는 입력입니다.");
					return;
			}
			a++;
		} // for end
	}
	
} // c e
