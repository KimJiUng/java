package Day08;

import Day07.Book;
import Day07.Day07_5_BookApplication;

public class Loan {

	// 1. 필드
	String lname;
	int loanmoney;
	String lid;
	boolean repay;
	final double interest=0.1;
	// 2. 생성자
	public Loan() {	}

	public Loan(String lname, int loanmoney, String lid, boolean repay) {
		this.lname = lname;
		this.loanmoney = loanmoney;
		this.lid = lid;
		this.repay = repay;
	}


	// 3. 메소드
	
/////////////////////////////////////////////대출/////////////////////////////////////////////////////////







/////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////대출목록///////////////////////////////////////////////////////




/////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////대출 상품 등록///////////////////////////////////////////////////////
	void newloan(String loginid) {
		System.out.println("----------------대출 상품 등록 페이지------------------");
		// 1. 입력받기
		System.out.println("대출 상품이름 입력 : "); String lname = Day08_5.scanner.next();
		System.out.println("대출 금액 입력 : "); int loan = Day08_5.scanner.nextInt();
		
		// * 중복체크
		for(Loan temp : Day08_5.loanlist) {
			if(temp!=null && temp.lname.equals(lname)) {
				System.out.println("알림)) 현재 사용중인 대출 상품입니다.[등록실패]");
				return; // 대출상품등록 메소드 종료 (등록실패)
			}
		}
		
		// 2. 객체화 [ 도서대여여부 = true, 대여회원id = null ]
		Loan newloan = new Loan(lname, loan, loginid, false);
		
		// 3. 배열 대입[넣기]
		int index = 0;
		for(Loan temp : Day08_5.loanlist) {
			if(temp==null) {
				System.out.println("알림)) 대출 상품 등록이 완료되었습니다.");
				Day08_5.loanlist[index]=newloan;
				return; // 등록 성공시 메소드 종료
			}
			index++;
		}
	} // 대출 상품 등록 종료
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////////////대출 상품 삭제///////////////////////////////////////////////////////
	void deleteloan() {
		System.out.println("----------------대출 상품 삭제 페이지------------------");
		System.out.println("삭제할 대출 상품이름 입력 : "); String lname = Day08_5.scanner.next();
		
		
		int a =0;
		for(Loan temp : Day08_5.loanlist) {
			if(temp!=null && temp.lname.equals(lname)) {
				System.out.println("검색 결과 : ");
				System.out.println("상품이름\t대출금액\t이자율");
				System.out.println(temp.lname+"\t"+temp.loanmoney+"\t"+(interest*100)+"%");
				System.out.println("1.삭제 2.취소"); int ch = Day08_5.scanner.nextInt();
				
				if(ch==1) {
					System.out.println("알림)) 해당 상품이 삭제되었습니다.");
					Day08_5.loanlist[a]=null;
					int j = 0;	
					for(Loan temp2 : Day08_5.loanlist) {
						if(temp2==null) {
							for(int i=j; i<Day08_5.loanlist.length; i++) {
								if(i==Day08_5.loanlist.length-1) {
									Day08_5.loanlist[Day08_5.loanlist.length-1] = null;
								}
								else {
									Day08_5.loanlist[i]=Day08_5.loanlist[i+1];
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
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
///////////////////////////////////////////대출 상환/////////////////////////////////////////////////////////
	void repay(String loginid) {
		System.out.println("----------------대출 상환 페이지------------------");
		llist(loginid);
		System.out.println("상환할 대출 상품 이름 입력 : "); String lname = Day08_5.scanner.next();
		
		int j=0;
		for(Loan temp : Day08_5.loanlist) {
			if(temp!=null && temp.lname.equals(lname)) { // 입력한 상품명이 있으면
				if(temp.lid.equals(loginid)) { // 대출인 id와 현재 로그인된 id가 동일하면
					if(temp.repay) {
						System.out.println("알림)) 현재 대출중인 상품이 아닙니다.");
					}
					else {
						System.out.println("계좌번호 입력 : "); int banknum = Day08_5.scanner.nextInt();
						System.out.println("계좌비밀번호 입력 : "); String bankpw = Day08_5.scanner.next();
						int i=0;
						for(Bankbook temp2 : Day08_5.bankbooks) {
							if(temp2!=null && temp2.banknum==banknum && temp2.bankpw.equals(bankpw)) {
								if(temp2.nowmoney>=temp.loanmoney) {
									System.out.println("알림)) 대출 상환이 완료되었습니다.");
									temp2.nowmoney -= temp.loanmoney;
									Day08_5.loanlist[i].repay=true; Day08_5.loanlist[j]=null; // 대여중 -> 대여가능 변경 / 대여한 사람의 id를 없음으로 변경[null]
									return;
								}
								else System.out.println("알림)) 현재 계좌 잔액이 부족합니다.[상환실패]");
								return;
							}
							i++;
						} // for end
						
					}
					
				}
				else System.out.println("알림)) 회원님이 대출한 상품이 아닙니다.");
				return;
			}
			j++;
		} // for end
		System.out.println("알림)) 동일한 대출 상품명이 없습니다.");	
	}
	
	// * 현재 로그인 한 회원이 대출받은 상품 목록
	void llist(String loginid) {
		System.out.println("----------------대출 상품 목록 페이지------------------");
		System.out.println("상품이름\t대출금액\t이자율");
		for(Loan temp : Day08_5.loanlist) {
			if(temp!=null && temp.lid.equals(loginid)) {
				// * 대출이 존재하면서 대출인(id)과 현재 로그인된 id가 같으면 
					System.out.println(temp.lname+"\t"+temp.loanmoney+"\t"+(interest*100)+"%");	
			}
			
		} // for end

	}
//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
} // c e
