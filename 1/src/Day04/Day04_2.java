package Day04;

import java.util.Scanner;

public class Day04_2 { // c s

	public static void main(String[] args) { // m s
		
		Scanner scanner = new Scanner(System.in);
		
		// 자판기
			// 1. 메뉴판 [1.콜라(300) 2.환타(200) 3.사이다(100) 4.결제]
			//			1. 메뉴판에서 제품 선택하면 장바구니에 넣기
			//			2. 재고가 부족하면 알림(재고 부족)
			// 2. 초기 재고 [ 제품 당 10개씩 ]				
			// 3. 결제시 금액입력 받아 결제액 만큼 차감 후 잔돈 출력
			//			1. 투입한 금액보다 결제액이 더 크면 결제 취소
		
		// 공통변수 [ 모든 괄호내에서 사용하는 변수들]
		int 콜라재고 = 10; int 환타재고 = 10;	int 사이다재고 = 10;
			// 재고변수
		int 콜라구매수 = 0; int 환타구매수 = 0; int 사이다구매수 = 0;
			// 장바구니
		while(true) { // w s
			System.out.println("-------------------메뉴------------------");
			System.out.println("1.콜라(300) 2.환타(200) 3.사이다(100) 4. 결제");
			System.out.print(">>>>>> 선택 :"); int 선택 = scanner.nextInt();
			
			if(선택 == 1) { // 콜라 구매
				if(콜라재고==0) { // 콜라재고가 0이면 구매불가
					System.err.println("알림)) 재고가 없습니다. 재고 준비중");
				}
				else { // 콜라재고가 있으면 구매가능
					System.err.println("[[ 콜라 담았습니다.]]");
					콜라구매수++; // 장바구니에 콜라 담기
					콜라재고--; // 콜라 재고 차감
				}
			} // 콜라 구매 end
			else if(선택==2) { // 환타 구매
				if(환타재고==0) { 
					System.err.println("알림)) 재고가 없습니다. 재고 준비중");
				}
				else { 
					System.err.println("[[ 환타 담았습니다.]]");
					환타구매수++; 
					환타재고--; 
				}
			} // 환타 구매 end
			else if(선택==3) { // 사이다 구매
				if(사이다재고==0) { 
					System.err.println("알림)) 재고가 없습니다. 재고 준비중");
				}
				else { 
					System.err.println("[[ 사이다 담았습니다.]]");
					사이다구매수++; 
					사이다재고--;
				}
			} // 사이다 구매 end
			else if(선택==4) { // 결제
				
				System.out.println("---------------결제 제품 목록---------------");
				System.out.println("제품명\t수량\t금액");
				if(콜라구매수>0) System.out.println("콜라\t"+콜라구매수+"\t"+(콜라구매수*300));
				if(환타구매수>0) System.out.println("환타\t"+환타구매수+"\t"+(환타구매수*200));
				if(사이다구매수>0) System.out.println("사이다\t"+사이다구매수+"\t"+(사이다구매수*100));
				int 총결제액 = (콜라구매수*300)+(환타구매수*200)+(사이다구매수*100);
				System.out.println("제품 총 결제액 : "+총결제액);
				System.out.println("----------------------------------------");
				System.out.println(" 1. 결제 2. 취소"); int 선택2 = scanner.nextInt();
				
				if( 선택2==1 ) { // 1. 결제
					// 1. 금액 입력받는다.
					// 2. 금액이 결제액보다 적으면 결제불가 -> 금액 재 입력
					// 3. 금액이 결제액보다 많으면 결제성공 -> 장바구니 초기화 + 잔돈 출력
					while(true) { // 무한루프 [종료조건 : 결제액보다 금액이 크면]
						System.out.println("결제 금액 입력 : "); int 결제금액 = scanner.nextInt();
						if(총결제액>결제금액) { // 결제불가 -> 재입력
							System.out.println("알림)) 금액이 부족합니다. 다시 금액 투여");
						}
						else { // 금액이 더 크면
							System.out.println("알림)) 구매완료");
							System.out.println("잔돈 : "+(결제금액-총결제액)+"원");
							콜라구매수 = 0; 환타구매수 = 0; 사이다구매수 = 0; // 구매수 초기화
							break; // while 탈출
						}
					} // while2 end
				}
				else if( 선택2==2 ) { // 2. 취소
					System.out.println("알림)) 구매목록 모두 지우기 ");
					콜라재고 += 콜라구매수; 환타재고 += 환타구매수; 사이다재고 += 사이다구매수; // 구매수를 재고로 옮기기
					콜라구매수 = 0; 환타구매수 = 0; 사이다구매수 = 0;					// 구매수 초기화
				}
				else {
					System.err.println("알림)) 알 수 없는 행동입니다.");
				}
				
				
			} // 결제 end
			else {
				System.err.println("알림)) 알 수 없는 행동입니다.");
			}
		} // w e
		
	} // m e
} // c e
