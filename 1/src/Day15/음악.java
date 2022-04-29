package Day15;

public class 음악 extends Thread{

	@Override
	public void run() {
		// 병렬처리 실행
		while(true) { // 음악클래스내 스레드가 실행중
			System.out.println("음악");
			try { Thread.sleep(500);}
			catch(Exception e) {}
		}
	}
	
	
}
