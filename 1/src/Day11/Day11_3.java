package Day11;

public class Day11_3 { // c s

	// p.422 예외 던지기
		// 목적 : 모든 메소드에서 try{}catch(){} 사용시 코드 복잡함 -> 한곳으로 예외 이동 
	
	public static void main(String[] args) { // m s
		try {findclass();} 
		catch(Exception e) {}
		try {withdraw(100110);}
		catch(Exception e) { System.out.println(e);}
		
		
	} // m e
	
	public static void findclass() throws Exception {
		
		// 1. try ~ catch
//		try { // 예외가 발생할 것 같은 코드(실행예외) or 일반예외[무조건]
//		Class clazz = Class.forName("java.lang.String2");
//		} catch(Exception e) { // 예외가 발생하면 실행되는 코드
//			// Exception : 예외클래스중 슈퍼클래스 이므로 모든 예외를 저장 가능
//			System.out.println(e);
//		}
		// 2. 예외 던지기 [메소드명() throws 예외클래스명]
		Class clazz = Class.forName("java.lang.String2");
	}
	
	// p. 444~445 : 예외 만들기
	
	public static void withdraw(int money) throws Exception {
		if(money>20000) {
			throw new Exception("잔고부족");
		}
	}
	
	
} // c e
