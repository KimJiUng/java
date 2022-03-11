package Day08;

// 오류 
	// 1. 오타 입금 -> 출금

	// 3. 계좌번호 입력 종료시 return;
	// 4. 돈 보낼 계좌 입력

	// 6. 계좌 목록 전체 출력됨
	// 7. 이체시스템 변경




//모바일 뱅크 프로그램
			// 요구사항
			// 회원 주요기능 : 1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기
			// 계좌 주요기능 : 1.계좌생성 2.입금 3.출금 4.이체 5.대출 6.계좌목록
			// 설계 : 통장, 대출, 회원
			
			
			// 1. 회원
		
				// 필드
					// 이름, 아이디, 비밀번호, 전화번호, 주소
				// 메소드
					// 1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 5.회원탈퇴
			
			// 2. 통장
			
				// 필드
					// 계좌번호, 이름, 현재금액, 대출상환액, 계좌비밀번호, 대출, 대출잔액
				// 메소드
					// 1.이체 2.출금 3.대출 4.계좌비밀번호찾기 5.입금 6.계좌생성 7.계좌목록 8.대출상품등록 9.대출상품삭제 10.대출잔액확인
					// 11.대출상환 
			
			// 3. 대출
				
				// 필드
					 // 대출이름, 금액, 이자, 대출인[id], 상환여부
				// 메소드
					// 
			
	///////////////////////////////////////////////////////////////////////////////////////////////////////////


public class Member {
	
	//필드
	String name;
	String id;
	String pw;
	String phone;
	String address;
	
	//생성자
	public Member() { //빈생성자
		
	}

	public Member(String name, String id, String pw, String phone, String address) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phone = phone;
		this.address = address;
	}
	
	
	
	//메소드
	
	boolean registration() {//회원가입
		System.out.println("회원가입)");
		System.out.print("사용할 아이디 입력	 : ");String id = Day08_5.scanner.next();
	
		for(Member temp : Day08_5.members) {
			if(temp != null && temp.id.equals(id)) {
				System.out.println("알림)) 현재 사용중인 아이디입니다.");
				return false;
			}
		}
	
		System.out.print("사용할 비민번호 입력 : \n");String pw = Day08_5.scanner.next();
		System.out.print("회원이름 입력 	 : \n");String name = Day08_5.scanner.next();
		System.out.print("이동통신번호 입력   : \n");String phone = Day08_5.scanner.next();
		System.out.print("주소입력(EX:서울시) : \n");String address = Day08_5.scanner.next();
		
		Member member = new Member(name, id, pw, phone, address);
		
		
		int i = 0;
		for(Member temp : Day08_5.members) {
			if(temp == null) {
				Day08_5.members[i] = member;
				return true;
			}
			i++;
		}
		
		return false;
	}
	
	String login() {//로그인
		System.out.println("로그인)");
		System.out.print("ID : \n");String id = Day08_5.scanner.next();
		System.out.print("PW : \n");String pw = Day08_5.scanner.next();
		boolean idcheck = false;
		
		for(Member temp : Day08_5.members) {
			if( temp != null && temp.id.equals(id) && temp.pw.equals(pw)) {
				idcheck = true;
				return temp.id;
				
			}
			else if(temp != null && id.equals("admin") && temp.pw.equals(pw)) {
				idcheck = true;
				return "admin";
			}
		}
		
		
		if(idcheck == false)System.out.println("알림)) 존재하지 않는 회원입니다.");
		return null;
	}
	
	void findid() {//아이디 찾기
		System.out.println("아이디 찾기)");
		System.out.print("사용자의 이름 : \n");String name = Day08_5.scanner.next();
		System.out.print("전화번호 입력 : \n");String phone = Day08_5.scanner.next();
		boolean idcheck = false;
		
		
		for(Member temp : Day08_5.members) {
			if(temp != null && temp.name.equals(name) && temp.phone.equals(phone)) {
				System.out.println("회원님의 아이디는 " + temp.id + " 입니다.");
				idcheck = true;
				return;
			}
		}
		
		
	
		
		if(idcheck == false)System.out.println("알림)) 존재하지 않는 회원입니다.");
	}
	
	void findpw() {//비밀번호찾기
		System.out.println("비밀번호 찾기)");
		System.out.print("사용자의 아이디: \n");String id = Day08_5.scanner.next();
		System.out.print("전화번호 입력 : \n");String phone = Day08_5.scanner.next();
		boolean idcheck = false;
		
		
		for(Member temp : Day08_5.members) {
			if(temp != null && temp.id.equals(id) && temp.phone.equals(phone)) {
				System.out.println("회원님의 비밀번호는 " + temp.pw + " 입니다.");
				idcheck = true;
				return;
			}
		}
		
		if(idcheck == false)System.out.println("알림)) 존재하지 않는 회원입니다.");
	}
}