package Day06;

import java.util.Scanner;

public class Day06_3 { // c s

	public static void main(String[] args) { // m s
		
		// 회원제 프로그램 [클래스 버전]
			// 0. 회원 설계 => 회원 클래스 만들기
				// 1. 필드
					// 1. 아이디 2. 비밀번호 3. 이름 4. 전화번호
			// 1. 초기메뉴 [1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기]
				// 1. 회원가입시 입력받아 저장
				// 2. 로그인시 아이디와 비밀번호가 동일하면 로그인처리
				// 3. 아이디찾기는 이름과 전화번호가 동일하면 아이디 출력
				// 4. 비밀번호찾기는 아이디와 전화번호가 동일하면 비밀번호 출력
		
		// 위에 선언하는 이유 : main 메소드 모든곳에서 사용하기 위해서
		Scanner scanner = new Scanner(System.in);
		Member[] memberlist = new Member[100];
		// 만약에 클래스가 없었을 경우에는 String [][] memberlist = new String[100][4];
		// Member 클래스로 만들어진 객체(id,pw,name,phone) 100개 저장할 수 있는 배열 선언
		
		while(true) { // 프로그램 실행 무한루프 [종료조건 x]
			
			System.out.println("-----------회원제[클래스버전]------------");
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			System.out.println("선택 : "); int ch = scanner.nextInt();
			
			if(ch==1) {
				// 1. id, pw, name, phone 입력받기 => 변수 4개
				System.out.println("-------------회원가입 페이지-----------");
				System.out.println("아이디 : "); String id = scanner.next();
				System.out.println("비밀번호 : "); String pw = scanner.next();
				System.out.println("이름 : "); String name = scanner.next();
				System.out.println("연락처 : "); String phone = scanner.next();
				
				// 2. 객체 생성
				Member member = new Member();
				
				// 3. 입력받은 변수 4개 -> 객체에 저장
				member.id = id;
				member.pw = pw;
				member.name = name;
				member.phone = phone;
				
				// 4. 아이디 중복이 없을 경우 여러개 객체를 배열에 저장
					// 1. 공백 인덱스 찾기 [공백이 아니면 기존회원이 존재하기 때문]
					// 2. 공백 인덱스에 객체 저장
				int i = 0; // 인덱스 위치 변수
				
				for(Member temp : memberlist) { // memberlist 배열내 member 객체 하나씩 꺼내와서 temp에 저장 반복
					boolean idcheck=true;
					// * 아이디 중복체크
						// 1. 배열내 객체중 입력한 아이디와 동일한 아이디 찾기
					if(temp!=null && temp.id.equals(id)) {
						System.out.println("알림)) 사용중인 아이디 입니다.[회원가입 실패]");
						idcheck=false;
						break;
					}
					else if(idcheck==true && temp==null) { 
						memberlist[i] = member; // 해당 인덱스에 새로 만들어진 객체 저장
						System.out.println("알림)) 회원가입 성공");
						break; // for 나가기 [안나가면 모든 공백에 동일한 객체 저장하기 때문]
					} // else if end
					i++; // 인덱스 번호 증가
				} // for end
				
			} // if 회원가입 end
			
			else if(ch==2) {
				
				// 1. 입력받기
				System.out.println("--------------로그인 페이지---------------");
				System.out.println("아이디 : "); String loginid = scanner.next();
				System.out.println("비밀번호 : "); String loginpw = scanner.next();
				// 2. 기존 배열[memberlist] 내 입력받은 값과 비교
				boolean logincheck=false; // true : 로그인 성공 false : 로그인 실패
				for(Member temp : memberlist) {
					// * memberlist내 0번 인덱스부터 끝 인덱스까지 하나씩 temp에 대입
					// 배열/리스트 내 모든 객체 호출
					if(temp != null && (temp.id.equals(loginid)) && (temp.pw.equals(loginpw))) {
						// * 객체가 null 일때는 .equals() 불가 [null 아닌 상태에서만 .equals() 가능]
						System.out.println("알림)) 로그인 성공");
						logincheck=true; // 로그인 성공했다는 표시 남기기
					}
				}
				
				// 3. 로그인 성공 유무 판단
				if(logincheck==false) { // 로그인 성공시에는 아래 코드 실행 불가
					System.out.println("알림)) 동일한 회원정보가 없습니다.");
				}
				
			} // else if 로그인 end
			
			else if(ch==3) { // 아이디찾기는 이름과 전화번호가 동일하면 아이디 출력
				// 1. 이름과 연락처를 입력받는다.
				System.out.println("------------아이디 찾기 페이지------------");
				System.out.println("이름 : "); String name = scanner.next();
				System.out.println("연락처 : "); String phone = scanner.next();
						
				// 2. 배열내 동일한 이름과 연락처가 있는지 확인한다.
				boolean findcheck = false;
				for(Member temp : memberlist) {
					
					if(temp!=null && temp.name.equals(name) && temp.phone.equals(phone)) {
						System.out.println("알림)) 아이디 찾기 성공");
						System.out.println("회원 ID : "+temp.id);
						findcheck = true;
						break;
					}
					
				} // for end
				if(findcheck==false) System.out.println("알림)) 동일한 회원정보가 없습니다.");
				// 3. 동일한 객체가 있으면 해당 아이디 출력
				// 4. 없으면 없다고 출력
				
			} // else if 아이디찾기 end
			
			else if(ch==4) { // 비밀번호찾기는 아이디와 전화번호가 동일하면 비밀번호 출력
				System.out.println("------------아이디 찾기 페이지------------");
				System.out.println("아이디 : "); String id = scanner.next();
				System.out.println("연락처 : "); String phone = scanner.next();
				boolean findcheck = false;
				for(Member temp : memberlist) {
					
					if(temp!=null && temp.id.equals(id) && temp.phone.equals(phone)) {
						System.out.println("알림)) 비밀번호 찾기 성공");
						System.out.println("회원 PASSWORD : "+temp.pw);
						findcheck = true;
						break;
					}
					
				} // for end
				if(findcheck==false) System.out.println("알림)) 동일한 회원정보가 없습니다.");
			} // else if 비밀번호찾기 end
			else {
				System.out.println("알림)) 알 수 없는 번호입니다.");
			} // else 그외 end
			
			
			
		} // while end
		
		
		
		
	} // m e
	
} // c e
