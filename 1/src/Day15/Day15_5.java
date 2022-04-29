package Day15;

public class Day15_5 {

	public static void main(String[] args) {
		
		// 拌魂扁 按眉 积己
		Calculator calculator = new Calculator();
		
		// User1 按眉 积己
		User1 user1 = new User1();
		
		user1.setCalculator(calculator);
		user1.start();
		
		// User2 按眉 积己
		User2 user2 = new User2();
		user2.setCalculator(calculator);
		user2.start();
		
		
		
	
		
		
		
	}
	
	
	
	
}
