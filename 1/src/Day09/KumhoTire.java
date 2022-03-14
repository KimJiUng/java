package Day09;

public class KumhoTire extends Tire { // c s

	// 1. 필드
	
	
	// 2. 생성자
	public KumhoTire(String location, int maxRotation){
		super(location, maxRotation);
		// 슈퍼클래스 내 생성자[코드 줄이기]
	}
	// 3. 메소드
	@Override
		public boolean roll() {
			accumlatedRotation++;
			if(accumlatedRotation<maxRotation) {
				System.out.println(location+"금호타이어 수명 : "+(maxRotation-accumlatedRotation)+"회");
				return true;
			}
			else System.out.println("***"+location+"금호타이어 펑크 ***");
			return false;
		}
	
	
} // c e
