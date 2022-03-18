package Day13;

import java.util.Calendar;
import java.util.Scanner;

public class Day13_3_달력 { // c s
	
	
	public static void main(String[] args) { // m s
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("연도 : "); int year = scanner.nextInt();
				System.out.println("월 : "); int month = scanner.nextInt();
				if(month<1 || month>12) {
					System.out.println("1~12월 사이로 입력해주세요.");
				}else {
					boolean exit = 달력(year, month); 
					if(exit==false) {
						break;
					}
				}
				
			}catch(Exception e){
				System.out.println("잘못된 입력입니다.");
				scanner = new Scanner(System.in);
			} 
			
			
		} // while end
				
		
				
		
	} // m e
	
	// 1. 달력메소드
	public static boolean 달력(int year, int month) {
		
		while(true) {
			try {
			// 1. 캘린더 클래스내 현재 날짜/시간 객체 호출
					Calendar calendar = Calendar.getInstance();
					
					// 2. 현재 연도, 월, 일
	//				int year = calendar.get(Calendar.YEAR);
	//				int month = calendar.get(Calendar.MONTH)+1;
					int day = calendar.get(Calendar.DAY_OF_MONTH);
					// * 해당 월의 1일의 요일 찾기
						// 1. 사용자 정의 캘린더 설정
					calendar.set(year, month-1, 1); // 예 3월1일
						// 2. 3월1일의 요일
					int sweek = calendar.get(Calendar.DAY_OF_WEEK);
						// 3. 3월의 마지막 일
					int eday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
										// 해당날짜의 마지막 일수
					// 3. 출력
					System.out.println(" ********************* "+year+"년"+month+"월 **********************");
					System.out.println("일\t월\t화\t수\t목\t금\t토");
					
					// * 현재 월 1일의 위치 앞에 공백 채우기
					for(int i=1; i<sweek; i++) {
						System.out.print("\t");
					}
					// 1일부터 마지막 날짜까지 출력
					for(int i=1; i<=eday; i++) {
						
						System.out.print(i+"\t");
						// 토요일마다 줄바꿈처리 [ 토요일 = 7 ] 요일이 7배수마다 줄바꿈
						if(sweek%7==0) {
							System.out.println();
						}
						sweek++; // 하루씩 요일 증가
					}
					
					// 버튼 [ 1.◀(이전달) 2.▶(다음달) 3.다시검색 ]
					Scanner scanner = new Scanner(System.in);
					System.out.println("\n1.◀(이전달) 2.▶(다음달) 3.다시검색 4.종료");
					int ch = scanner.nextInt();
					
					if(ch==1) {
						if(month==1) {
							year -= 1; month = 12;
						}
						else month -= 1; 
					}
					else if(ch==2) {
						if(month==12) {
							year += 1; month = 1;
						}
						else month += 1; 
					}
					else if(ch==3) {
						System.out.println("연도 : "); year = scanner.nextInt();
						System.out.println("월 : "); month = scanner.nextInt();
						if(month<1 || month>12) {
							System.out.println("잘못된 입력입니다.");
						}
					}
					else if(ch==4) {
						return false; // 메소드 종료
					}
			} catch(Exception e) {
				
			}
		} // while end
					
				
				
				
	}
	
	
	
	
	
} // c e
