package Day04;

import java.util.Random;
import java.util.Scanner;

public class Day04_5 { // c s

	public static void main(String[] args) { // m s
		
		
		//예제) 로또 판별기
		// 1. 사용자 6개 수 입력받기
		//		1. 1~45 사이 수 만 입력받기 아니면 재입력
		//		2. 중복이면 재입력
		// 2. 추첨번호 : 컴퓨터 난수 6개 발생
		//		1. 1~45 사이
		//		2. 중복x
		// 3. 사용자 추첨번호와 컴퓨터 추첨번호와 동일 수의 개수
		
		
		// 준비
		int[] num = new int[6]; // 사용자가 선택한 번호 목록
		int[] com = new int[6]; // 컴퓨터의 난수 번호 목록
		Scanner scanner = new Scanner(System.in);
		
		// 1. 사용자에게 입력받기
		for(int i=0; i<6; i++) {
			System.out.println("1~45 사이 입력 : ");
			int 번호 = scanner.nextInt();
			
			boolean pass = true; // 저장되는 조건 변수
			
			// 조건1 : 유효성검사
			if(번호<=0 || 번호>=46) {
				System.out.println("알림))선택할 수 없는 번호입니다.");
				// 1보다 작거나 45보다 크면 선택할 수 없는 번호 입력시 재입력
				i--; // 현재 i는 정상입력 x
				pass = false; // 저장 x
			} // if end
		
			// 조건2 : 중복체크
				// 1. 배열내 모든 인덱스 호출
			for(int j=0; j<6; j++) {
				if(번호 == num[j]) {
					// 2. 입력받은 값과 같은지 비교
					System.out.println("알림)) 이미 선택한 번호입니다.[재입력]");
					i--; // 현재 i는 정상입력 x
					pass = false; // 저장 x
				} // if end
			} // for2 end
			
			// 정상입력 이면 배열에 저장하기
			if(pass==true) num[i] = 번호;
			
			
		} // for end
		
		System.out.print("\n사용자가 선택한 번호 : ");
		// * 사용자 배열내 모든 인덱스 출력
		 for(int temp : num)
			 System.out.print(temp+"\t");
		// 2. 컴퓨터가 난수 생성
		 for(int i = 0; i<6; i++) {
			 
			 Random random = new Random(); // 1. 난수객체
			 int 추첨 = random.nextInt(45)+1; // 2. 난수를 int형으로 가져오기
			 						// random.nextInt() : +-20억 사이중 난수 발생
			 						// random.nextInt(수) : 0~수 사이중 난수 발생
			 						// random.nextInt(수)+시작번호 : 시작번호~수 사이중 난수 발생
			 // 조건 : 중복체크
			 boolean pass = true;
			 for(int temp : com) {
				 if(추첨==temp) {
					 i--; // 중복이 있을경우 현재 i 예외
					 pass = false;
				 }
			 }
			 if(pass) com[i]=추첨;
			 
		 } // for end
		 
		 System.out.print("\n\t추첨번호 : ");
			// * 사용자 배열내 모든 인덱스 출력
			 for(int temp : com)
				 System.out.print(temp+"\t");
		 
		// 3. 비교 = 두 배열간 동일한 수 찾기
		//방법 1
		int sum = 0;
		for(int i=0; i<6; i++) { // i : 비교 기준점
			for(int j=0; j<6; j++) { // j : 비교 대상
				if(num[i]==com[j]) { // 사용자 배열내 i번째 인덱스와 j번째 인덱스의 수가 동일하면
					sum++;
				}
				
			} // for2 end
			
		} // for1 end
		
		
		// 방법 2
//		for(int 비교기준 : num) {
			// 사용자번호 배열내 하나씩 비교기준 대입
//			for(int 비교대상 : com) {
				// 추첨번호 배열내 하나씩 비교대상 대입
//				if(비교기준 == 비교대상) sum++;
//			}
//		}
		System.out.println("\n일치하는 개수 : "+sum);
		
		if(sum==6) {
			System.out.println("1등");
		}
		else if(sum==5) {
			System.out.println("2등");
		}
		else if(sum==4) {
			System.out.println("3등");
		}
		else if(sum==3) {
			System.out.println("4등");
		}
		else System.out.println("미당첨"); 
		
		
	} // m e
	
} // c e
