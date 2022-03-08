package Day06;

public class Korean {
	// * Korean 클래스 선언
	
	
	
	// 1. 필드
	String nation ="대한민국";
		// 국가 변수에 미리 대한민국 대입
	String name;
		// 이름 변수에는 초기화x [null]
	String ssn;
		// 주민등록번호 변수에는 초기화 x [null]
	// 중요한 변수[돈, 개인정보 등] -> 캡슐화(은닉화)
	// 2. 생성자
		// 조건1 : 생성자이름==클래스이름 동일
		// 조건2 : 외부로부터 들어오는 매개값[인수] 선언
		// 조건3 : 동일한 생성자 이름을 가질 수 있다.
			// 오버로딩 : 동일한 이름일경우 코드를 재정의
	Korean(){ // 1. 빈생성자
		
	}
	
		// 2. 필드 1개를 갖는 생성자
	Korean(String name){
		this.name = name;
	}
	
		// 3. 필드 2개를 갖는 생성자
	Korean(String n, String s){ 
		name = n;
		ssn = s;
	}
	
		// 4. 필드 3개를 갖는 생성자
	Korean(String nation, String name, String ssn){
		this.nation = nation;
		this.name = name;
		this.ssn = ssn;
		// 내부변수 (현재 클래스내 변수)
		// 매개변수 (외부로부터 들어온 변수)
		// 내부변수 == 매개변수 이름이 동일하면 충돌
		// 내부변수 표시 방법
			// this : 현재 클래스 표시
			
	}
	// 3. 메소드
	
}
