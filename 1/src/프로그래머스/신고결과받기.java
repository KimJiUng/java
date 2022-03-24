package 프로그래머스;

import java.util.Scanner;

public class 신고결과받기 {
	public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        return answer;
    }
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		String[] id_list = new String[1000];
		String[] report = new String[200000];
		
		while(true) {
			///////////////////////////ID 생성/로그인////////////////////////////
			System.out.println("1.회원가입 2.로그인"); int ch = scanner.nextInt();
			if(ch==1) {
				System.out.println("ID 입력 : ");
				String id = scanner.next();
				if(id.length()>0 && id.length()<11) {
					for(int i=0; i<id_list.length; i++) {
						if(i==id_list.length-1) {
							System.out.println("더이상 ID 생성이 불가능합니다.");
						}else {
							if(id_list[i]!=null && id_list[i].equals(id)) {
								System.out.println("이미 존재하는 ID입니다.");
								break;
							}
							else {
								id_list[i]=id;
								System.out.println("회원가입성공");
								break;
							}
						}
						
					}
				
				} // if end
				else System.out.println("ID의 길이는 1~10사이여야 합니다.");
			}
			else if(ch==2) {
				System.out.println("ID 입력 : "); String id = scanner.next();
				boolean idcheck = false;
				boolean rpidcheck = false;
				for(int i=0; i<id_list.length; i++) {
					if(id_list[i]!=null && id_list[i].equals(id)) {
						System.out.println("로그인 성공");
						idcheck = true;
						while(true) {
							System.out.println("신고할 아이디 입력 : "); String rpid = scanner.next();
							if(rpid.length()>0 && rpid.length()<11) {
								for(int j=0; j<id_list.length; j++) {
									if(id_list[j]!=null && id_list[j].equals(rpid)) {
										
										if(report[j]==null) {
											report[j]=id+" "+rpid;
											System.out.println(rpid+"신고가 완료되었습니다.");
											rpidcheck=true;
											break;
										}
									
									} // if end
									
									
								} // for end
							} // if end
							
					
							if(rpidcheck==false) {
								System.out.println("일치하는 ID가 없습니다.");
							}
							break;
						}
					}
				} // for end
				if(idcheck==false) {
					System.out.println("로그인 실패");
				}
				
			}
			
			/////////////////////////////////////////////////////////
			
		} // while end
		
		
		
		
		
		
		
		
	} // m e
	
} // c e
