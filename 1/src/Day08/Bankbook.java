package Day08;

public class Bankbook {
	
	//필드
	int banknum; // 계좌번호
	int nowmoney;
	String bankpw;


	//생성자
	public Bankbook() {
		
	}

	public Bankbook(int banknum, int nowmoney, String bankpw) {
		this.banknum = banknum;
		this.nowmoney = nowmoney;

		this.bankpw = bankpw;

	}
	//메소드
/////////////////////////////////////////////////////////////////////////////////////////////
	boolean bankregistration(String x) {//계좌생성
		System.out.println("계좌가입) ");
		System.out.print("사용할 계좌번호 입력 : \n");int banknum = Day08_5.scanner.nextInt();
		try {
			for(Bankbook temp : Day08_5.bankbooks) {
				if(temp != null && temp.banknum == banknum) {
					System.out.println("알림)) 현재 사용중인 계좌번호입니다.");
					return false;
				}
			}
		}
		catch(NullPointerException e) {
			System.out.println("알림)) 잘못된 정보 입니다.");
			return false;
		}
		System.out.print("사용할 비민번호 입력 : \n");String pw = Day08_5.scanner.next();
	
		Bankbook bankbook = new Bankbook(banknum,0, pw);
		try {
			int i = 0;
				for(Bankbook temp2 : Day08_5.bankbooks) {
					if(temp2 == null) {
						Day08_5.bankbooks[i] = bankbook;
						return true;
					}
					i++;
				}
		}
		catch(NullPointerException e) {
			System.out.println("알림)) 잘못된 정보 입니다.");
			return false;
		}
		return false;
	}
/////////////////////////////////////////////////////////////////////////////////////////////
	void inmoney() {//입금
		System.out.print("계좌번호  입력 	: \n");int banknum =Day08_5.scanner.nextInt();
		System.out.print("계좌 비밀번호 입력 : \n");String pw =Day08_5.scanner.next();
		System.out.print("입금할 금액입력 	: \n");int money =Day08_5.scanner.nextInt();
		
		try {
			int i = 0;
			for(Bankbook temp : Day08_5.bankbooks) {
				if(temp != null &&temp.banknum == banknum && temp.bankpw.equals(pw)) {
					System.out.println("알림)) "+money + "원이 계좌로 입금 되었습니다");
					temp.nowmoney += money;
					return;
				}
				i++;
			}
		}
		catch (NullPointerException e) {
			System.out.println("알림)) 잘못된 정보입니다.");
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	void outmoney() {//출금
		System.out.print("계좌번호  입력 	: \n");int banknum =Day08_5.scanner.nextInt();
		System.out.print("계좌 비밀번호 입력 : \n");String pw =Day08_5.scanner.next();
		System.out.print("입금할 금액입력 	: \n");int money =Day08_5.scanner.nextInt();
		
		try {
			int i = 0;
			for(Bankbook temp : Day08_5.bankbooks) {
				if(temp != null &&temp.banknum == banknum && temp.bankpw.equals(pw)) {
					if(money > temp.nowmoney) {
						System.out.println("알림)) 잔액이 부족합니다.");
						return;
					}
					else {
						System.out.println("알림)) "+money + "원이 계좌에서 출금 되었습니다");
						temp.nowmoney -= money;
						return;
					}
					
				}
				i++;
			}
		}
		catch (NullPointerException e) {
			System.out.println("알림)) 잘못된 정보입니다.");
		}
	}


/////////////////////////////////////////////////////////////////////////////////////////////
	void bankbooklsit(String x) {//계좌 목록
		System.out.println("계좌 목록))");
		System.out.print("계좌번호\t현재잔액\t\n");
		try {
			for(Bankbook temp : Day08_5.bankbooks) {
				if(temp != null) {
					System.out.println(temp.banknum + "\t"+ temp.nowmoney);
				}
			}
		}
		catch(NullPointerException e) {
			System.out.println("알림)) 잘못된 정보 입니다.");
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////
	void sendmoney() {
		System.out.println("이체))");
		System.out.print("비밀번호 입력 	: "); String pw = Day08_5.scanner.next();
		//
		try {
			for(Bankbook temp : Day08_5.bankbooks) {
				if(temp != null && temp.bankpw.equals(pw)) {
					System.out.print("받으실분 계좌번호  : "); int bnum = Day08_5.scanner.nextInt();
					try {
						for(Bankbook temp2 : Day08_5.bankbooks) {
							if(temp2 != null && temp2.banknum == bnum) {
								System.out.print("이체할 금액을 입력하세요. : ");int money = Day08_5.scanner.nextInt();
								temp2.nowmoney += money;
								temp.nowmoney -= money;
								return;
							}
						}
					}
					catch(NullPointerException e) {
						System.out.println("알림)) 잘못된 정보 입니다.");
					}
				}
				else {
					System.out.println("알림) 잘못된 정보입니다.");
				}
			}
		}
		catch(NullPointerException e) {
			System.out.println("알림)) 잘못된 정보 입니다.");
		}
		
	}
	//////////////////////////////////////////////
	void findbankpw() {
		System.out.println("비밀번호))");
		System.out.print("계좌번호 	: \n"); int banknum = Day08_5.scanner.nextInt();
		System.out.print("연락처 		: \n"); String phone = Day08_5.scanner.next();
		boolean pwcheck = false;
		for(Bankbook temp : Day08_5.bankbooks) {
			if(temp!=null && temp.banknum==banknum) {
				for( Member temp2 : Day08_5.members) {
					if(temp2!=null && temp2.phone.equals(phone)) {
						System.out.println("알림)) 회원님의 비밀번호 : "+temp.bankpw);
						pwcheck = true;
						return;
					} // if end
				} // for end
				
			} // if end
			
		} // for end
		if(pwcheck == false)System.out.println("알림)) 존재하지 않는 회원입니다.");
	}
	///////////////////////////////////////////////////////////////////////////////
}
