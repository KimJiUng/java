package 평가연습;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class 평가연습_1 { // c s

	public static void main(String[] args) { // m s
		
		Scanner scanner = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		

		while(true) {
			Date date = new Date();
			try {
				System.out.println("-----------------------------주차 현황 표-------------------------------");
				System.out.println("\t\t현재 시간 : "+sdf.format(date));
				System.out.println();
				System.out.println(" \t날짜\t\t차량번호\t\t입차시간\t\t출차시간\t\t금액");
				for(Car temp : Controller.carlist) {
					
					System.out.println(temp.getIntimeymd()+"\t\t"+temp.getCarnum()+"\t\t"+temp.getIntimehm()+
					"\t\t"+temp.getOuttime()+"\t\t"+temp.getPay() );
				}
				
				System.out.println("---------------------------------------------------------------------");
				System.out.println("1. 입차   2. 출차");
				int ch = scanner.nextInt();
				
				if(ch==1) {
					System.out.println("차량번호 입력 : ");
					String carnumber = scanner.next();
					boolean result = Controller.incar(date,carnumber);
					
					if(result) {
						System.out.println("주차가 완료되었습니다.");
					}else {
						System.out.println("이미 주차중인 차량입니다.");
					}
				}
				else if(ch==2) {
					System.out.println("차량번호 입력 : ");
					String carnumber = scanner.next();
					int result = Controller.outcar(carnumber);
					
					if(result==1) {
						System.out.println("일치하는 차량번호가 없습니다.");
					}
					else if(result==2) {
						System.out.println("이미 결제완료한 차량입니다.");
					}
					else if(result==3) {
						
						for(int i=0; i<Controller.carlist.size(); i++) {
							if(Controller.carlist.get(i).getCarnum().equals(carnumber)) {
								System.out.println("결제금액 : "+Controller.carlist.get(i).getPay());
								System.out.println("출차완료");
								break;
							}
							
						}
					}
					
				}
				else System.out.println("알 수 없는 번호입니다.");
		
			}catch(Exception e) {
				e.printStackTrace();
				scanner = new Scanner(System.in);
			}
					
		}
		
		
	} // m e
	
	
	
} // c e
