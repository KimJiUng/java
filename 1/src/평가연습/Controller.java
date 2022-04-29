package �򰡿���;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public class Controller {

	public static ArrayList<Car> carlist = new ArrayList<>(); 


	
	
	// ���� �޼ҵ�
	public static boolean incar(Date date,String carnumber) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat hm = new SimpleDateFormat("HH:mm");
		for(Car temp : carlist) {
			if(temp.getCarnum().equals(carnumber) && temp.getOuttime().equals("���� ��")) {
				return false;
			}
		}
		
		Car temp = new Car(carnumber,ymd.format(date), hm.format(date) , "���� ��", "���� ��",sdf.format(date));
		carlist.add(temp);

		return true;
	}
	
	// ���� �޼ҵ�
	public static int outcar(String carnumber) throws ParseException {
		
		for(Car temp : carlist) {
			if(temp.getCarnum().equals(carnumber) && temp.getPay().equals("���� ��")) {
				count(carnumber);
				return 3; // ���� �Ϸ�
			}	
		}
		for(Car temp : carlist) {
			if(temp.getCarnum().equals(carnumber)) {
				return 2; // �̹� ���Ϸ�� ����
			}
		}
		
		
		return 1; // ��ġ�ϴ� ���� ��ȣ ����
	}
	
	// �ݾװ�� �޼ҵ�
	public static void count(String carnumber) throws ParseException {
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat hm = new SimpleDateFormat("HH:mm");
		DecimalFormat decimalFormat = new DecimalFormat("###,###��");
		
		int i=0;
		for(Car temp : carlist) {
			Date date = new Date();
			if(temp.getCarnum().equals(carnumber)) {
				
				
				Date d1 = sdf.parse(temp.getIntime());
				Date d2 = date;
				String dateend = hm.format(d2);
				long diff = d2.getTime() - d1.getTime();
				long min = diff/(1000*60);
				long day = diff/(1000*60*60*24);

				
				long min1 = (long)Math.ceil(min/10.0) *10;
				int fee = (int)((day*144000)+(min1*100 -3000));
				if(min<=30) {
					fee=0;
				}
				System.out.println(min);
				carlist.get(i).setOuttime(dateend);
				carlist.get(i).setPay(decimalFormat.format(fee));
			
			} // if end
			
			
			i++;
		} // for end
	}
	
	
	
	
	
	
	
}
