package Day02;

import java.util.Scanner;

public class Day02_5 { // c s
	
	public static void main(String[] args) { // m s
		
		//문제3 : 하나의 정수를 입력받아 7의 배수인지 출력[ true , false ] 
		
		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("문제3)정수 입력 : "); int 문제3 = scanner.nextInt();
//		
//	    System.out.println("입력한 정수는 7의 배수인지 판단 : " + (문제3%7 == 0));
//		
//		
//		//문제4 : 하나의 정수를 입력받아 홀수 인지 확인 [ true , false ]
//		
//		System.out.println("문제4)정수 입력 : "); int 문제4 = scanner.nextInt();
//		
//		System.out.println("입력한 정수가 홀수인지 짝수인지 판단 : " + (문제4%2 == 1 ? "홀수" : "짝수"));
//		
//		
//		
//		//문제5 : 하나의 정수를 입력받아 7의 배수 이면서 짝수 인지 확인 [ true , false ]
//		System.out.println("문제5)정수 입력 : "); int 문제5 = scanner.nextInt();
//		
//		System.out.println("7의 배수이면서 짝수인지 판단 : " + (문제5%7==0 && 문제5%2==0));
//		
//		
//		//문제6 : 두개의 정수를 입력받아 더 큰지 출력  [ true , false ]
//		System.out.println("문제6)정수1 입력 : "); int 문제6_1 = scanner.nextInt();
//		System.out.println("문제6)정수2 입력 : "); int 문제6_2 = scanner.nextInt();
//		
//		System.out.println("더 큰 수는 : " + (문제6_1>문제6_2 ? 문제6_1 : 문제6_1 <문제6_2 ? 문제6_2 : "같다"));
//		
//		
//		//문제7 : 반지름을 입력받아 원 넓이 출력하기 
//		// 원 넓이 공식 => 반지름 * 반지름 * 원주율[3.14]
//		
//		System.out.println("문제7)반지름 입력 : "); int 문제7 = scanner.nextInt();
//		System.out.println("원 넓이 : " + (문제7*문제7*3.14));
//				
//		
//		//문제8 : 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇% 인지 출력하기
//		// 예) 54.5   84.3 이면    64.285714%
//		
//		System.out.println("문제8)실수1 입력 : "); float 문제8_1 = scanner.nextFloat();
//		System.out.println("실수2 입력 : "); float 문제8_2 = scanner.nextFloat();
//		
//		System.out.println(문제8_1/문제8_2*100+"%");
//		System.out.printf("실수1의 실수2 백분율 : %.2f %%\n", 문제8_1/문제8_2*100);
//					// %f : 실수 표현
//						// %.숫자f			// %.2f : 소수 2자리 까지 표현
//											// %.5f : 소수 5자리 까지 표현
//		
//		
//		//문제9 : 사다리꼴 넓이 구하기[윗변과 밑변 높이를 입력받아 출력하기]
//		//사다리꼴 계산식 = > (윗변 * 밑변) * 높이 / 2
//
//		System.out.println("문제9)윗변 길이 : "); double 문제9_1 = scanner.nextDouble();
//		System.out.println("밑변 길이 : "); double 문제9_2 = scanner.nextDouble();
//		System.out.println("높이 : "); double 문제9_3 = scanner.nextDouble();
//		
//		System.out.println("사다리꼴 넓이 :"+((문제9_1*문제9_2)*문제9_3/2));
//				
//		
//		//문제10: 키를 정수를 입력받아 표준체중 출력하기
//		//표준체중 계산식 = > (키 - 100) * 0.9
//		
//		System.out.println("문제10)키 : "); float 문제10 = scanner.nextFloat();
//		
//		System.out.println("표준체중 : "+((문제10-100)*0.9));
//	
//		
//		//문제11: 키와 몸무게를 입력받아 BMI 출력하기
//		//BMI 계산식 = > 몸무게 / ((키 / 100) * (키 / 100))
//		
//		System.out.println("문제11)키 : "); float 문제11_1 = scanner.nextFloat();
//		System.out.println("몸무게 : "); float 문제11_2 = scanner.nextFloat();
//		
//		System.out.printf("BMI : %.2f\n ",(문제11_2/((문제11_1/100)*(문제11_1/100))));
//		
//		
//		
//		//문제12: inch 를 입력받아 cm 로 변환하기 [ 1 inch -> 2.54cm ] 
//		
//		System.out.println("문제12)inch 입력 : "); int 문제12 = scanner.nextInt();
//		
//		System.out.println((문제12*2.54)+"cm");
//		
//
//		//문제13:  중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하기
//		//소수 둘째 자리 까지 점수 출력하기
//		//중간고사 반영비율 => 30 %
//		//기말고사 반영비율 => 30 %
//		//수행평가 반영비율 => 40 %
//
//		System.out.println("문제13)중간고사 점수 입력 : "); double 문제13_1 = scanner.nextDouble();
//		System.out.println("기말고사 점수 입력 : "); double 문제13_2 = scanner.nextDouble();
//		System.out.println("수행평가 점수 입력 : "); double 문제13_3 = scanner.nextDouble();
//		
//		System.out.printf("반영비율별 총점 : %.2f\n",(문제13_1*0.3)+(문제13_2*0.3)+(문제13_3*0.4));
//		
//		
////		//문제14 :  연산 순서 나열 하고 x와 y값 예측하기
//	 	int x = 10;
//		int y = x-- + 5 + --x;
//			// 1. x-- +5 -> 감소 전에 + => 10 + 5
			// 2. x-- -> x 감소 [x=9]
			// 3. 15 + --x -> 감소 먼저 [x=8]
			// 4. 15 + 8 => y=23
//		System.out.println(" x의 값 :" +x+"\t" + "y의값 :" + y);
//		
//			
//		
//		
//		//문제15 : 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년 으로 출력하기
//	
//		System.out.println("문제15)나이 입력 : "); int 문제15 = scanner.nextInt();
//		
//		System.out.println(문제15>=40 ? "중년" : 문제15>=20 ? "성인" : 문제15>=10 ? "학생" : "");
//		
//		
		//문제16 : 3개의 정수를 입력받아 오름차순으로 정렬 
//		System.out.println("문제16)정수1 입력 : "); int 문제16_1 = scanner.nextInt();
//		System.out.println("문제16)정수2 입력 : "); int 문제16_2 = scanner.nextInt();
//		System.out.println("문제16)정수3 입력 : "); int 문제16_3 = scanner.nextInt();
//		
//		int 큰수 = (문제16_1>문제16_2 && 문제16_1>문제16_3) ? 문제16_1 : 문제16_2>문제16_3 ? 문제16_2 : 문제16_3;
//		int 작은수 = (문제16_1<문제16_2 && 문제16_1<문제16_3) ? 문제16_1 : 문제16_2<문제16_3 ? 문제16_2 : 문제16_3;
//		int 중간수 = (문제16_1!=큰수 && 문제16_1!=작은수) ? 문제16_1 : (문제16_2!=큰수 && 문제16_2!=작은수) ? 문제16_2 : 문제16_3 ;
//		
//		
//		System.out.printf("%d,%d,%d\n", 작은수, 중간수, 큰수);
//		
//		
		//문제17 : 4개의 정수를 입력받아 내림차순으로 정렬 
		
		System.out.println("문제17)정수1 입력 : "); int 문제17_1 = scanner.nextInt();
		System.out.println("문제17)정수2 입력 : "); int 문제17_2 = scanner.nextInt();
		System.out.println("문제17)정수3 입력 : "); int 문제17_3 = scanner.nextInt();
		System.out.println("문제17)정수4 입력 : "); int 문제17_4 = scanner.nextInt();
		
		int num1 = ((문제17_1>문제17_2) && (문제17_1>문제17_3) && (문제17_1>문제17_4)) ? 문제17_1 : ((문제17_2>문제17_3) && (문제17_2>문제17_4)) ? 문제17_2 : (문제17_3>문제17_4) ? 문제17_3 : 문제17_4;
		int num4 = ((문제17_1<문제17_2) && (문제17_1<문제17_3) && (문제17_1<문제17_4)) ? 문제17_1 : ((문제17_2<문제17_3) && (문제17_2<문제17_4)) ? 문제17_2 : (문제17_3<문제17_4) ? 문제17_3 : 문제17_4;
		int num2 = 2 ;
		int num3 = 10;
		
		
		System.out.printf("%d,%d,%d,%d\n",num1,num2,num3,num4);
				
				
				
				
				
				
				
				
				
		
	} // m e

} // c e
