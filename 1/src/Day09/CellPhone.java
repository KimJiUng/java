package Day09;

public class CellPhone { // c s

	// 1. 필드
	String model;
	String color;
	
	// 2. 생성자
	
	
	// 3. 메소드 [ void : 반환타입 없다(return 생략 가능)
	void powerOn() { System.out.println("전원을 켭니다.");}
// 	반환타입x 메소드명(인수x)	{ 실행코드 } : 반환 x 인수 x
	void powerOff() { System.out.println("전원을 끕니다.");}
	void bell() { System.out.println("벨이 울립니다.");}
	void sendVoice(String message) { System.out.println("자기 : "+message);}
//	반환타입x 메소드명(인수o) { } : 인수o 반환x
	void receiveVoice(String message) { System.out.println("상대방 : "+message);}
	void hangUp() { System.out.println("전화를 끊습니다.");}
	
	
} // c e
