package Day15;

import java.awt.Toolkit;

public class Day15_7 {

	public static void main(String[] args) {
	// p.601 스레드 제어
			// 1. sleep() : 주어진 시간동안 일시 정지
				// 시간단위 : 밀리초(1/1000초)
				// 일반 예외 발생 : 일시정지샅애에서 주어진 시간이 되기전에 실행
			// 2. Thread.yield() : 다른 스레드에게 실행 양보 [ 대기상태 ]
			// 3. Thread.join() : 다른 스레드의 종료를 기다림 [ 다른 스레드가 끝날때까지 기다림 ]
		// p.602 sleep 예제
			
			
			
//		Toolkit toolkit = Toolkit.getDefaultToolkit(); // 소리 관련 클래스
//		for(int i=0; i<10; i++) {
//			toolkit.beep(); // 소리내기 [소리가 1번 작동중에 for문 끝남]
//			try {Thread.sleep(3000);} catch(Exception e) {} // 3초간 일시정지
//		}
//		
//		
//			// p.604~606 yield()
//			// 1. 객체생성
//			ThreadA threadA = new ThreadA();
//			// 2. 객체생성
//			ThreadB threadB = new ThreadB();
//			// 3. 스레드 시작
//			threadA.start();
//			threadB.start();
//			// 4. 스레드 3초간 일시정지
//			try {Thread.sleep(3000);}catch(Exception e) {}
//			// 5. 스레드A에 work값 변경
//			threadA.work = false;
//				
//			// 6. 스레드 3초간 일시정지
//			try {Thread.sleep(3000);}catch(Exception e) {}
//			// 7. 스레드A에 work값 변경
//			threadA.work = true; 
//			
//			// 8. 스레드 3초간 일시정지
//			try {Thread.sleep(3000);}catch(Exception e) {}
//			// 9. 스레드 A,B 종료
//			threadA.stop = true;
//			threadB.stop = true;
//			threadA.stop(); // 권장하지 않는 메소드 [스레드의
//			
			
		// p.607 : join()
			
			// 1. 객체 생성
			SumThread sumThread = new SumThread();
			// 2. 스레드 실행
			sumThread.start();
			// 3. 스레드 join
			try {
			sumThread.join(); // 일반 예외처리 발생
			} catch(Exception e) {}
			
			// 4. 출력
			System.out.println("1~100 합계 : "+sumThread.getSum());
			
			// * main스레드가 join 안했을때 : 0
				// SumThread가 더하기를 끝내기 전에 main 스레드 sum 출력
			// * main스레드가 join 했을때 : 5050
			
	} // m e
	

	
	
	
	
} // c e
