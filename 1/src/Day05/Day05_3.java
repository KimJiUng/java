package Day05;

import java.util.Scanner;

public class Day05_3 { // c s

	public static void main(String[] args) { // m s
		
		// p.181
			// 7.
		int max = 0;
		int[] array = {1,5,3,8,2};
		
		for(int i=0; i<array.length; i++) {
			if(max<array[i]) max = array[i];
			// 만약에 max보다 i번째 인덱스의 값이 더 크면 max에 i번째 값 대입
		}
		System.out.println("max : "+max);
			
			// 8.
		int[][] array2 ={ 
						{95, 86},
						{83, 92, 96},
						{78, 83, 93, 87, 88}
						};
		int sum =0;
		double avg = 0.0;
		
		int count = 0;
		
		for(int i=0; i<array2.length; i++) {
			for(int j=0; j<array2[i].length; j++) {
				sum += array2[i][j]; // 누적합계
			}
			count += array2[i].length;
		}
		
		avg = (double)sum/count;
		System.out.println("count : "+count);
		System.out.println("sum : "+sum);
		System.out.println("avg : "+avg);
		
		
			// 9.
		boolean run = true; // while문 스위치 변수
		int studentNum = 0; 
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);
		
	
		
		while(run) { // 
			System.out.println("---------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("---------------------------------------------");
			System.out.println("선택>");
			
			int selectNo = scanner.nextInt();
			
			if(selectNo==1) { // 학생수 입력
				System.out.println("학생수>"); studentNum = scanner.nextInt();
				// 입력받은 학생수 만큼 배열길이 변경
				scores = new int[studentNum];
			}
			else if(selectNo==2) { // 학생 점수 입력
				for(int i=0; i<scores.length; i++) {
					System.out.printf("scores[%d] : \n",i); scores[i] = scanner.nextInt(); // 입력받아 i번째 인덱스에 저장
				}
			}
			else if(selectNo==3) { // 학생 점수 출력
				for(int i=0; i<scores.length; i++) {
					System.out.printf("scores[%d] : %d\n",i,scores[i]);
				}
			}
			else if(selectNo==4) {
				int max2 =0;
				int sum2 = 0;
				double avg2 =0.0;
				
				for(int i=0; i<scores.length; i++) {
					if(max2<scores[i]) max2=scores[i];
					sum2 += scores[i];
				}
				avg2 = sum2/scores.length;
				System.out.println("최고 점수 : "+max2);
				System.out.println("평균 점수 : "+avg2);
			}
			else if(selectNo==5) {
				run = false; // break; // 반복문 탈출
			}

		} // while end
		System.out.println("프로그램 종료");	
	} // m e
} // c e
 