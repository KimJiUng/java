package Day04;

import java.util.Random;
import java.util.Scanner;

public class Day04_3 { // c s

	public static void main(String[] args) { // m s
		
		Scanner scanner = new Scanner(System.in);
		int com;
		int win = 0; int draw = 0; int lose = 0;
		
		while(true) { // 프로그램 실행 [ 무한루프 종료조건 : 4번 입력시 종료(break;)]
			System.out.println("-------가위바위보 게임--------");
			System.out.println("1.가위 2.바위 3.보      4.종료"); int player = scanner.nextInt();
			if(0<player && player<4) {
				System.out.println("플레이어가 낸 수 : "+player);
				
				Random random = new Random(); // 난수 객체 선언
				com = random.nextInt(3)+1; // 난수중 int형(정수)으로 가져오기
						// random.nextInt() : int가 표현할 수 있는 범위내 난수 발생
						// random.nextInt(수) : 0~수 전까지 범위내 난수 발생
						// random.nextInt(10) : 0~9 중 난수 발생
						// random.nextInt(10)+10 : 10~19 중 난수 발생
						// random.nextInt(끝번호)+시작번호
				System.out.println("컴퓨터가 낸 수 : "+com);
				
				if(player==1) {
					if(com==1) {
						System.err.println("알림)) 무승부");
						draw++;
					}
					if(com==2) {
						System.err.println("알림)) 패배");
						lose++;
					}
					if(com==3) {
						System.err.println("알림)) 승리");
						win++;
					}
				}
				else if(player==2) {
					if(com==1) {
						System.err.println("알림)) 승리");
						win++;
					}
					if(com==2) {
						System.err.println("알림)) 무승부");
						draw++;
					}
					if(com==3) {
						System.err.println("알림)) 패배");
						lose++;
					}
				}
				else if(player==3) {
					if(com==1) {
						System.err.println("알림)) 패배");
						lose++;
					}
					if(com==2) {
						System.err.println("알림)) 승리");
						win++;
					}
					if(com==3) {
						System.err.println("알림)) 무승부");
						draw++;
					}
				}
				
			} // if end
			else if(player==4){ // 종료
				System.out.println("---------게임 종료-----------");
				System.out.println("총 게임 수 : "+(win+draw+lose));
				System.out.printf("승리 : %d 무승부 : %d 패배 : %d\n",win,draw,lose);
				if(win>lose) {
					System.err.println("player win");
				}
				else if(win<lose) {
					System.err.println("computer win");
				}
				else System.err.println("draw");
				break;
			}
			else System.out.println("알림)) 잘못된 입력입니다.");
			

		} // while end
		
		
		
		
	} // m e
	
	
} // c e
