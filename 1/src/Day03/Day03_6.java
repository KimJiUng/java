package Day03;

import java.util.Scanner;

public class Day03_6 { // c s

	public static void main(String[] args) { // m s
		
		Scanner scanner = new Scanner(System.in);
		
//		// 별문제1 : 입력받은 수 만큼 * 출력
//		System.out.println("문제1) 별개수 : "); int s1 = scanner.nextInt();
//		for( int i =1; i<=s1; i++) {
//			// i는 1부터 입력받은 수까지 1씩 증가
//			System.out.print("*");
//		}
//		
//		// 별문제2 : 입력받은 수 만큼 * 출력 [단 5개마다 줄바꿈 처리]
//		System.out.println("문제2) 별개수 : "); int s2 = scanner.nextInt();
//		for( int i =1; i<=s2; i++) {
//			System.out.print("*");
//			// 5개마다 줄바꿈 -> 5배수 마다 -> 배수찾기
//			if(i%5==0)System.out.println(); //줄바꿈처리
//		}
//		
//	//		별문제3 : 입력받은 줄 만큼 출력
//	//		
//	//		*				
//	//		**		
//	//		***		
//	//		****	
//	//		***** 	
//	//			
//		
//		// i = 줄[변수] s = 별[변수]
//		// i는 1부터 5까지 1씩 증가
//		// s는 1부터 현재 줄수까지 1씩 증가하면서 별 출력
//		
//		System.out.println("문제3) 줄수: "); int line3 = scanner.nextInt();
//		for(int i = 1; i<=line3; i++) {
//			// i는 1부터 입력받은 줄 수 까지 1씩 증가
//			
//			// 1. 별찍기
//			for(int s = 1; s<=i; s++) {
//				System.out.print("*");
//			}
//			// 2. 줄바꿈 처리
//			System.out.println();		
//		}
//			// 순서도
//				// 사용자가 3을 입력했을때
//				// i = 1 i<=3 [true] -> i++
//					// s = 1 s<=1 [true] -> * -> s++
//					// s = 2 s<=1 [false] -> 반복문 종료
//				// 줄바꿈
//				// i = 2 i<=3 [true]
//					// s = 1 s<=2 [true] -> * -> s++
//					// s = 2 s<=2 [true] -> * -> s++
//					// s = 3 s<=2 [false] -> 반복문 종료
//				// 줄바꿈
//				// i = 3 i<=3 [true]
//					// s = 1 s<=3 [true] -> * -> s++
//					// s = 2 s<=3 [true] -> ** -> s++
//					// s = 3 s<=3 [true] -> *** -> s++
//					// s = 4 s<=3 [false] -> 반복문 종료
//				// 줄바꿈
//				// i = 4 i<=3 [false] 반복문 종료
//					
//	//					
//	//	별문제4 : 입력받은 줄 만큼 출력
//	//				
//	//		*****	
//	//		****		
//	//		***				
//	//		**			
//	//		*				
//	//			
//		// i = 줄수 , 1부터 입력받은 수 까지 1씩 증가 줄바꿈
//		// s = 별갯수 , 1부터 입력받은수-현재줄수까지 1씩 증가 별 출력
//		
//		System.out.println("문제4) 줄수 : "); int line4 = scanner.nextInt();
//		for(int i = 1; i<=line4; i++) {
//			// i는 1부터 line4 까지 1씩 증가
//			for(int s = 1; s<=line4-i+1; s++) {
//				// s는 1부터 입력받은수-현재줄수+1까지 1씩 증가
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		
//	//		
//	//	별문제5 : 입력받은 줄 만큼 출력
//	//				
//	//	        *	
//	//	       **	
//	//	      ***	
//	//	     ****	
//	//		*****	
//	//
//		
//		System.out.println("문제5) 줄수 : "); int line5 = scanner.nextInt();
//		
//		for(int i = 1; i<=line5; i++) {
//			// 줄바꿈
//			for(int b = 1; b<=line5-i; b++) {
//				// 공백 , 입력받은수-현재줄수
//				System.out.print(" ");
//			}	for(int s = 1; s<=i; s++) {
//					// 별
//					System.out.print("*");
//				}
//			System.out.println();
//			
//		}
//		
//		
//		
//		
//		
//	//	별문제6 : 입력받은 줄 만큼 출력
//	//		*****	
//	//		 ****	
//	//		  ***	
//	//		   **	
//	//		    *	
//	//		    
//		System.out.println("문제6) 줄수 : "); int line6 = scanner.nextInt();
//		
//		for(int i = 1; i<=line6; i++) {
//			// 1. 공백
//			for(int b = 1; b<=i-1; b++) {
//				System.out.print(" ");
//			}
//			// 2. 별
//			for(int s = 1; s<=line6-i+1; s++) {
//				System.out.print("*");
//			}
//			// 3. 줄바꿈
//			System.out.println();
//		}	
//		
//	//	별문제7 : 입력받은 줄 만큼 출력
//	//	        *		
//	//	       ***		
//	//	      *****		
//	//	     *******	
//	//		*********	
//	//		
//		
//		/* i=1	s=1	b=4+4
//		 * i=2	s=3	b=3+3
//		 * i=3	s=5	b=2+2
//		 * i=4	s=7	b=1+1
//		 * i=5	s=9	b=0
//		 * i는 줄수 1씩 증가
//		 * s는 i*2-1
//		 * b는 입력받은값-i*2
//		 */
//		System.out.println("문제7) 줄수 : "); int line7 = scanner.nextInt();
//		
//		for(int i = 1; i<=line7; i++) {
//			// 1. 공백1
//			for(int b = 1; b<=line7-i; b++) {
//				System.out.print(" ");
//			}
//			// 2. 별
//			for(int s = 1; s<=i*2-1; s++) {
//				System.out.print("*");
//			}
//			// 3. 줄바꿈
//			System.out.println();
//		}
//		
//		
//	//	별문제8 : 입력받은 줄만큼 출력 
//	//		    1
//	//	       222
//	//	      33333
//	//	     4444444
//	//		555555555
//	//		
//		System.out.println("문제8) 줄수 : "); int line8 = scanner.nextInt();
//		
//		for(int i = 1; i<=line8; i++) {
//			// 1. 공백1
//			for(int b=1; b<=line8-i; b++) {
//				System.out.print(" ");
//			}
//			// 2. 숫자
//			for(int s = 1; s<=i*2-1; s++) {
//				System.out.print(i);
//			}
//			// 3. 줄바꿈
//			System.out.println();
//		}
//		
//	//	별문제9 : 입력받은 줄만큼 출력
//	//
//	//		*********		
//	//		 *******				
//	//		  *****				
//	//		   ***			
//	//		    *		
//	//		    
//		// i=12345 b=01234 s=97531
//		// s = line9*2-i
//		System.out.println("문제9) 줄수 : "); int line9 = scanner.nextInt();
//		
//		for(int i = 1; i<=line9; i++) {
//			// 1.공백
//			for(int b=1; b<=i-1; b++) {
//				System.out.print(" ");
//			}
//			// 2. 별
//			for(int s=1; s<=line9*2-i*2+1; s++) {
//				System.out.print("*");
//			}
//			// 3. 공백
//			for(int b=1; b<=i-1; b++) {
//				System.out.print(" ");
//			}
//			// 4. 줄바꿈
//			System.out.println();
//		}
//		
//			
	//	별문제10 : 입력받은 줄만큼 출력
	//	        *
	//	       ***
	//	      *****
	//		 *******
	//		*********
	//		 *******
	//		  *****
	//		   ***
	//		    *
		// i = 123456789
		// s = 135797531 / s
		// b = 432101234
		
		System.out.println("문제10) 줄수 : "); int line10 = scanner.nextInt();
		
		for(int i = 1; i<=line10; i++) {
			// 1. 공백1
			if(i<line10/2) {
				for(int b = 1; b<=(line10-i); b++) {
				System.out.print(" ");
				}
			// 2. 별1
				for(int s = 1; s<=(i*2-1); s++) {
				System.out.print("*");
				}
			}
			else {
				for( int b = 1; b<=i-1; b++) {
					System.out.print(" ");
				}
				for(int s = 1; s<=line10*2-i*2+1; s++) {
					System.out.print("*");
				}
			}
			// 5. 줄바꿈
			System.out.println();
		}
		
		
		
		
		
	//	별문제11 : 입력받은 줄만큼 출력 [ 입력받은 행/열 동일 ] 
	//		*     *		
	//		 *   *	
	//		  * *		
	//		   *		
	//	      * *		
	//	     *   *		
	//	    *     *		
	//										
	//	별문제12 : 입력받은 줄만큼 출력
	//		*        *
	//		**      **
	//		***    ***
	//		****  ****
	//		**********
	//		****  ****
	//		***    ***
	//		**      **
	//		*        *
	//
	//	별문제13 : 입력받은 줄만큼 출력
	//		                   *                        
	//	                      * *                       
	//	                     *****                      
	//	                    *     *                     
	//	                   * *   * *                    
	//	                  ***** *****                   
	//	                 *           *                  
	//	                * *         * *                 
	//	               *****       *****                
	//	              *     *     *     *               
	//	             * *   * *   * *   * *              
	//	            ***** ***** ***** *****             
	//	           *                       *            
	//	          * *                     * *           
	//	         *****                   *****          
	//	        *     *                 *     *         
	//	       * *   * *               * *   * *        
	//	      ***** *****             ***** *****       
	//	     *           *           *           *      
	//	    * *         * *         * *         * *     
	//	   *****       *****       *****       *****    
	//	  *     *     *     *     *     *     *     *   
	//	 * *   * *   * *   * *   * *   * *   * *   * *  
	//	***** ***** ***** ***** ***** ***** ***** *****	
	//		
		
		
		
		
	} // m e
	
} // c e
