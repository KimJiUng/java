package Day09;

public class HankookTire extends Tire { // c s

	// 1. 필드
	
	
	// 2. 생성자
	public HankookTire(String location, int maxRotation){
		super(location, maxRotation);
		// super(인수1, 인수2) // 슈퍼클래스내 [인수2개] 생성자 호출
	}
	
	// 3. 메소드
	@Override // 슈퍼클래스내 메소드를 재정의[수정]
		public boolean roll() {
			accumlatedRotation++;
			if(accumlatedRotation<maxRotation) {
				System.out.println(location+"한국타이어 수명 : "+(maxRotation-accumlatedRotation)+"회");
				return true;
			}
			else System.out.println("***"+location+"한국타이어 펑크 ***");
			return false;
		}
	
	
	
} // c e
