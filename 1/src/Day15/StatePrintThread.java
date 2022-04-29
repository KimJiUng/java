package Day15;

public class StatePrintThread extends Thread{

	private Thread targetThread; // 스레드 저장
	
	public StatePrintThread(Thread targetThread) { // 외부로부터 받은 스레드객체를 내부에 저장
		this.targetThread = targetThread;
	}
	
	// 병렬처리
	@Override
	public void run() { // 스레드 상태 : NEW : 객체생성되고 멀티스레드 실행전
		while(true) {
			// 스레드 상태 호출
			Thread.State state = targetThread.getState(); // 현 스레드 상태 호출
			System.out.println("타겟스레드 상태 : "+state);
			
			// 스레드 상태 제어
			if(state == Thread.State.NEW) { // NEW : 스레드 생성 상태
				targetThread.start();
			}
			if(state == Thread.State.TERMINATED) { // TERMINATED : 스레드 종료 상태
				break;
			}
			try { Thread.sleep(500);}
			catch(Exception e) {}
		
		}
	}
	
	
}
