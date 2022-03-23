package 프로그래밍언어응용;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Controller {

	public static ArrayList<Car> carlist = new ArrayList<>();
	
	
	// 입차 메소드
	public static boolean incar(Date date, String carnum) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat hm = new SimpleDateFormat("HH:mm");
		for(Car temp : carlist) {
			if(temp.getCarnum().equals(carnum) && temp.getOuttime().equals("주차 중")) {
				return false;
			}
		}
		Car temp = new Car(carnum,sdf.format(date),ymd.format(date),hm.format(date),"주차 중","정산 전");
		carlist.add(temp);
		return true;
	}
	
	// 출차 메소드
	public static int outcar(String carnum) {
		for(Car temp : carlist) {
			if(temp.getCarnum().equals(carnum) && temp.getPay().equals("정산 전")) {
				return 1; // 출차성공
			}
		}
		for(Car temp : carlist) {
			if(temp.getCarnum().equals(carnum)) {
				return 2; // 이미 출차완료한 차량
			}
		}
		return 3; // 일치하는 차량 번호 없음
	}
	
	// 금액계산 메소드
	public static void count(String carnum) throws ParseException {
		
		int i=0;
		for(Car temp : carlist) {
			if(temp.getCarnum().equals(carnum) && temp.getPay().equals("정산 전")) {
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				SimpleDateFormat hm = new SimpleDateFormat("HH:mm");
				DecimalFormat df = new DecimalFormat("###,###원");
				
				Date d1 = sdf.parse(temp.getIntime());
				Date d2 = date;
				String outtime = hm.format(d2);
				
				long dif = d2.getTime() - d1.getTime();
				long min = dif/(1000*60);
				long min1 = (long)Math.ceil(min/10.0)*10;
				long pay =min1*100-3000;		
				if(min<=30) {
					pay=0;
				}
				
				carlist.get(i).setOuttime(outtime);
				carlist.get(i).setPay(df.format(pay));
				
			}
			i++;
		}
	}
	
	
}
