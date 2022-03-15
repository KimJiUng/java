package Day10;

public interface Gamepad {

	// 1.상수 필드
	// 2.추상 메소드
	public void A버튼();
	public void B버튼();
	public void C버튼();
	// 3.디폴트 메소드
	default void 게임패드종료() {
		System.out.println("게임패드 종료");
	}
	// 4.정적 메소드
	static void 충전() {
		System.out.println("충전중");
	}
	
	
}
