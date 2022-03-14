package Day09;

public class Car { // c s

	// 1. 필드
	Tire frontLeftTire = new Tire("앞왼쪽",6);
	Tire frontRightTire = new Tire("앞오른쪽",2);
	Tire backLeftTire = new Tire("뒤왼쪽",3);
	Tire backRightTire = new Tire("뒤오른쪽",4);
	
	// 2. 생성자
	
	// 3. 메소드
	int run() { // 자동차회전 [모든 타이어객체가 1회씩 회전 메소드
		System.out.println("자동차가 달립니다.");
		if(frontLeftTire.roll()==false) { // 리턴이 1이면 앞왼쪽 타이어가 펑크
			stop(); return 1;
		}
		// 타이어가 회전을 했는데 결과가 false 이면 펑크
		// true 이면 수명 남음.
		if(frontRightTire.roll()==false) { // 리턴이 2이면 앞오른쪽 타이어가 펑크
			stop(); return 2;
		}
		if(backLeftTire.roll()==false) { // 리턴이 3이면 뒤왼쪽 타이어가 펑크
			stop(); return 3;
		}
		if(backRightTire.roll()==false) { // 리턴이 4이면 뒤오른쪽 타이어가 펑크
			stop(); return 4;
		}
		return 0; // 리턴이 0이면 펑크 x
	}

	void stop() {
		System.out.println("자동차가 멈춥니다.");
	}
	
	
} // c e
