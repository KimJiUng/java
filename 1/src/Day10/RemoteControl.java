package Day10;

public interface RemoteControl { // 인터페이스 선언

	// 멤버 구성
		// 1. 상수 필드 : 고정된 데이터
		public int MAX_VOLUME = 10; // 리모컨의 최대 음량
		public int MIN_VOLUME = 0; // 리모컨의 최소 음량
		
		// 2. 추상 메소드** : 선언o 구현x
			// abstract : 추상 [인터페이스에서는 생략]
		public void turnOn(); // {} 생략 [구현x]
		public void turnOff(); // 구현 x
		public void setVolume(int volume); // 구현x
		
		// 3. 디폴트 메소드 : 선언o 구현o 
		default void setMute(boolean mute) {
			if(mute) {
				System.out.println("무음 처리");
			} else {
				System.out.println("무음 해제");
			}
		}
		
		// 4. 정적 메소드 : 선언o 구현o [객체없이 가능]
		static void changeBattery() {
			System.out.println("건전지 교체합니다.");
		}
	
	
	
} // i e
