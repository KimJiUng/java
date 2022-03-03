package Day03;

import java.util.Scanner;

public class Day03_2 { // c s

	public static void main(String[] args) { // m s
		
		// 문제1 : 2개의 정수를 입력받아서 더 큰수 출력
		
		// 입력객체 = { } 당 1번 선언
		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("정수1 입력 : "); int 문제1_1 = scanner.nextInt();
//		System.out.println("정수2 입력 : "); int 문제1_2 = scanner.nextInt();
//			// int형 변수 선언하고 입력받은 데이터를 정수로 가져와서 대입
//		
//		// 제어
//		if(문제1_1>문제1_2) System.out.println("더 큰 수 : "+문제1_1);
//		// 만약에 입력받은 문제1_1 이 문제1_2 보다 크면 실행 아니면 다음 조건
//		else if(문제1_1<문제1_2) System.out.println("더 큰 수 : "+문제1_2);
//		// [다음조건] 문제1_1 이 문제1_2 보다 작으면 실행 아니면 그외
//		else System.out.println("같다.");
//		// 나머지[그외] 실행
//		
//		// 문제2 : 3개의 정수를 입력받아서 가장 큰 수 출력
//		
//		System.out.println("정수1 입력 : "); int 문제2_1 = scanner.nextInt(); // 변수명 중복x
//		System.out.println("정수2 입력 : "); int 문제2_2 = scanner.nextInt();
//		System.out.println("정수3 입력 : "); int 문제2_3 = scanner.nextInt();
//		
//		int max = 문제2_1; // 가장 큰수를 저장하는 변수
//			// max에 첫번째 값 넣어두기
//		if(max<문제2_2) { // 만약에 max보다 문제2_2가 더 크면 교체
//			int temp = 문제2_2; // 임시변수[스왑용]
//			문제2_2 = max;
//			max = temp;
//			// = max = 문제2_2;
//		}
//		if(max<문제2_3) {max=문제2_3;}
//		System.out.println("가장 큰 수 : "+max);
//		
//		// 문제3 : 4개의 정수를 입력받아서 가장 큰 수 출력
//		
//		System.out.println("정수1 입력 : "); int 문제3_1 = scanner.nextInt();
//		System.out.println("정수2 입력 : "); int 문제3_2 = scanner.nextInt();
//		System.out.println("정수3 입력 : "); int 문제3_3 = scanner.nextInt();
//		System.out.println("정수4 입력 : "); int 문제3_4 = scanner.nextInt();
//		
//		int max2 = 문제3_1;
//		if (max2<문제3_2) {max2=문제3_2;}
//		if (max2<문제3_3) {max2=문제3_3;}
//		if (max2<문제3_4) {max2=문제3_4;}
//		System.out.println("가장 큰 수 : "+max2);
//		
//		
//		// 문제4 : 3개의 정수를 입력받아서 오름차순
//		
//		System.out.println("정수1 입력 : "); int 문제4_1 = scanner.nextInt(); 
//		System.out.println("정수2 입력 : "); int 문제4_2 = scanner.nextInt();
//		System.out.println("정수3 입력 : "); int 문제4_3 = scanner.nextInt();
//		
//		if(문제4_1>문제4_2) {
//			int temp = 문제4_1; // 임시변수 = 변수1 ;
//			문제4_1 = 문제4_2; // 변수1 = 변수2 ;
//			문제4_2 = temp; // 변수2 = 임시변수;
//			// 교체[스왑 = 2개 변수의 데이터 교환방법]		
//		}
//		if(문제4_1>문제4_3) { int temp = 문제4_1; 문제4_1 = 문제4_3; 문제4_3 = temp;}
//		if(문제4_2>문제4_3) { int temp = 문제4_2; 문제4_2 = 문제4_3; 문제4_3 = temp;}
//		System.out.printf("입력한 값 오름차순 : %d  %d  %d\n", 문제4_1, 문제4_2, 문제4_3);
//		System.out.println("입력한 값 오름차순 : " + 문제4_1 + 문제4_2 + 문제4_3);
//		
		// 문제5 : 4개의 정수를 입력받아서 오름차순
		
		System.out.println("정수1 입력 : "); int 문제5_1 = scanner.nextInt(); 
		System.out.println("정수2 입력 : "); int 문제5_2 = scanner.nextInt();
		System.out.println("정수3 입력 : "); int 문제5_3 = scanner.nextInt(); 
		System.out.println("정수4 입력 : "); int 문제5_4 = scanner.nextInt();
		
		if(문제5_1>문제5_2) {int temp = 문제5_1; 문제5_1 = 문제5_2; 문제5_2 = temp;}
		if(문제5_1>문제5_3) {int temp = 문제5_1; 문제5_1 = 문제5_3; 문제5_3 = temp;}
		if(문제5_1>문제5_4) {int temp = 문제5_1; 문제5_1 = 문제5_4; 문제5_4 = temp;}
			// 정수1을 정수2,3,4 와 비교 후 정수1에 가장 작은 수 넣기
		if(문제5_2>문제5_3) {int temp = 문제5_2; 문제5_2 = 문제5_3; 문제5_3 = temp;}
		if(문제5_2>문제5_4) {int temp = 문제5_2; 문제5_2 = 문제5_4; 문제5_4 = temp;}
			// 정수2를 3,4 와 비교 후 정수2에 가장 작은 수 넣기
		if(문제5_3>문제5_4) {int temp = 문제5_3; 문제5_3 = 문제5_4; 문제5_4 = temp;}
			// 정수3과 4 비교 후 정수3에 작은 수 넣기
		System.out.printf("입력한 값 오름차순 : %d %d %d %d\n",문제5_1,문제5_2,문제5_3,문제5_4);
		
		
	} // m e
	
	
} // c e
