package Day14;

import java.awt.Toolkit;

public class BeepTask implements Runnable {
					// 구현하다 [Runnable]
	// implements 사용시 추상메소드 꼭 구현하기
	
	@Override
	public void run() { // Runnable 인터페이스내 run메소드 구현하기
		
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // 객체생성
		for(int i=0; i<5; i++) { // 5회 반복
			toolkit.beep(); // 소리내기
			try {
			Thread.sleep(500); // 일반예외가 무조건 발생 -> 예외처리 무조건
			}catch(Exception e) {
				
			}
		}
		
	}
	
	
	
	
	
}
