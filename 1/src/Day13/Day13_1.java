package Day13;

import java.util.Random;

public class Day13_1 { // c s

	public static void main(String[] args) { // m s
		
		// p.534 : Math 클래스 (java.lang 패키지) [ 수학 관련 메소드 제공 ] 객체없이 사용가능
		
		// 1. Math.abs(수) : 해당 수의 절대값
		System.out.println("절대값 : "+Math.abs(-5));
		System.out.println("절대값 : "+Math.abs(-3.14));
		
		// 2. Math.ceil(수) : 가까운 정수로 올림
		System.out.println("올림값 : "+Math.ceil(5.3)); // 무조건 올림
		System.out.println("올림값 : "+Math.ceil(-5.3));  // -5
		
		// 3. Math.floor(수) : 가까운 정수로 내림
		System.out.println("버림값 : "+Math.floor(5.3)); 
		System.out.println("버림값 : "+Math.floor(-5.3));
		
		// 4. Math.max(수1, 수2) : 두 수 중 더 큰수 출력
		System.out.println("최댓값 : "+Math.max(5, 9));
		System.out.println("최댓값 : "+Math.max(5.3, 2.5));
		
		// 5. Math.min(수1, 수2) : 두 수 중 더 작은수 출력
		System.out.println("최솟값 : "+Math.min(5, 9));
		System.out.println("최솟값 : "+Math.min(5.3, 2.5));
		
		// 6. Math.random() : 0~1 사이의 double형 난수 발생
		System.out.println("난수 : "+Math.random()); // 0~1 사이의 난수 발생
		// vs 
		Random random = new Random();
		System.out.println("난수 : "+random.nextInt()); 
		
		// 7. Math.rint(수) : 가까운 정수의 실수값으로 반올림
		System.out.println("가까운 정수의 실수값 : "+Math.rint(5.3)); // 반올림 실수값
		System.out.println("가까운 정수의 실수값 : "+Math.rint(5.7));

		// 8. Math.round(수) : 가까운 정수의 정수값으로 반올림
		System.out.println("가까운 정수의 정수값 : "+Math.round(5.3)); // 반올림 정수값
		System.out.println("가까운 정수의 정수값 : "+Math.round(5.7));
		
		// 9. 특정 소수점 위치에서 반올림 [ round() : 소수점 첫째자리에서 반올림 ]
		double value = 12.3456;
		double temp = value*100; // 1234.56
		long temp2 = Math.round(temp); // 1235
		double v16 = temp2/100.0;
					// temp2/100 -> long/int -> 기본정수형 : int
					// temp2/100.0 -> long/double -> 기본실수형 : double
		System.out.println("v16 : "+v16);
		
		
		
		// 10. p.536 : 주사위 [1~6]
		int num = (int)(Math.random()*6)+1;
		System.out.println(num);
		///////////////////////////////////////////////////////////
		System.out.println(random.nextInt(6)+1); 
		
		
		
	} // m e
	
	
	
	
} // c e
