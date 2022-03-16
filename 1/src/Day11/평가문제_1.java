package Day11;

import java.util.Scanner;

public class 평가문제_1 { // c s

	public static void main(String[] args) { // m s
		
		Scanner scanner = new Scanner(System.in);
		int[][] 학생점수 = new int[100][5];
		String[] 이름 = new String[100];
		int[] 석차 = new int[100];
		double[] 평균 = new double[100];
		
		while(true) {
			try {
				System.out.println("-----------------------------------------------------------");
				System.out.println("\t\t성\t적\t표");
				System.out.println("-----------------------------------------------------------");
				System.out.println(" 번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차");
				System.out.println("-----------------------------------------------------------");
				
				for(int i=0; i<학생점수.length; i++) {
					if(학생점수[i][0]!=0) {
						
						
						
						System.out.printf(" %d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d \n",
								학생점수[석차[i]][0], 이름[석차[i]], 학생점수[석차[i]][1], 학생점수[석차[i]][2], 학생점수[석차[i]][3], 학생점수[석차[i]][4], 평균[석차[i]], i+1) ;
					}
				}
				System.out.println("메뉴 : 1. 학생점수 등록 2. 학생점수 삭제");
				int ch = scanner.nextInt();
				if(ch==1) { // 학생점수 등록
					
					System.out.println("번호 : "); int num = scanner.nextInt();
					System.out.println("이름 : "); String name = scanner.next();
					System.out.println("국어 : "); int korean = scanner.nextInt();
					System.out.println("영어 : "); int english = scanner.nextInt();
					System.out.println("수학 : "); int math = scanner.nextInt();
					
					for(int i=0; i<학생점수.length; i++) {
						if(학생점수[i][0]==0) {
							학생점수[i][0] = num;
							이름[i] = name;
							학생점수[i][1] = korean;
							학생점수[i][2] = english;
							학생점수[i][3] = math;
							학생점수[i][4] = 학생점수[i][1]+학생점수[i][2]+학생점수[i][3];
							
							평균[i] = (double)학생점수[i][4]/3;
							break;
						}
					}
					for(int i=0; i<석차.length; i++) {
						석차[i]=0;
					}
					for(int i=0; i<석차.length; i++) {
						for(int j=0; j<석차.length; j++) {
							if(학생점수[i][4]<학생점수[j][4]) {
								석차[i]=석차[i]+1;
							}
						}
					}
					
				} // if end
				else if(ch==2) { // 학생점수 삭제
					System.out.println("삭제할 학생 번호 입력 : "); int num = scanner.nextInt();
					
					for(int i=0; i<학생점수.length; i++) {
						if(학생점수[i][0]!=0 && 학생점수[i][0]==num) {
							학생점수[i][0]=0;
							학생점수[i][1]=0;
							학생점수[i][2]=0;
							학생점수[i][3]=0;
							석차[i]=0;
							이름[i]=null;
							평균[i]=0.0;
							for(int j=i; j<학생점수.length; j++) {
								if(j==학생점수.length-1) {
									학생점수[j][0]=0;
									학생점수[j][1]=0;
									학생점수[j][2]=0;
									학생점수[j][3]=0;
									석차[j]=0;
									이름[j]=null;
									평균[j]=0.0;
									break;
								}
								else {
									학생점수[j]=학생점수[j+1];
									석차[j]=석차[j+1];
									이름[j]=이름[j+1];
									평균[j]=평균[j+1];
								}
							} // for2 end
						} // if end
					} // for end
					
					
					
				} // else if end
				else System.out.println("알림)) 알 수 없는 번호입니다.");
			} catch(Exception e) {
				System.out.println("알림)) 잘못된 입력입니다.");
				scanner = new Scanner(System.in);
			}
			
			
			
			
		} // while end
		
		
		
		
		
		
		
		
	} // m e
	
	
	
} // c e
