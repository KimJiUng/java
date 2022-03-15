package Day04;

import java.util.Random;
import java.util.Scanner;

public class Day04_6 { // c s

	public static void main(String[] args) { // m s
		
		// ��� ����[ƽ���� ����]
		/*
		 * [0] [1] [2]
		 * [3] [4] [5]
		 * [6] [7] [8]
		 * 
		 */
		// 1. 9ĭ ����
		//		1. String �迭 = new String[9]
		// 2. ����ڿ��� 0~8 �ε�����ȣ �Է¹ޱ�
		//		1. �ش� �ε����� o ǥ��
		//		2. �̹� �� �ڸ��� �� �Է�
		// 3. ��ǻ�ʹ� 0~8 ���� ���� �߻�
		//		1. �ش� �ε����� x ǥ��
		//		2. �̹� �� �ڸ��� �� ���� ����
		// 4. �¸��Ǵ�
		//		1. ���� �ε������� ����� ��� ����
		//			012 345 678
		//		2. ���� �ε������� ����� ��� ����
		//			036 147 258
		//		3. �밢�� �ε������� ����� ��� ����
		//			048 246
		
		// �غ�
		
		Scanner scanner = new Scanner(System.in); // 1. �Է°�ü

		String �¸��� = ""; // 3�� �Ǿ����� �ش� ���� ���� ����
		String[] ������ = {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}; 
		// String ��ü 9���� ������ �� �ִ� �迭 ����
		
		// ���ӽ���
		while(true) { // ���ѷ��� �������� : 1. 9ĭ ��� ���� ���� ���
						//				2. �¸��ڰ� ������ ���
			// ������ ��� [ �迭�� ��� �ε��� ���]
			for(int i=0; i<������.length; i++) {
				System.out.print(������[i]);
				// ���ã�� : ��%��==0 
				if(i%3==2) System.out.println();
				
			}
			/////////////////////////////////////////////////////////////////
			// 1. �÷��̾� ��ġ(�ε���) ����
			while(true) {
				System.out.print("��ġ ���� : "); int ��ġ = scanner.nextInt();
				if(������[��ġ].equals("[ ]")) {
					// ������ ��ġ�� �����̸� O �� �α�
					������[��ġ] = "[O]";
					break;
				}
				else {
					System.out.println("�˸�)) �ش� ��ġ�� �̹� ���� ����.[�� ����]");
				}
				
			} // while2 end [������ ������ġ�� �������� ��쿡 break;]
			///////////////////////////////////////////////////////////////////
			// 2. ��ǻ�� ��ġ ����
			while(true) {
				Random random = new Random(); // ���� ��ü ����
				int ��ġ = random.nextInt(9); // 0~8 ������ ���� int������ ��������
				if(������[��ġ].equals("[ ]")) { // �ش� ������ġ�� �����̸� x �ƴϸ� �ٽ� ���ѷ���
					// ������ ��ġ�� �����̸� X �� �α�
					������[��ġ] = "[X]";
					break; // �� �ξ����� �ݺ��� Ż��
				}
			} // while3 end
			
			
			///////////////////////////////////////////////////////////////
			// 3. �¸� �Ǵ�
			// 012 345 678 036 147 258 048 246
			// 1. ���η� �̱�� ��
//			if(������[0].equals(������[1]) && ������[1].equals(������[2])) {}	
//			if(������[3].equals(������[4]) && ������[4].equals(������[5])) {}
//			if(������[6].equals(������[7]) && ������[7].equals(������[8])) {}
//			
			for(int i=0; i<=6; i+=3) {
				// * i�� 0���� 6���� 3�� ���� -> 0 3 6 -> 3ȸ
				if(������[i].equals(������[i+1]) && ������[i+1].equals(������[i+2])) {
					�¸���=������[i]; // ������ ���� �¸��� ������ ����
				}
			}
			// 2. ���η� �̱�� ��
			for(int i=0; i<=2; i++) {
				if(������[i].equals(������[i+3]) && ������[i+3].equals(������[i+6])) {
					�¸���=������[i];
				}
			}
			// 3. �밢������ �̱�� ��
			if(������[0].equals(������[4]) && ������[4].equals(������[8])) {
				�¸���=������[4];
			}	
			if(������[2].equals(������[4]) && ������[4].equals(������[6])) {
				�¸���=������[4];
			}
			
			/////////////////////////////////////////////////////////////
			//4. ��������
			if(�¸���.equals("[O]")) {
				System.out.println("�˸�)) �÷��̾� �¸�");
				break;
			}
			if(�¸���.equals("[X]")) {
				System.out.println("�˸�)) ��ǻ�� �¸�");
				break;
			}

		} // while1 end  [��������]
		
		for(int i=0; i<������.length; i++) {
			System.out.print(������[i]);
			// ���ã�� : ��%��==0 
			if(i%3==2) System.out.println();
			
		}
		
		
		
		
	} // m e
	
} // c e