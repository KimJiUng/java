package Day01;

import java.util.Scanner;

public class Day01_5 { // c s

	public static void main(String[] args) { // m s
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("아이디 : "); String 아이디 = scanner.next();
		System.out.print("비밀번호 : "); String 비밀번호 = scanner.next();
		System.out.print("성명 : "); String 성명 = scanner.next();
		System.out.print("이메일 : "); String 이메일 = scanner.next();
		
		System.out.println(">>>>>>>>>>>> 회원가입 완료 아래 정보를 확인해주세요 >>>>>>>>>>>>");
		System.out.println("아이디\t비밀번호\t성명\t이메일");
		System.out.println( 아이디 +"\t" + 비밀번호 +"\t" + 성명 +"\t" + 이메일);
		
		
		
		
		
	} // m e
	
	
	
	
	
	
	
} // c e
