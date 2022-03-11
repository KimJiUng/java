package Day08_4;

import Day08_3.A;

public class C {
	// A 클래스와 패키지 다름 클래스도 다름
		// public 만 가능
	
	// 1. 필드
	A a1 = new A(true);
	// A a2 = new A(1); // 불가능
	// A a3 = new A("문자열"); // 불가능
	// 2. 생성자
	public C() {
		A a = new A(true);
	//	a.field1;
		// a.field2; // 불가능
		// a.field3; // private 이기 때문에 사용 불가능
		
		a.method1();
		// a.method2(); // 불가능
		// a.method3(); // 불가능
	}
	// 3. 메소드
	
	
}
