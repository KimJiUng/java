package Day08;

import java.util.Scanner;

public class Day08_5 {
	
	static Scanner scanner = new Scanner(System.in);
	static Member[] members = new Member[100];
	static Bankbook[] bankbooks = new Bankbook[100];	
	static Loan[] loanlist = new Loan[100];
	public static void main(String[] args) {
		
		Day08_5 mobilebank = new Day08_5();
		mobilebank.menu();
	}
	
	void menu() {
		Member member = new Member();
		while(true) { // 무한루프 [종료조건 x]
			System.out.println("-------------모바일 뱅크 프로그램-------------------");
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			int ch = scanner.nextInt();
			if(ch == 1) {
				member.registration();
			}
			else if(ch==2) {
				String result = member.login();
				
				if(result == null) {
					System.out.println("알림)) 동일한 회원정보가 없습니다.");
				}
				else if(result.equals("admin")){ // 2. 관리자 메뉴 메소드 호출
					System.out.println("알림) 관리자로 로그인 하셨습니다.");
					adminmenu("admin"); // 내부 메소드 호출
				}
				else { // 1. 일반회원 메뉴 메소드 호출
					System.out.println("알림) 안녕하세요~"+result+"님");
					membermenu(result); // 인수1개 [로그인 성공한 id]
				}  	
			}
			else if(ch==3) {
				member.findid();
			}
			else if(ch==4) {
				member.findpw();
			}
			else {
				System.out.println("알림)) 잘못된 입력입니다.");
			}
		}
	}
	
	void membermenu(String loginid) {
		Day08_5 mobilebank = new Day08_5();
		while(true) { // 무한루프 [ 종료조건 : 로그아웃 ]
			Bankbook bankbook = new Bankbook();
			System.out.println("------------------회원 메뉴---------------");
			System.out.println("1.계좌생성 2.계좌목록 3.입금 4.출금 5.이체 6.대출 7.계좌비밀번호찾기 8.로그아웃");
			int ch = scanner.nextInt();
			
			if(ch==1) {
				bankbook.bankregistration(loginid);
			}
			else if(ch==2) {
				bankbook.bankbooklsit(loginid);
			}
			else if(ch==3) {
				bankbook.inmoney(loginid);
			}
			else if(ch==4) {
				bankbook.outmoney(loginid);
			}
			else if(ch==5) {
				bankbook.sendmoney(loginid);
			}
			else if(ch==6) {
				mobilebank.loanmenu(loginid);
			}
			else if(ch==7) {
				bankbook.findbankpw(loginid);
			}
			else if(ch==8) {
				System.out.println("알림)) 로그아웃 되었습니다.");
				return;
			}
			else System.out.println("알림)) 잘못된 입력입니다.");
					
		} // while end
		
		
	} // 일반회원 메뉴 종료
	//////////////////////////////////////////////////////////////////////////////////////////
	void loanmenu(String x) {
		while(true) {
			Loan loan = new Loan();
			System.out.println("------------------회원 메뉴---------------");
			System.out.println("1.대출상품목록 2.대출확인 3.뒤로가기");
			int ch = scanner.nextInt();
			if(ch == 1) {
				loan.loanlsit(x);
			}
			else if(ch == 2) {
				loan.myloan(x);
			}
			else if(ch==3) {
				System.out.println("알림)) 이전 페이지로 이동합니다");
				break;
			}
			else {
				System.out.println("알림)) 잘못된 입력입니다.");
			}
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////
	// 3.관리자 메뉴 메소드
	void adminmenu(String loginid) {
		while(true) {
			Loan loan = new Loan();
			System.out.println("------------------관리자 메뉴---------------");
			System.out.println("1.대출상품등록 2.대출상품삭제 3.로그아웃");
			int ch = scanner.nextInt();
			
			if(ch==1) {
				loan.newloan(loginid);
			}
			else if(ch==2) {
				loan.removeloan(loginid);
			}
			else if(ch==3) {
				System.out.println("알림)) 로그아웃 되었습니다.");
				return;
			}
			else System.out.println("알림)) 잘못된 입력입니다.");
		} // while end
	}
	
}
