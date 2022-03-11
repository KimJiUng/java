package Day08;

public class Calculator { // c s
	
	// 메모리 사용하기 위해서 메모리 할당
		// 1. 변수 : 기본자료형 변수명 = 데이터
				// * new 연산자 x
		// 2. 배열 : 기본자료형 배열명 = new 기본자료형[길이]
		//			클래스명 배열명 = new 기본자료형[길이]
		// 3. 객체 : 클래스명 객체명 = new 생성자명();
		
		// * new 연산자는 main 메소드의 흐름(스레드)의 의해서 할당
		// * static 연산자는 프로그램 실행시 파일[클래스] 로딩될때 할당
	
		// 변수 : 변하는 수 // 상수 : 고정된 수
	
	
	// 자료형 앞에 static : 정적필드, 정적메소드
		// 객체 없이 바로 사용 가능
	
	// 1. 필드
	static double pi = 3.14159;
	// 정적변수
	
	
	// 2. 생성자
	
	// 3. 메소드
	
	static int plus(int x, int y) {
		return x+y;
	}

	
	static int minus(int x, int y) {
		return x-y;
	}
	
	// 정적 블록
	static {
		
	}
	
} // c e
