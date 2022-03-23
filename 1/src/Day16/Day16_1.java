package Day16;

public class Day16_1 {

	public static void main(String[] args) {
		
		// 제네릭
		
		// p.656 비제네릭 예1)
		
		// 1. Box 객체 생성
		Box box = new Box();
		// 2. Box 객체내 메소드 호출
		box.set("홍길동");
		// 3. 객체내 메소드 호출
		String name = (String)box.getObject();
		
			// 자식객체 -> 부모객체 [ 자동형변환 ]
			// 부모객체 -> 자식객체 [ 자동x 강제o ]
		
		// 4.
		box.set(new Apple()); // [인수 : Apple]
		Apple apple = (Apple)box.getObject();
		
		
	}
}
