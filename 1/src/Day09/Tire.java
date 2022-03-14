package Day09;

public class Tire { // c s
// 슈퍼클래스로 사용할 예정
	
	
	// 1. 필드
	public int maxRotation; // 최대 회전수[회전 가능수]
	public int accumlatedRotation; // 누적 회전수
	public String location; // 타이어의 위치
	
	// 2. 생성자
	public Tire(String location, int maxRotation) {
		this.location=location; // 외부로부터 전달받은 인수를 내부변수에 대입
		this.maxRotation=maxRotation;
				
	}
	
	// 3. 메소드
	public boolean roll() { // 타이어 회전 구현 메소드
		accumlatedRotation++;
		if(accumlatedRotation<maxRotation) {
			// 만약에 누적회전수가 최대회전수보다 적으면[수명 남음]
			System.out.println(location+"Tire 수명 : "+(maxRotation-accumlatedRotation)+"회");
			return true;
		}
		else {
			System.out.println("***"+location+"타이어 펑크 ***");
			return false;
		}
	}
	
	
	
} // c e
