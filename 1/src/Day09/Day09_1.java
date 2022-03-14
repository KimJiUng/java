package Day09;

public class Day09_1 { // c s

	public static void main(String[] args) { // m s
		
		// p.277 확인문제
		
		// 13. 
			/*
			 *  String name;
			 *  String id;
			 *  String password;
			 *  int age;
			 *     
			 */
		// 14.
			/*
			 * 생성자 선언시 : 클래스 이름 동일
			 * Member(String name, String id){
			 * 	this.name = name;
			 * 	this.id = id;
			 * }
			 */
		
		// 15
			/*
			 * 매개변수 : 인수 : 메소드 호출시 메소드로 들어오는 데이터
			 * boolean login(String id, String password){
			 * 	if(id.equals("hong") && passwor.equals("12345"){
			 * 		// 아이디가 hong 이면서 패스워드가 12345 이면 true 반환
			 * 		return true;
			 * 	}
			 * 	return false;
			 * }
			 * 
			 * void logout(String id){
			 * 	System.out.println("로그아웃 되었습니다.");
			 * }
			 * 
			 */
		
		// 16.
			/*
			 * **************** 동일한 이름으로 메소드를 선언가능 [단, 서로 다른 인수(매개변수) 사용]
			 * void println(int x){ // 외부로부터 int형 변수를 인수로 받아 출력하는 메소드
			 * 	System.out.println(x);
			 * }
			 * void println(boolean x){ // 외부로부터 boolean형 변수를 인수로 받아 출력하는 메소드
			 * 	System.out.println(x);
			 * }
			 * void println(double x){ // 외부로부터 double형 변수를 인수로 받아 출력하는 메소드
			 * 	System.out.println(x);
			 * }
			 * void println(String x){ // 외부로부터 String형 변수를 인수로 받아 출력하는 메소드
			 * 	System.out.println(x);
			 * }
			 * 
			 */
		
		// 17. 
			/*	********* 객체를 생성하지 않고 메소드를 호출하는 방법
			 * static void println(int x){ // 외부로부터 int형 변수를 인수로 받아 출력하는 메소드
			 * 	System.out.println(x);
			 * }
			 * void println(boolean x){ // 외부로부터 boolean형 변수를 인수로 받아 출력하는 메소드
			 * 	System.out.println(x);
			 * }
			 * void println(double x){ // 외부로부터 double형 변수를 인수로 받아 출력하는 메소드
			 * 	System.out.println(x);
			 * }
			 * void println(String x){ // 외부로부터 String형 변수를 인수로 받아 출력하는 메소드
			 * 	System.out.println(x);
			 * }
			 * 
			 */
		
		// 19. 모바일 뱅크 프로그램 [2인과제] 대체
		
		
		
	} // m e
	
} // c e
