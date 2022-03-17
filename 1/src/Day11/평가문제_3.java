package Day11;

import java.util.Scanner;

public class 평가문제_3 { // c s

	public static void main(String[] args) { // m s
		Scanner scanner = new Scanner(System.in);
		int[][] student = new int[100][6];
		String[] names = new String[100];
		double[] avg = new double[100];
		
		while(true) {
			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("\t\t성\t적\t표");
				System.out.println("------------------------------------------------------------");
				System.out.println(" 번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차");
				
				for (int i=0; i < student.length ; i++ ){
					for (int j =i+1; j <student.length ; j++ ){
						if (avg[j] > avg[i]){
							//이름, 국어, 영어, 수학, 총점, 평균 다 바꿔야함
							String temp = names[i];
							names[i] = names[j];
							names[j] = temp;

							int temp2 = student[i][1];
							student[i][1] = student[j][1];
							student[j][1] = temp2;

							temp2 = student[i][2];
							student[i][2] = student[j][2];
							student[j][2] = temp2;

							temp2 = student[i][3];
							student[i][3] = student[j][3];
							student[j][3] = temp2;

							temp2 = student[i][4];
							student[i][4] = student[j][4];
							student[j][4] = temp2;

							double temp3 = avg[i];
							avg[i] = avg[j];
							avg[j] = temp3;
							
							temp2 = student[i][0];
							student[i][0] = student[j][0];
							student[j][0] = temp2;

							temp2 = student[i][5];
							student[i][5] = student[j][5];
							student[j][5] = temp2;
						}
					}
				}

				for(int i=0; i<student.length; i++) {
					if(student[i][0]!=0) {
						System.out.printf(" %d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d \n",
								student[i][0],names[i],student[i][1],student[i][2],student[i][3],student[i][4],avg[i],student[i][5]+1 );
					}
					
				
				}
				System.out.println("------------------------------------------------------------");
				System.out.println();
				System.out.println("메뉴 : 1. 학생점수 등록 2. 학생점수 삭제");
				int ch = scanner.nextInt();
				if(ch==1) { // 학생점수 등록
					
					System.out.println("번호 : "); int num = scanner.nextInt();
					System.out.println("이름 : "); String name = scanner.next();
					System.out.println("국어 : "); int kor = scanner.nextInt();
					System.out.println("영어 : "); int eng = scanner.nextInt();
					System.out.println("수학 : "); int math = scanner.nextInt();
					
					for(int i=0; i<student.length; i++) {
						if(student[i][0]==0) {
							student[i][0] = num;
							student[i][1] = kor;
							student[i][2] = eng;
							student[i][3] = math;
							student[i][4] = kor+eng+math;
							avg[i] = (double)(kor+eng+math)/3;
							names[i] = name;
							System.out.println("알림)) 점수 등록이 완료되었습니다.");
							break;
						} 
					} // for end
					for(int i=0; i<student.length; i++) {
						student[i][5]=0;
					}
					for(int i=0; i<student.length; i++) {
						for(int j=0; j<student.length; j++) {
							if(student[i][4]<student[j][4]) {
								student[i][5]=student[i][5]+1;
							}
						}
					}
				} // 점수등록 종료
				else if(ch==2) {
					System.out.println("삭제할 학생 번호 입력 : "); int num = scanner.nextInt();
					boolean delete = false;
					for(int i=0; i<student.length; i++) {
						if(student[i][0]!=0 && student[i][0]==num) {
							student[i][0]=0;
							student[i][1]=0;
							student[i][2]=0;
							student[i][3]=0;
							student[i][4]=0;
							names[i]=null;
							avg[i]=0.0;
							for(int j=i; j<student.length; j++) {
								if(j==student.length-1) {
									student[j][0]=0;
									student[j][1]=0;
									student[j][2]=0;
									student[j][3]=0;
									student[j][4]=0;
									names[j]=null;
									avg[j]=0.0;
									break;
								}
								else {
									student[j]=student[j+1];
									names[j]=names[j+1];
									avg[j]=avg[j+1];
								}
							} // for2 end
							System.out.println("알림)) 삭제가 완료되었습니다.");
							delete=true;
						} // if end
						
					} // for end
					if(delete==false) System.out.println("알림)) 일치하는 번호가 없습니다.");
					
				}
				else System.out.println("알림)) 알 수 없는 번호입니다.");
			}catch(Exception e) {
				System.out.println("알림)) 잘못된 입력입니다.");
				scanner = new Scanner(System.in);
			}
		} // while end
	} // m e
	
	
} // c e
