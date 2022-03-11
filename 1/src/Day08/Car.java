package Day08;

public class Car { // c s

	// 1. 필드
	private int speed;
	private boolean stop;
	// 외부 클래스에서 접근 불가능 변수
	// 2. 생성자
	
	// 3. 메소드
	public int getSpeed() { // private 필드 호출시 사용되는 메소드
		return speed;
	}
	public void setSpeed(int speed) { // private 필드 변경시 사용되는 메소드
		if(speed<0) {
			this.speed=0; // 0 아래로 저장 불가능하게 0 대입
			return;
		}
		else {
			this.speed=speed; // 인수로 들어온 스피드 저장
			
		}
	}
	
	public boolean isStop() { // private 필드 호출시 사용되는 메소드
		return stop;
	}
	
	public void setStop(boolean stop) { // private 필드 변경시 사용되는 메소드
		this.stop=stop;
		this.speed=0;
	}
	
} // c e
