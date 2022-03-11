package Day07;

public class Member1 { // c s

	// 1. 필드
	int mno;
	String id;
	String password;
	String name;
	String phone;
	
	// 2. 생성자
		// 1. 빈생성자 [기본생성자] : 메소드 호출용 객체 생성시
	public Member1() { }
		// 2. 모든 필드를 받는 생성자 : 회원가입용 객체 생성시
	public Member1(int mno, String id, String password, String name, String phone) {
		this.mno = mno;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	
	// 3. 메소드
	
		// 1. 회원가입 [인수x반환o] // 가입성공 : true 실패 : false
	boolean 회원가입() {
		System.out.println("---------------회원가입 페이지----------------");
		// 1. 입력받는다 [id, pw, name, phone]
		System.out.println("아이디 : "); String id = Day07_5_BookApplication.scanner.next();
		// * 아이디 중복체크
		for(Member1 temp : Day07_5_BookApplication.members) {
			if(temp!=null && temp.id.equals(id)) {
			// 만약에 공백이 아니면서 배열내 id와 입력받은 id가 동일하면
				System.out.println("알림)) 현재 사용중인 아이디 입니다.");
				return false; // 아이디가 중복되었기 때문에 false[가입실패]
			}
		} // for end
		System.out.println("비밀번호 : "); String password = Day07_5_BookApplication.scanner.next();
		System.out.println("이름 : "); String name = Day07_5_BookApplication.scanner.next();
		System.out.println("연락처 : "); String phone = Day07_5_BookApplication.scanner.next();
			// * scanner 객체가 다른 클래스내 static 선언되어있음
			// * 클래스명.필드명.함수명()
			// * static 필드,메소드는 객체없이 호출가능 [클래스명.필드명/메소드명]
		
			// * 회원번호 자동주입 [ 가장 최근에 가입한 회원의 번호 +1 ]
		int bno = 0;
		int j = 0;
		for(Member1 temp : Day07_5_BookApplication.members) {
			if(temp==null) {
				if(j==0) { // 첫번째 인덱스[0번 인덱스]가 null => 첫회원
					bno = 1; break;
				}
				else {
					bno = Day07_5_BookApplication.members[j-1].mno+1;
					
					break;	
				}
				
			}
			j++;
		}
		
		// 2. 4개변수 -> 객체화 -> 1개
		Member1 member = new Member1(bno, id, password, name, phone);
			// 모든 필드 받는 생성자로 객체 생성
		
		// 3. 배열내 빈 공간을 찾아서 새로운 회원[객체] 넣기
		int i=0;
		for(Member1 temp : Day07_5_BookApplication.members) {
			if(temp==null) {
				Day07_5_BookApplication.members[i]=member; // 빈 인덱스에 새로운 회원 대입
				System.out.println("알림)) 회원님의 회원번호 : "+bno);
				return true; // 회원가입 메소드 종료 ~~~~ [ 반환 : true ]
			}
			i++;
		} // for end
		return false; // 회원가입 메소드 종료 ~~~~ [반환 : false ]
		// 4. 가입 성공시 true 반환 실패시 false 반환
	}
	
		



	// 2. 로그인 [인수x반환o]
			// 로그인성공시 성공한 아이디반환 // 실패시 null 반환
	String 로그인() {
		System.out.println("---------------로그인 페이지----------------");
		// 1. 일반회원 로그인
			// 아이디 비밀번호 입력 일치하면 로그인 성공 아니면 로그인실패
		System.out.println("아이디 : "); String id = Day07_5_BookApplication.scanner.next();
		System.out.println("비밀번호 : "); String password = Day07_5_BookApplication.scanner.next();
		
		for(Member1 temp : Day07_5_BookApplication.members) {
			if(temp!=null && temp.id.equals(id) && temp.password.equals(password)) {
				return temp.id; // 성공한 id 반환
			}
		} // for end
		return null; // 실패시 null 반환	
		// 2. 관리자 로그인
		
			// 1. 도서등록
			// 2. 도서목록
			// 3. 도서삭제
			// 4. 대여순위
			// 5. 로그아웃
		
	}
		// 3. 아이디찾기 [인수x반환x] // 이름 , 연락처
	void 아이디찾기() {
		System.out.println("---------------아이디찾기 페이지----------------");
		// 1. 입력받기
		System.out.println("이름 : "); String name = Day07_5_BookApplication.scanner.next();
		System.out.println("연락처 : "); String phone = Day07_5_BookApplication.scanner.next();
		// 2. 입력받은 값을 배열에 찾기
		for(Member1 temp : Day07_5_BookApplication.members) {
			if(temp!=null && temp.name.equals(name) && temp.phone.equals(phone)) {
				System.out.println("알림)) 회원님의 아이디 : "+temp.id);
				return; // 동일한 값을 찾았으면 해당 메소드 종료
			}
			else System.out.println("알림)) 일치하는 정보가 없습니다.");
			return;
		}
	} // 아이디 찾기 end
		// 4. 비밀번호찾기 [인수x반환x] // 아이디, 연락처
	void 비밀번호찾기() {
		System.out.println("---------------비밀번호찾기 페이지---------------");
		System.out.println("아이디 : "); String id = Day07_5_BookApplication.scanner.next();
		System.out.println("연락처 : "); String phone = Day07_5_BookApplication.scanner.next();
		
		for(Member1 temp : Day07_5_BookApplication.members) {
			if(temp!=null && temp.id.equals(id) && temp.phone.equals(phone)) {
				System.out.println("알림)) 회원님의 비밀번호 : "+temp.password);
				return;
			}
			else System.out.println("알림)) 일치하는 정보가 없습니다.");
			return;
		}
	}
		// 5. 회원탈퇴
	void 회원탈퇴() {
		
	}
		// 6. 회원수정
	
} // c e
