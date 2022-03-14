package Day08;

public class Member {
	
	//필드
	private String name;
	private String id;
	private String pw;
	String phone;
	private String address;
	
	//생성자
	public Member() { //빈생성자
		
	}
	public Member(String phone) {
		this.phone = phone;
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
		try {
			for(Member temp : Day08_5.members) {
				if(temp != null && temp.id.equals(id)) {
					System.out.println("알림)) 현재 사용중인 아이디입니다.");
					return false;
				}
			}
		}
		catch(NullPointerException e) {
			System.out.println("알림)) 잘못된 정보 입니다.");
			return false;
		}
		System.out.print("사용할 비민번호 입력 : \n");String pw = Day08_5.scanner.next();
		System.out.print("회원이름 입력 	 : \n");String name = Day08_5.scanner.next();
		System.out.print("이동통신번호 입력   : \n");String phone = Day08_5.scanner.next();
		System.out.print("주소입력(EX:서울시) : \n");String address = Day08_5.scanner.next();
		
		Member member = new Member(name, id, pw, phone, address);
		
		try {
			int i = 0;
			for(Member temp : Day08_5.members) {
				if(temp == null) {
					Day08_5.members[i] = member;
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
	
	String login() {//로그인
		System.out.println("로그인)");
		System.out.print("ID : \n");String id = Day08_5.scanner.next();
		System.out.print("PW : \n");String pw = Day08_5.scanner.next();
		boolean idcheck = false;
		try {
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
		}
		catch(NullPointerException e) {
			System.out.println("알림)) 잘못된 정보 입니다.");
			return null;
		}
		if(idcheck == false)System.out.println("알림)) 존재하지 않는 회원입니다.");
		return null;
	}
	
	void findid() {//아이디 찾기
		System.out.println("아이디 찾기)");
		System.out.print("사용자의 이름 : \n");String name = Day08_5.scanner.next();
		System.out.print("전화번호 입력 : \n");String phone = Day08_5.scanner.next();
		boolean idcheck = false;
		try {
			
			for(Member temp : Day08_5.members) {
				if(temp != null && temp.name.equals(name) && temp.phone.equals(phone)) {
					System.out.println("회원님의 아이디는 " + temp.id + " 입니다.");
					idcheck = true;
					return;
				}
			}
		}
		catch(NullPointerException e) {
			System.out.println("알림)) 잘못된 정보 입니다.");
		}
		if(idcheck == false)System.out.println("알림)) 존재하지 않는 회원입니다.");
	}
	
	void findpw() {//비밀번호찾기
		System.out.println("비밀번호 찾기)");
		System.out.print("사용자의 아이디: \n");String id = Day08_5.scanner.next();
		System.out.print("전화번호 입력 : \n");String phone = Day08_5.scanner.next();
		boolean idcheck = false;
		try {
			
			for(Member temp : Day08_5.members) {
				if(temp != null && temp.id.equals(id) && temp.phone.equals(phone)) {
					System.out.println("회원님의 비밀번호는 " + temp.pw + " 입니다.");
					idcheck = true;
					return;
				}
			}
		}
		catch(NullPointerException e) {
			System.out.println("알림)) 잘못된 정보 입니다.");
		}
		if(idcheck == false)System.out.println("알림)) 존재하지 않는 회원입니다.");
	}
	
}