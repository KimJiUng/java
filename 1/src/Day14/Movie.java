package Day14;

public class Movie extends Thread {

	static boolean stop = true; // 실행/종료 제어 역할
	
	public void moviestop(boolean stop) {
		this.stop=stop;
		if(stop) {
			System.out.println("영상재생");
		} else System.out.println("영상종료");
	}
	
	
	@Override
	public void run() {
		while(stop) {
			System.out.println("영상재생중~~");
			try { Thread.sleep(1000);}
			catch(Exception e) {}
		}
	}
	
	
}
