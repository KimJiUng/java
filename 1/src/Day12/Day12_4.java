package Day12;

import java.util.Random;
import java.util.Scanner;

public class Day12_4 { // c s

	// 차량번호 구분
	// 조건
		// 1. 난수 0000~9999 사이의 차량번호 난수 10개 생성
		// 2. 모든 차량 번호를 배열에 저장
		// 3. 끝자리 번호로 홀수/짝수 구분
		// 4. 차량 끝자리 번호가 홀수 차량 배열에 저장
		// 5. 차량 끝자리 번호가 짝수 차량 배열에 저장
		// 6. 홀수 차량 배열 출력 / 짝수 차량 배열 출력
		
	public static void main(String[] args) { // m s
		String[] car = new String[10];
		String[] odd = new String[10];
		String[] even = new String[10];
		byte[] bytes = new byte[100];
		Scanner scanner = new Scanner(System.in);
		
		
		while(true) {
			try {
				// 모든 차량번호 출력
				System.out.println("\n** 주차중인 모든 차량 번호 **");
				for(String temp : car) {
					if(temp!=null) {
						System.out.print(temp+"\t");
					}	
				}
				// 홀수 차량 번호 출력
				System.out.println("\n** 주차중인 모든 홀수 차량 **");
				for(String temp : odd) {
					if(temp!=null) System.out.print(temp+"[홀]\t");
				}
				
				// 짝수 차량 번호 출력
				System.out.println("\n** 주차중인 모든 짝수 차량 **");
				for(String temp : even) {
					if(temp!=null) System.out.print(temp+"[짝]\t");
				}
				System.out.println("\n1.차량입차"); int ch = scanner.nextInt();
				if(ch==1) {
					// 차량번호 난수 생성
					Random random = new Random(); // 랜덤 객체
					int intnum = random.nextInt(10000); // 0~9999 중 난수 발생
					String strnum = String.format("%04d", intnum);
											// 형식 
												// %d : 정수
												// %숫자d : 숫자만큼 자릿수 [만일 해당 자릿수가 없으면 공백]
												// %0숫자d : 숫자만큼 자릿수 [만일 해당 자릿수가 없으면 0]
					// 배열내 공백을 찾아 차량번호 저장
					boolean save = false;
					for(int i=0; i<car.length; i++) {
						if(car[i]==null) {car[i]=strnum; save=true; break;}	
					}
					if(save==true) {

							if(Integer.parseInt(strnum)%2 == 0) {
								for(int i=0; i<even.length; i++) {
									if(even[i]==null) {even[i]=strnum; break;}
								}
							} else {
								for(int i=0; i<odd.length; i++) {
									if(odd[i]==null) {odd[i]=strnum; break;}
								}
							}
										
					}
					
					// 만약에 빈공간이 없으면 만차
					if(save==false) System.out.println("만차 [주차 불가]");
				}
				
				
				
			}catch(Exception e) {
				
			}
		} // while end
		
		
		
		
		
		
		
		
		
		
	} // m e
	
	
	
	
} // c e
