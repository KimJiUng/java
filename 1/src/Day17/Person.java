package Day17;

public class Person<T> {

	
	// 필드
	private String name;
	private int age;
	
	// 생성자
	public Person() {}

	
	public Person(String name) {
		this.name = name;
	}


	// 메소드 [get, set]
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	
	
	
	
	
}
