package Day01;

public class Day01_2 { // c s

	public static void main(String[] args) { // m s
		//1. 기본출력
		System.out.print("print는 출력만");
		System.out.print("java 1일차");	// 문자 "" 처리 o
		System.out.print(123);			// 숫자 "" 처리 x
			// * 미리 만들어진 단어[예약어]를 제외한 문자는 "" 처리
		// 2. 자동완성 ( syso + ctrl + space bar)
		System.out.println("println은 줄바꿈까지");
		System.out.println("dfaf23");
		System.out.println(123);
		
		// 3. 형식출력
		System.out.printf("%s","f=format 출력에 꾸미기");
		System.out.printf("java %d일차" , 1);
		System.out.printf("%d" , 123);
		

		
			// %s : 문자열 들어가는 자리
			// %d : 정수가 들어가는 자리
			// %f : 실수가 들어가는 자리
		
			// 예제1 [출석부]
		System.out.println("\n\t\t[[출석부]]");
		System.out.println("----------------------------------------");
		System.out.println("이름\t1교시\t2교시\t3교시\t비고");
		System.out.println("강호동\t출석\t결석\t출석");
		System.out.println("유재석\t출석\t결석\t출석");
		System.out.println("----------------------------------------");
		
			// 예제2 [예제1 -> printf]
		System.out.printf("\n\t\t%s" , "[출석부]\n");
		System.out.printf("----------------------------------------\n");
		System.out.printf("%s\t%s\t%s\t%s\t%s \n" , "이름","1교시","2교시","3교시","비고");
		System.out.printf("%s\t%s\t%s\t%s \n" , "강호동","출석","결석","출석");
		System.out.printf("%s\t%s\t%s\t%s \n" , "유재석","출석","결석","출석");
		System.out.printf("----------------------------------------\n");
		
		// 문제1 : 고양이
		/*		\	/\
		  		 ) ( `)
		  		( /	 )
		 		 \(__)ㅣ
		 */
		System.out.println("\t\\    /\\");
		System.out.println("\t )  ( `)");
		System.out.println("\t(  /  )");
		System.out.println("\t \\(__)|\n"); // | : shift + \
		// 문제2 : 강아지
		System.out.println("\t|\\_/|"); // / 출력시 -> \\
		System.out.println("\t|q p|   /}"); 
		System.out.println("\t( 0 )\"\"\"\\"); // " 출력시 -> \"
		System.out.println("\t|\"^\"`    |");
		System.out.println("\t||_/=\\\\__|");
		
		
		
	} // m e
	// 1. 출력
		// 1. print()
		// 2. printf()
		// 3. println()
	// 1. System : 시스템 클래스 [입출력 관련 만들어진 코드 제공]
	// 2. out : 출력 스트림
	// 3. print() : 출력함수
	// 4. ; : 한줄 코드 끝 알림
	// * 시스템 클래스 내 out 이라는 출력스트림을 통해 print 함수를 사용해서
	//   console에 원하는대로 출력할 수 있다.






} // c e
