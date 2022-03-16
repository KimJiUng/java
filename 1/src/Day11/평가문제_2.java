package Day11;

import java.util.Scanner;

public class 평가문제_2 { // c s

	public static void main(String[] args) { // m s
		
		Scanner scanner = new Scanner(System.in);
		Student[] students = new Student[100];
		Student[] students2 = new Student[100];
		
		while(true) {
			try {
				System.out.println("-------------------------------------------");
				System.out.println("\t\t성\t정\t표");
				System.out.println("-------------------------------------------");
				System.out.println(" 번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차");
				int a=0;
				for(Student temp : students) {
					if(temp!=null) {
						double avg = (double)temp.getSum()/3;
						System.out.printf(" %d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d \n", temp.getNum(),temp.getName(),temp.getKor(),temp.getEng(),temp.getMath(),temp.getSum(),avg,a+1 );
					}
					a++;
				}
				
				System.out.println("-------------------------------------------");
				System.out.println();
				System.out.println("메뉴 : 1. 학생점수 등록 2. 학생점수 삭제");
				int ch = scanner.nextInt();
				
				if(ch==1) { // 학생점수 등록
					
					System.out.println("번호 : "); int num = scanner.nextInt();
					System.out.println("이름 : "); String name = scanner.next();
					System.out.println("국어 : "); int kor = scanner.nextInt();
					System.out.println("영어 : "); int eng = scanner.nextInt();
					System.out.println("수학 : "); int math = scanner.nextInt();
					int i=0;
					for(Student temp : students) {
						if(temp==null) {
							int sum = kor+eng+math;
							Student student = new Student(name, kor, eng, math,num,sum);
							students[i] = student;
							
							break;
						}
						i++;
					}
					
				} // if end
				else if(ch==2) {
					System.out.println("삭제할 학생 번호 입력 : ");
					int num = scanner.nextInt();
					int i=0;
					for(Student temp : students) {
						if(temp!=null && temp.getNum()==num) {
							students[num]=null;
							for(int j=i; j<students.length; j++) {
								if(j==students.length-1) {
									students[students.length-1]=null;
								}
								else {
									students[j]=students[j+1];
								}
							}
						}
						i++;
						
					}
					
					
				} // else if end
				else System.out.println("알림)) 알 수 없는 번호입니다.");
			}catch(Exception e) {
				System.out.println("알림)) 잘못된 정보입니다.");
				scanner = new Scanner(System.in);
			}
		} // while end
		
		
		
		
		
		
	} // m e
	
	
	
} // c e
