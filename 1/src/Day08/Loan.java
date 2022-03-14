package Day08;


public class Loan {
	
	//필드
	String lname;
	int loanmoney;
	final double interest = 0.1;
	String lid;
	boolean repay;
	
	//생성자
	
	public Loan() {
		
	}

	public Loan(String lname, int loanmoney, String lid, boolean repay) {
		this.lname = lname;
		this.loanmoney = loanmoney;
		this.lid = lid;
		this.repay = repay;
	}
	
	//메소드

	void newloan(String loginid) {
		System.out.println("----------------대출 상품 등록 페이지------------------");
		// 1. 입력받기
		System.out.print("대출 상품이름 입력 : \n"); String lname = Day08_5.scanner.next();
		System.out.print("대출 금액 입력 : \n"); int loan = Day08_5.scanner.nextInt();
		
		// * 중복체크
		for(Loan temp : Day08_5.loanlist) {
			if(temp!=null && temp.lname.equals(lname)) {
				System.out.println("알림)) 현재 사용중인 대출 상품입니다.[등록실패]");
				return; // 대출상품등록 메소드 종료 (등록실패)
			}
		}
		
		// 2. 객체화 [ 도서대여여부 = true, 대여회원id = null ]
		Loan newloan = new Loan(lname, loan, " ", false);
		
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
	}
	/////////////////////////////////////////////////
	void loanlsit(String x) {//대출 목록
		System.out.println("대출상품 목록 목록))");
		System.out.println("상품이름\t대출금액\t이자율\t대출자");
		try {
			for(Loan temp : Day08_5.loanlist) {
				if(temp!=null) {
					System.out.println(temp.lname+"\t"+temp.loanmoney+"\t"+(interest*100)+"%"+temp.lid);
				}
			} // for end
			
			//System.out.println("대출받을 상품명 입력 : "); String lname = Day08_5.scanner.next();
			System.out.println("1)대출받기  2)뒤로가기");
			int ch = Day08_5.scanner.nextInt();
			
			
			if(ch == 1) {
				System.out.println("알림)) 대출 페이지로 이동합니다.");
				inloan(x);
			}
			else if(ch == 2) {
				System.out.println("알림)) 이전으로 돌아갑니다.");
				return;
			}
			
		} // try end
		catch(NullPointerException e) {}
	}
/////////////////////////////////////////////////////////////////////////////	
	void removeloan(String loginid) {
		System.out.println("----------------대출 상품 삭제 페이지------------------");
		System.out.print("삭제할 대출 상품이름 입력 : \n"); 
		for(Loan temp : Day08_5.loanlist) {
			if(temp!=null) {
				System.out.println(temp.lname+"\t"+temp.loanmoney+"\t"+(interest*100)+"%"+temp.lid);
			}
		}
		String lname = Day08_5.scanner.next();	
		int a =0;
		for(Loan temp : Day08_5.loanlist) {
			if(temp!=null && !temp.lname.equals(lname)) {
				
			}
			else if(temp!=null && temp.lname.equals(lname)) {
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
		System.out.println("알림)) 일치하는 대출 상품이 없습니다.");
	}
///////////////////////////////////////////////////////////////////////////////////	
	void myloan(String x) {
		System.out.println("대출받은상품 목록 목록))");
		System.out.print("대출상품\t대출잔액\t\n");
		try {
			for(Loan temp : Day08_5.loanlist) {
				if(temp != null &&temp.lid.equals(x)) {
					System.out.println(temp.lname + "\t"+ (temp.loanmoney+(temp.loanmoney*interest)));
					System.out.println("1)대출상환  2)뒤로가기");
					int ch = Day08_5.scanner.nextInt();
					if(ch == 1) {
						System.out.println("알림)) 대출상환 페이지로 이동합니다.");
						outloan(x);
					}
					else if(ch == 2) {
						System.out.println("알림)) 이전으로 돌아갑니다.");
						return;
					}
					
				}
			}
		}
		catch(NullPointerException e) {
			System.out.println("알림)) 잘못된 정보 입니다.");
		}
	}
///////////////////////////////////////////////////////////////////////////////////	
	void outloan(String x) {
		System.out.println("대출상환)) ");
		for(Loan temp : Day08_5.loanlist) {
			if(temp!=null && x.equals(temp.lid)) {
				System.out.println(temp.lname+"\t"+temp.loanmoney+"\t"+(interest*100)+"%\t"+temp.lid);
			}
		}
		System.out.print("상환할 대출상품의 이름을 입력하세요 : \n");
		String out = Day08_5.scanner.next();
		try {
			int j = 0;
			for(Loan temp : Day08_5.loanlist) {
				
				if(temp!=null && !temp.lname.equals(out)) {}
				else if(temp != null && temp.lname.equals(out)) {
					Bankbook bankbook = new Bankbook(loanmoney);
					System.out.print("출금할 계좌번호를 입력하세요.  : \n");
					int bnum = Day08_5.scanner.nextInt();
					int i = 0;
					for(Bankbook temp2 : Day08_5.bankbooks) {
						if(temp2 != null && temp2.nowmoney < (temp.loanmoney+(temp.loanmoney*interest))) {
							System.out.println("알림)) 잔액이 부족하여 상환하실수 없습니다.");
							return;
						}
						else if(temp2 != null && temp2.username.equals(x) && temp2.banknum == bnum) {
							System.out.println(temp.lname+" 상품을 상환 합니다.");
							System.out.println("상환 금액은 "+ (temp.loanmoney+(temp.loanmoney*interest)) + "원 입니다.");
							Day08_5.bankbooks[i].nowmoney -= (temp.loanmoney+(temp.loanmoney*interest));
							Day08_5.bankbooks[i].loanm =0;
							Day08_5.loanlist[j].lid = " ";
							System.out.println("알림)) 상환이 완료되었습니다. 이용해주셔서 감사합니다.");
							return;
						}
						i++;
					}
				} 
				
				j++;
			}
			System.out.println("알림)) 존재하지 않는 상품입니다.");
		}
		catch(NullPointerException e) {
		
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////	
	void inloan(String x) {
		System.out.println("대출받기)) ");
		System.out.print("받으실 대출상품의 이름을 입력하세요 : \n");
		String ln = Day08_5.scanner.next();
		try {
			int j = 0;
			for(Loan temp : Day08_5.loanlist) {
				if(temp != null && temp.lname.equals(ln)) {
					Bankbook bankbook = new Bankbook(loanmoney);
					System.out.print("받으실 계좌번호를 입력하세요.  : \n");
					int bnum = Day08_5.scanner.nextInt();
					int i = 0;
					for(Bankbook temp2 : Day08_5.bankbooks) {
						if(temp2 != null && temp2.username.equals(x)&&temp2.banknum == bnum) {
							System.out.println(temp.lname+" 상품을  대출받았습니다.");
							Day08_5.bankbooks[i].nowmoney += temp.loanmoney;
							Day08_5.bankbooks[i].loanm += (temp.loanmoney+(temp.loanmoney*interest));
							Day08_5.loanlist[j].lid = x;
							return;
						}
						i++;
					}
				}
				
				j++;
			}
			System.out.println("알림)) 존재하지 않는 상품입니다.");
		}
		catch(NullPointerException e) {
			System.out.println("알림)) 잘못된 정보입니다.");
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////
}
