package Day15;

public class TargetThread extends Thread {

	@Override
	public void run() { // 스레드 상태 : NEW : 객체생성되고 멀티스레드 실행전
		for(long i=0; i<1000000000; i++) {} // 스레드 상태 : RUNNABLE : 멀티스레드 실행중
		
		try { Thread.sleep(1500);} // 스레드 상태 : WAITING : 멀티스레드 일시정지
		catch(Exception e) {}
		
		for(long i=0; i<1000000000; i++) {} // 스레드 상태 : RUNNABLE : 멀티스레드 실행중
	} // run 메소드가 종료되면 스레드 상태 : TERMINATED : 멀티스레드 종료
	
}
