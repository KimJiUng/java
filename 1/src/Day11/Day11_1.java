package Day11;

public class Day11_1 { // c s

	// p.386 확인문제
		// 1. 3 [인터페이스의 멤버 : 1.상수필드 2.추상메소드 3.디폴트메소드 4.정적메소드]
		// 2. 4 [인터페이스 변수 = 구현객체]
			// 구현객체 = 클래스가 implements한 객체
		
	private static void printSound(Soundable soundable) {
// 	접근제한자	정적		반환타입	메소드명(인수[변수,배열,객체,인터페이스])
		System.out.println(soundable.sound());
	}
	
	public static void dbWork(DataAccessObject dao) {
		dao.select();
		dao.delete();
		dao.insert();
		dao.update();
	}
	
	public static void main(String[] args) {
		// 3.
		printSound(new Cat());
		printSound(new Dog());
		
		// 4. 
			// Dao : DB 접근객체		Dto : 데이터 이동객체
		
		
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
		
		
		// 5. 익명객체 [인터페이스가 직접 구현]
			// 구현객체 : 인터페이스명 객체명 = new 클래스명();
			// 익명객체 : 인터페이스명 객체명 = new 인터페이스() { 구현 } ; // 1회용 간단하게 쓸 때
		Action action = new Action() {
			
			@Override
			public void work() {
				System.out.println("복사를 합니다.");
				
			}
		}; // 구현 끝
		action.work();
		
		
	} // m e
	
	
	
	
} // c e
