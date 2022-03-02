package Day02;

import java.util.Scanner;

public class Day02_3 { // c s

	public static void main(String[] args) { // m s
		
		// 문제1 : 급여 계산
		/*
		 * [입력조건]
		 * 		기본급, 수당
		 * [조건]
		 * 		실수령액 = 기본급 + 수당 -세금[기본급10%]
		 * [출력조건]
		 * 		실수령액 출력
		 */
		// * 입력 -> 저장 -> 출력
		// 1. 입력 객체 만든다.[자료형 소문자, 클래스명 대문자]
		Scanner scanner = new Scanner(System.in);
		
		// 2. 입력받은 값을 변수에 저장한다.[입력객체는 입력받을 때마다 기존 데이터가 사라짐]
		System.out.println("기본급 입력 : "); int 기본급 = scanner.nextInt();
				// 입력객체명.nextInt() : int형 데이터 가져오기
				// 입력객체명.next() : 문자열 데이터 가져오기
		System.out.println("수당 입력 : "); int 수당 = scanner.nextInt();
		
		// 3. 변수를 연산(계산)한다.
		int 세금 = (int)(기본급*0.1); // int * double 후에 int 형으로 강제변환(캐스팅)
		int 실수령액 = 기본급 + 수당 - 세금 ; // 100% : 1 , 10%:0.1
		// 4. 출력한다.
		System.out.println("회원님의 실수령액 : " + 실수령액);
						// 		문자열		변수명(변수내 데이터 호출)
						// + : 1. 연결연산자 기능 2. 더하기 기능
		
		
		// 문제2 : 지폐 세기
		/*
		 * [입력조건]
		 * 		금액
		 * [조건]
		 * 		십만원부터 백원까지의 개수 세기
		 * [출력조건]
		 * 		예) 356789 입력시
		 * 			십만원 3장
		 * 			만원 5장
		 * 			천원 6장
		 * 			백원 7개
		 */
		
		Scanner scanner2 = new Scanner(System.in);
		
		System.out.println("금액 입력 : "); int 금액 = scanner2.nextInt();
		
		int 십만원 = 금액/100000;
		int 만원 = 금액/10000 - 십만원*10;
		int 천원 = 금액/1000 - 십만원*100 - 만원*10;
		int 백원 = 금액/100 - 십만원*1000 - 만원*100 - 천원*10; 
		System.out.println("십만원 : " + 십만원 + "장");
		System.out.println("만원 : " + 만원 + "장");
		System.out.println("천원 : " + 천원 + "장");
		System.out.println("백원 : " + 백원 + "개");
		
		
		
		
		
		
		
		
		
		
	} // m e
	
} // c e
