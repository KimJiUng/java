package Day10;

public class Child extends Parent {
	private String name;
	
	public Child() {
		this("ȫ�浿");
		System.out.println("Child() call");
	}
	
	public Child(String name) {
		this.name=name;
		System.out.println("�ڽ� [1���μ�] ������ ����");
	}
	
}