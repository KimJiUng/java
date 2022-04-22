package 평가연습;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Controller {

	public static ArrayList<Car> carlist = new ArrayList<>(); 


	
	
	// 입차 메소드
	public static boolean incar(Date date,String carnumber) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat hm = new SimpleDateFormat("HH:mm");
		for(Car temp : carlist) {
			if(temp.getCarnum().equals(carnumber) && temp.getOuttime().equals("주차 중")) {
				return false;
			}
		}
		
		Car temp = new Car(carnumber,ymd.format(date), hm.format(date) , "주차 중", "정산 전",sdf.format(date));
		carlist.add(temp);

		return true;
	}
	
	// 출차 메소드
	public static int outcar(String carnumber) throws ParseException {
		
		for(Car temp : carlist) {
			if(temp.getCarnum().equals(carnumber) && temp.getPay().equals("정산 전")) {
				count(carnumber);
				return 3; // 출차 완료
			}	
		}
		for(Car temp : carlist) {
			if(temp.getCarnum().equals(carnumber)) {
				return 2; // 이미 계산완료된 차량
			}
		}
		
		
		return 1; // 일치하는 차량 번호 없음
	}
	
	// 금액계산 메소드
	public static void count(String carnumber) throws ParseException {
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat hm = new SimpleDateFormat("HH:mm");
		DecimalFormat decimalFormat = new DecimalFormat("###,###원");
		
		int i=0;
		for(Car temp : carlist) {
			Date date = new Date();
			if(temp.getCarnum().equals(carnumber)) {
				
				
				Date d1 = sdf.parse(temp.getIntime());
				Date d2 = date; // 현재시간 
				String dateend = hm.format(d2); // 출차시간 출력용 변환
				long diff = d2.getTime() - d1.getTime();
				long min = diff/(1000*60);
				

				System.out.println(min);
				long min1 = (long)Math.ceil(min/10.0) *10;
				min = (min1*100 -3000);
				if(min<=30) {
					min=0;
				}
				System.out.println(min);
				int fee = (int)min;
				
				carlist.get(i).setOuttime(dateend);
				carlist.get(i).setPay(decimalFormat.format(fee));
			
			} // if end
			
			
			i++;
		} // for end
	}
	
	
	
	
	
	
	
}
