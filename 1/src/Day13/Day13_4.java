package Day13;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Day13_4 { // c s
	
	public static void main(String[] args) throws InterruptedException { // m s
		
		// p.544 DecimalFormat 클래스 : 숫자 데이터를 원하는 형식으로 표현
			// 패턴 종류
				// 0 : 자리수 [ 빈자리면 0으로 채움 ]
				// # : 자리수 [ 빈자리면 채우지x ]
		double num = 1234567.89;
		
		DecimalFormat df = new DecimalFormat("0");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("0.0");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("0000000000.00000");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("#");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("#.#");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("##########.#####");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("#.0"); // 무조건 소수점 한자리 표시
		System.out.println(df.format(num));
		
		df = new DecimalFormat("+#.0");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("-#.0");
		System.out.println(df.format(num));
		
		// *************** 천단위 구분 쉼표 ******************
		df = new DecimalFormat("#,##0원");
		System.out.println(df.format(0));
		
		df = new DecimalFormat("#,###원");
		System.out.println(df.format(0));
		
		df = new DecimalFormat("0,000원");
		System.out.println(df.format(0));
		
		df = new DecimalFormat("0.0E0"); // E : 지수문자
		System.out.println(df.format(num));
		
		df = new DecimalFormat("+#,### ; -#,###"); // 양수 ; 음수
		System.out.println(df.format(num));
		
		// 컴퓨터는 백분율 x [ 계산시 1: 100% /  0.5 : 50% / 0.05 : 5% ]
		df = new DecimalFormat("#,###%");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("\u00A4 #,###");
		System.out.println(df.format(num));
		
		// p.544 DecimalFromat 클래스 : 숫자 형식 변환
		// p.878 SimpleDateFormat 클래스 : 날짜 형식 변환
		// p. MessageFromat 클래스 : 문자 형식 변환
		
		
		String id = "java";
		String name ="신용권";
		String tel = "010-123-5678";
		
		String text = "회원 ID : {0} \n회원 이름 : {1} \n회원 전화 : {2}";
		String result1 = MessageFormat.format(text, id, name, tel);
											// 패턴, {0}, {1}, {2}
		System.out.println(result1);
		
		String sql = "insert info member values( {0}, {1}, {2})";
										// 인덱스 : 0, 1 ,2
		Object[] 배열 = {id, name, tel};
		String result2 = MessageFormat.format(sql, 배열);
		System.out.println(result2);
		
		// JAVA 7 버전 이전 Date 이후에는 여러가지 날짜 API 추가중
		LocalDate currDate = LocalDate.now(); // new[x] static 메소드 now()
		System.out.println("현재 날짜 : "+currDate);
		
		LocalTime currTime = LocalTime.now();
		System.out.println("현재 시간 : "+currTime);
		
		// Date 현재날짜/시간 [ 조작이 안되거나 비교기능 불충분 ]
		// vs
		// LocalDate : 현재 날짜 			LocalTime : 현재 시간
		
		LocalDateTime currdatetime = LocalDateTime.now();
		System.out.println("현재 날짜/시간 : "+currdatetime);
		
		// 시간 계산
		Instant instant1 = Instant.now();
		Thread.sleep(1000); // 1000밀리초 : 1초 대기 [ 코드의 흐름이 1초간 멈춤 ]
		Instant instant2 = Instant.now();
		if(instant1.isBefore(instant2)) {
			System.out.println("instant1이 빠릅니다.");
		} else if(instant1.isAfter(instant2)) {
			System.out.println("instant1이 늦습닌다.");
		} else {
			System.out.println("동일한 시간입니다.");
		}
		System.out.println("차이(nanos): "+instant1.until(instant2, ChronoUnit.NANOS));
			// 밀리초 = 1/1,000 초			마이크로초 = 1/1,000,000 초		나노초 = 1/1,000,000,000 초		
		
		
		
		
		
		
	} // m e
	
	

} // c e
