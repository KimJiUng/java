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
		
		int i=0; // 인덱스 번호
		for(Car temp : carlist) {
			Date date = new Date();
			if(temp.getCarnum().equals(carnumber)) {
				
				
				Date d1 = sdf.parse(temp.getIntime()); // String -> Date 형식으로 변환
				Date d2 = date; // 현재시간 
				String dateend = hm.format(d2); // 출차시간 출력용 변환
				long diff = d2.getTime() - d1.getTime(); // 출차시간 - 입차시간
				long min = diff/(1000*60); // 위 계산식 분으로 환산
				

				System.out.println(min);
				long min1 = (long)Math.ceil(min/10.0) *10; // 1~10분에 천원을 받기 위해서 분으로 계산한 식을 10.0으로 나눈후 올리고 곱하기
				min = (min1*100 -3000); // 최초 30분 무료이기 때문에 3천원깎기
				if(min<=30) { // 30분 무료
					min=0;
				}

				int fee = (int)min; // long으로 계산한거를 int로 변환
				
				// 리스트에 저장
				carlist.get(i).setOuttime(dateend);
				carlist.get(i).setPay(decimalFormat.format(fee)); // 천단위 자리 구분해서 저장
			
			} // if end
			
			
			i++; // 인덱스번호 증가
		} // for end
	}
	
	
	
	
	
	
	
}
