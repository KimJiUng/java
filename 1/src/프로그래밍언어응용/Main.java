package 프로그래밍언어응용;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				
				System.out.println("------------------------------주차 현황 표--------------------------------");
				System.out.println("\t\t현재 시간 : "+sdf.format(date)+"\n");
				System.out.println(" 날짜\t\t차량번호\t\t입차시간\t\t출차시간\t\t금액");
				for(Car temp : Controller.carlist) {
					System.out.println(temp.getIntimeymd()+"\t"+temp.getCarnum()+"\t"+temp.getIntimehm()+"\t\t"+
				temp.getOuttime()+"\t\t"+temp.getPay());
				}
				System.out.println("-----------------------------------------------------------------------");
				System.out.println("1.입차 2.출차");
				int ch = scanner.nextInt();
				
				if(ch==1) {
					System.out.println("차량번호 입력 : "); String carnum = scanner.next();
					boolean result = Controller.incar(date,carnum);
					if(result) {
						System.out.println("입차가 완료되었습니다.");
					}
					else System.out.println("이미 주차중인 차량입니다.");
				}
				else if(ch==2) {
					System.out.println("차량번호 입력 : "); String carnum = scanner.next();
					int result = Controller.outcar(carnum);
					if(result == 1) {
						Controller.count(carnum);
						System.out.println("출차가 완료되었습니다.");
					}
					else if(result == 2) {
						System.out.println("이미 출차된 차량입니다.");
					}
					else if(result == 3) {
						System.out.println("일치하는 차량번호가 없습니다.");
					}
					
				}
				else System.out.println("알 수 없는 번호입니다.");
			}catch(Exception e) {
				System.out.println("잘못된 입력입니다.");
				scanner = new Scanner(System.in);
			}
			
			
		} // while end
			
		
		
		
		
	} // m e
	
} // c e
