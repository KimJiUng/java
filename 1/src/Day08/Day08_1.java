package Day08;

public class Day08_1 { // c s

	public static void main(String[] args) { // m s
		
		// p.238 : static
			// 정적변수
			// 공용적인 데이터 = 프로그램 전반적으로
		
		// * 클래스내 필드, 메소드(멤버) 접근방법
			// 1.(static 멤버가 아닐때) 객체 생성 -> 객체.멤버
				// 객체가 생성될때 new 연산자로 객체(내 멤버포함) 메모리 할당
		Calculator calculator = new Calculator();
		System.out.println("객체를 이용한 멤버접근 : "+calculator.pi);
			// 2.(static 멤버일때) 1. 클래스명.멤버
				// 클래스 로딩 되고 메소드영역에 static 변수들 저장
		System.out.println("객체없이 멤버접근 : "+calculator.pi);
		
		double result = 10 * 10 * calculator.pi;
								// 클래스명.정적변수명
		int result2 = Calculator.plus(10, 5);
		
		int result3 = Calculator.minus(10, 5);
		
		System.out.println("result : "+result);
		System.out.println("result2 : "+result2);
		System.out.println("result3 : "+result3);
		
		
		 
	} // m e
} // c e
