package Day09;

import java.util.Random;

public class 은행컨트롤러 { // c s
			// 입출력 기능 x
	// V[입출력]<----->C[코드]
	// 해당 클래스는 은행 관련 컨트롤러
	// M : 모델 [데이터]
	// V : 뷰 [입출력]
	// C : 모델[M]과 뷰[V] 연결 역할
	
	// 뷰에서 요청하는 서비스[기능] 제공
		// 1. 계좌생성 [C]
	public String 계좌생성(String 비밀번호, String 계좌주, int 은행번호) {
		
		// 1. 입력받은 값을 가져온다 [인수]
			// 계좌번호 자동생성
		String 계좌번호 = null; // while 밖에서 선언한 이유 : while 안에서 선언시 while 안에서만 사용가능하기 때문
		while(true) { // 무한루프 [종료조건 : 난수가 중복이 없을경우]
			Random random = new Random(); // 랜덤
			// 4자리 생성
			int 난수 = random.nextInt(10000); // 0~9999 사이의 난수
			계좌번호 = String.format("%04d", 난수);
							// 문자형식 변경
								// %d : 정수
								// %4d : 정수 4자리 [만일 자리수 없으면 공백처리]
								// %04d : 정수 4자리 [만일 자리수 없으면 0처리]
			// 중복체크
			boolean 계좌번호중복 = false;
			for(은행 temp2 : Day09_6_은행계좌프로그램.계좌리스트) {
				if(temp2!=null && temp2.get계좌번호().equals(계좌번호)) { // 기존 배열내 계좌번호와 동일하면
					계좌번호중복 = true;
					
				}
			}
			// 만일 중복이 없으면
			if(계좌번호중복 == false) break; // 반복문 나가기
		} // while end
		// 2. 객체화[다수의 변수를 하나의 객체로 만들기]
			은행 temp=null; // 빈 객체 선언
			if(은행번호 == 1) {temp = new 국민은행(계좌번호,비밀번호, 계좌주, 0,0);}
			else if(은행번호==2) {temp = new 신한은행(계좌번호,비밀번호, 계좌주, 0,0);}
			else if(은행번호==3) {temp = new 하나은행(계좌번호,비밀번호, 계좌주, 0,0);}
			
		// 3. 배열에 저장
		int i = 0; // 인덱스 번호
		for(은행 temp2 : Day09_6_은행계좌프로그램.계좌리스트) {
			if(temp2==null) {
				Day09_6_은행계좌프로그램.계좌리스트[i]=temp; // 공백 인덱스에 저장
				System.out.println("*** 계좌 등록 ***");
				return 계좌번호; // 계좌번호가 존재하면 성공했다는 의미
			}
			i++; // 인덱스 증가
		}
		return null; // null 이면 실패했다는 의미
		
	} // 계좌생성 종료
		// 2. 입금 [U]
	public boolean 입금(String 계좌번호, int 입금액) { 
		// 1. 동일한 계좌번호를 찾아서
		int i=0;
		for(은행 temp : Day09_6_은행계좌프로그램.계좌리스트) {
			if(temp!=null && temp.get계좌번호().equals(계좌번호)) {
				// 해당계좌가 공백이 아니고 입력한[인수] 값과 같으면
				// 2. 동일한 계좌번호가 있으면 입금 처리
				Day09_6_은행계좌프로그램.계좌리스트[i].set예금액(temp.get예금액()+입금액);
											// Setter = 기존금액 + 새로운 입금액
				return true;
			}
			i++;
		} // for end
		
		// 3. 동일한 계좌번호가 없으면 입금 실패
		return false; 
		
	}
		// 3. 출금 [U]
	public int 출금(String 계좌번호, String 비밀번호, int 출금액) {
		// 1. 동일한 계좌번호를 찾아서
		// 2. 해당 계좌번호의 비밀번호가 일치하는지 확인
		// 3. 일치하면 출금처리
		// 4. 아니면 출금실패
		// * 만일 예금액보다 출금액이 더 크면 잔액부족(출금실패)
		int i=0;
		for(은행 temp : Day09_6_은행계좌프로그램.계좌리스트) {
			if(temp!=null && temp.get계좌번호().equals(계좌번호) && temp.get비밀번호().equals(비밀번호)) {
				if(temp.get예금액()<출금액) {
					return 1; // 잔액 부족 의미 반환
				}
				else {
					Day09_6_은행계좌프로그램.계좌리스트[i].set예금액(temp.get예금액()-출금액);
					return 2; // 출금 성공했다는 의미 반환 
				}
			}
			i++;
		}
		return 3; // 동일한 정보가 아닐경우 실패했다는 의미 반환
		
	}
		// 4. 이체 [U] // 본인계좌, 비밀번호, 받는계좌, 이체금액
	public int 이체(String 계좌번호, String 비밀번호, String 계좌번호2, int 이체액) {
		int i=0;
		for(은행 temp : Day09_6_은행계좌프로그램.계좌리스트) {
			if(temp!=null && temp.get계좌번호().equals(계좌번호) && temp.get비밀번호().equals(비밀번호)) {
				int j=0;
				for(은행 temp2 : Day09_6_은행계좌프로그램.계좌리스트) {
					if(temp2!=null && temp2.get계좌번호().equals(계좌번호2)) {
						if(temp.get예금액()<이체액) {
							return 1; // 잔액 부족 의미 반환
						}
						else {
							Day09_6_은행계좌프로그램.계좌리스트[i].set예금액(temp.get예금액()-이체액);
							Day09_6_은행계좌프로그램.계좌리스트[j].set예금액(temp2.get예금액()+이체액);
							return 2; // 이체 성공했다는 의미 반환 
						}
					}
					j++;
				} // for end
				
			}
			i++;
		} // for end
		// 계좌정보가 틀렸을때
		return 3;
		
	}
		// 5. 내계좌목록 [R]
	public 은행[] 계좌목록(String 계좌주) {
	// 입력받은 계좌주의 계좌목록 만들어서 반환
		
		// 동일한 계좌주의 계좌를 찾아서 배열담아 넘기기
		은행[] 내계좌목록 = new 은행[100];
		for(은행 temp : Day09_6_은행계좌프로그램.계좌리스트) {
			if(temp!=null && temp.get계좌주().equals(계좌주)) {
				// 해당 계좌내 계좌주와 인수의 계좌주가 동일하면
				// 내계좌목록 배열내 빈공간을 찾아서 내계좌목록에 넣기
				int i=0;
				for(은행 temp2 : 내계좌목록) {
					if(temp2==null) {
						내계좌목록[i]=temp;
						break;
					}
					i++;
				}
			} // if end
		} // for end
		return 내계좌목록; 
	}
		// 6. 대출 [U]
	public boolean 대출(int 대출액, String 대출계좌, String 비밀번호) {
		int i=0;
		for(은행 temp : Day09_6_은행계좌프로그램.계좌리스트) {
			if(temp!=null && temp.get계좌번호().equals(대출계좌) && temp.get비밀번호().equals(비밀번호)) {
				Day09_6_은행계좌프로그램.계좌리스트[i].set예금액(temp.get예금액()+대출액);
				Day09_6_은행계좌프로그램.계좌리스트[i].set대출액(temp.get대출액()+대출액*1.1);
				
				return true; // 대출 성공
			}
			i++;
		}
		return false; // 대출 실패(개인정보 틀림)
	}
		// 7. 대출상환
	public int 대출상환(String 대출계좌, String 비밀번호, int 상환액) {
		
		int i=0;
		for(은행 temp : Day09_6_은행계좌프로그램.계좌리스트) {
			if(temp!=null && temp.get계좌번호().equals(대출계좌) && temp.get비밀번호().equals(비밀번호)) {
				
				if(상환액>temp.get대출액()) {
					return 1; // 상환하려는 금액이 대출한 금액보다 큰 경우
				}
				else {
					Day09_6_은행계좌프로그램.계좌리스트[i].set예금액(temp.get예금액()-상환액);
					Day09_6_은행계좌프로그램.계좌리스트[i].set대출액(temp.get대출액()-상환액);
					return 2; // 상환 완료
				}
				
			}
			i++;
		
		}
		return 3;
	}
	
} // c e
