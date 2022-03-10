package Day07;

public class Day07_4 { // c s

	public static void main(String[] args) { // m s
		
		// 1. 객체 선언
		Car2 myCar = new Car2();
		// 2. 자동차 시동 걸기
		myCar.keyTurnOn(); // 인수x 반환x
		// 3. 자동차 전진
		myCar.run(); // 인수 x 반환x
		// 4. 현재 스피드 확인 메소드 호출
		int speed = myCar.getSpeed(); // 인수x 반환o
		System.out.println("현재 속도: "+speed+"km/h");
		
	} // m e
} // c e
