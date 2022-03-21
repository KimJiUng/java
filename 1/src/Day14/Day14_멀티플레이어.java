package Day14;

import java.util.Scanner;

public class Day14_멀티플레이어 { // c s

	// 예제 [ 1.소리재생/중지 2.영상재생/중지 ]
	
	public static void main(String[] args) { // m s
		
		Scanner scanner = new Scanner(System.in);
		// 현재 재생 상태 저장
		boolean soundsw = true;
		boolean moviesw = true;
		
		while(true) {
			System.out.print("1.소리재생 2.영상재생 :");
			int ch = scanner.nextInt();
			
			if(ch==1) {
				
				Sound sound = new Sound(); // 빈 객체 생성
				
				if(soundsw) { // 소리재생
					sound.soundstop(true);
					sound.start();
					
					soundsw = false; // 소리 종료
				}
				else {
					sound.soundstop(false);
					soundsw = true; // 실행종료

				}
				
			} 
			else if(ch==2) {
				
				Movie movie = new Movie();
				
				if(moviesw) {
					movie.moviestop(true);
					movie.start();
					moviesw = false;
				}
				else {
					movie.moviestop(false);
					moviesw = true;
				}
				
				
			}
			
		}
		
		
	} // m e
	
} // c e
