package 평가연습;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class 평가연습_2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			
			System.out.println("---------주차 현황 표----------");
			System.out.println("현재 시간 : "+sdf.format(date));
			System.out.println("날짜\t차량번호\t입차시간\t출차시간\t금액");
			System.out.println("-----------------------------");
			System.out.println("1.입차     2.출차");
			int ch = scanner.nextInt();
			
			if(ch==1) {
				System.out.println("차량번호 입력 : ");
				String carnum = scanner.next();
				Controller2.incar();
			}
			else if(ch==2) {
				System.out.println("차량번호 입력 : ");
				String carnum = scanner.next();
				Controller2.outcar();
			}
			else System.out.println("알 수 없는 번호입니다.");
			
			
			
			
			
		}
		
		
	}
	
	
}
