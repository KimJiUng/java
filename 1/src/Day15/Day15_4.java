package Day15;

public class Day15_4 { // c s
 
	public static void main(String[] args) { // m s
		
		// 12장 : 스레드 : 코드를 읽어주는 역할
			// 코드 -> 파일 -> 프로세스[프로그램]
			// 목적 : 병렬처리
				// main메소드에 main스레드 포함
		
			// 사용방법
				// 1. Thread 클래스		
				// 2. Runnable 인터페이스
		
			// run 메소드 : 멀티스레드의 실행코드
		
		// 예1) Thread 클래스를 이용한 병렬처리 만들기
		
		음악 m1 = new 음악();
		m1.start(); // Runnable은 start() 메소드를 가지고 있지 않음
		
		// 예2) Runnable 인터페이스를 이용한 병렬처리 객체 만들기
		채팅 c1 = new 채팅();
		Thread thread = new Thread(c1);
		thread.start();
		
		while(true) { // main 스레드 실행중
			System.out.println(" * 프로그램 작동중 * ");
			try { Thread.sleep(500);}
			catch(Exception e) {}	
		}
		
		
		// p.591 동기화
			// 멀티스레드 사용시 동기화 선택 [단일스레드 사용시에는 동기화x] 
			// * 여러개 스레드 동일한 메소드 호출
			// 동시다발적으로 하나의 메소드 호출
		
		// 예1) 동기화 없는 메소드 사용시
		
		
		
		
	} // m e
	
	
} // c e
