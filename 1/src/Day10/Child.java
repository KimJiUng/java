package Day10;

public class Child extends Parent {
	private String name;
	
	public Child() {
		this("홍길동");
		System.out.println("Child() call");
	}
	
	public Child(String name) {
		this.name=name;
		System.out.println("자식 [1개인수] 생성자 실행");
	}
	
}
