package Day17;

import java.util.Arrays;

public class Day17_3 {

	public static void main(String[] args) {
		
		// 코스 클래스 제네릭에 사람클래스 넣기
		Course<Person> pc = new Course<>("일반인과정", 5);
		pc.add(new Person("일반인"));
		pc.add(new Worker("직장인")); // 사람클래스에게 상속 받았기 때문에 가능
		pc.add(new Student("학생")); // 사람클래스에게 상속 받았기 때문에 가능
		pc.add(new Highschool_student("고등학생")); // 학생클래스에게 상속 -> 사람클래스에게 상속 받았기 때문에 가능
		// * 제네릭에 들어가는 클래스는 자식클래스도 같이 들어갈 수 있다.
		Course<Worker> wc = new Course<>("직장인과정", 5);
		// wc.add(new Person("일반인")); // 부모클래스는 들어갈 수 없다.
		wc.add(new Worker("직장인")); // 본인은 가능
		// wc.add(new Student("학생")); // 부모 자식 관계가 아니여서 불가능
		Course<Student> sc = new Course<>("학생과정",5);
		// sc.add(new Person("일반인"));
		// sc.add(new Worker("직장인"));
		sc.add(new Student("학생"));
		sc.add(new Highschool_student("고등학생")); // 학생클래스에게 상속 받았기 때문에 가능
		Course<Highschool_student> hc = new Course("고등학생과정",5);
		// hc.add(new Person("일반인"));
		// hc.add(new Worker("직장인"));
		// hc.add(new Student("학생"));
		hc.add(new Highschool_student("고등학생"));
		
		// 메소드 호출
		registerCourse(pc);
		registerCourse(wc);
		registerCourse(sc);
		registerCourse(hc);
		System.out.println();
		registerCourseStudent(hc);
		registerCourseStudent(sc);
		System.out.println();
		registerCourseWorker(wc);
		registerCourseWorker(pc);
		
		
		
	} // m e
	
	
	// 와일드카드 : ? [모든클래스 대응]
		// 코스<?> : 모든 제네릭 가능
		// 코스<? extends 클래스명> : 해당 클래스로부터 상속 받은(자식) 제네릭 클래스 가능
		// 코스<? super 클래스명> : 해당 클래스로부터 상속 준(부모) 제네릭 클래스 가능
	
	// 1.
	public static void registerCourse(Course<?> course) {
						// 인수로부터 모든 코스의 제네릭 받음
						// Course<Person> : Person 제네릭 Course만 가능
						// Course<?> : 모든 제네릭 Course 가능
		System.out.println(course.getName()+" 수강생명단 : "+
						Arrays.toString(course.getStudents() ) );
						// Arrays : 배열관련 메소드 제공
							// Arrays.toString(배열명) : 해당 배열내 내용 모두 출력
		
	}
	
	// 2.
	public static void registerCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName()+" 수강생명단 : "+Arrays.toString(course.getStudents()));
	}
	
	// 3.
	public static void registerCourseWorker(Course<? super Worker> course) {
		System.out.println(course.getName() + " 수강생명단 :"+Arrays.toString(course.getStudents()));
	}
	
} // c e
