package Day08;

// ���� 
	// 1. ��Ÿ �Ա� -> ���

	// 3. ���¹�ȣ �Է� ����� return;
	// 4. �� ���� ���� �Է�

	// 6. ���� ��� ��ü ��µ�
	// 7. ��ü�ý��� ����




//����� ��ũ ���α׷�
			// �䱸����
			// ȸ�� �ֿ��� : 1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã��
			// ���� �ֿ��� : 1.���»��� 2.�Ա� 3.��� 4.��ü 5.���� 6.���¸��
			// ���� : ����, ����, ȸ��
			
			
			// 1. ȸ��
		
				// �ʵ�
					// �̸�, ���̵�, ��й�ȣ, ��ȭ��ȣ, �ּ�
				// �޼ҵ�
					// 1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã�� 5.ȸ��Ż��
			
			// 2. ����
			
				// �ʵ�
					// ���¹�ȣ, �̸�, ����ݾ�, �����ȯ��, ���º�й�ȣ, ����, �����ܾ�
				// �޼ҵ�
					// 1.��ü 2.��� 3.���� 4.���º�й�ȣã�� 5.�Ա� 6.���»��� 7.���¸�� 8.�����ǰ��� 9.�����ǰ���� 10.�����ܾ�Ȯ��
					// 11.�����ȯ 
			
			// 3. ����
				
				// �ʵ�
					 // �����̸�, �ݾ�, ����, ������[id], ��ȯ����
				// �޼ҵ�
					// 
			
	///////////////////////////////////////////////////////////////////////////////////////////////////////////


public class Member {
	
	//�ʵ�
	String name;
	String id;
	String pw;
	String phone;
	String address;
	
	//������
	public Member() { //�������
		
	}

	public Member(String name, String id, String pw, String phone, String address) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phone = phone;
		this.address = address;
	}
	
	
	
	//�޼ҵ�
	
	boolean registration() {//ȸ������
		System.out.println("ȸ������)");
		System.out.print("����� ���̵� �Է�	 : ");String id = Day08_5.scanner.next();
	
		for(Member temp : Day08_5.members) {
			if(temp != null && temp.id.equals(id)) {
				System.out.println("�˸�)) ���� ������� ���̵��Դϴ�.");
				return false;
			}
		}
	
		System.out.print("����� ��ι�ȣ �Է� : \n");String pw = Day08_5.scanner.next();
		System.out.print("ȸ���̸� �Է� 	 : \n");String name = Day08_5.scanner.next();
		System.out.print("�̵���Ź�ȣ �Է�   : \n");String phone = Day08_5.scanner.next();
		System.out.print("�ּ��Է�(EX:�����) : \n");String address = Day08_5.scanner.next();
		
		Member member = new Member(name, id, pw, phone, address);
		
		
		int i = 0;
		for(Member temp : Day08_5.members) {
			if(temp == null) {
				Day08_5.members[i] = member;
				return true;
			}
			i++;
		}
		
		return false;
	}
	
	String login() {//�α���
		System.out.println("�α���)");
		System.out.print("ID : \n");String id = Day08_5.scanner.next();
		System.out.print("PW : \n");String pw = Day08_5.scanner.next();
		boolean idcheck = false;
		
		for(Member temp : Day08_5.members) {
			if( temp != null && temp.id.equals(id) && temp.pw.equals(pw)) {
				idcheck = true;
				return temp.id;
				
			}
			else if(temp != null && id.equals("admin") && temp.pw.equals(pw)) {
				idcheck = true;
				return "admin";
			}
		}
		
		
		if(idcheck == false)System.out.println("�˸�)) �������� �ʴ� ȸ���Դϴ�.");
		return null;
	}
	
	void findid() {//���̵� ã��
		System.out.println("���̵� ã��)");
		System.out.print("������� �̸� : \n");String name = Day08_5.scanner.next();
		System.out.print("��ȭ��ȣ �Է� : \n");String phone = Day08_5.scanner.next();
		boolean idcheck = false;
		
		
		for(Member temp : Day08_5.members) {
			if(temp != null && temp.name.equals(name) && temp.phone.equals(phone)) {
				System.out.println("ȸ������ ���̵�� " + temp.id + " �Դϴ�.");
				idcheck = true;
				return;
			}
		}
		
		
	
		
		if(idcheck == false)System.out.println("�˸�)) �������� �ʴ� ȸ���Դϴ�.");
	}
	
	void findpw() {//��й�ȣã��
		System.out.println("��й�ȣ ã��)");
		System.out.print("������� ���̵�: \n");String id = Day08_5.scanner.next();
		System.out.print("��ȭ��ȣ �Է� : \n");String phone = Day08_5.scanner.next();
		boolean idcheck = false;
		
		
		for(Member temp : Day08_5.members) {
			if(temp != null && temp.id.equals(id) && temp.phone.equals(phone)) {
				System.out.println("ȸ������ ��й�ȣ�� " + temp.pw + " �Դϴ�.");
				idcheck = true;
				return;
			}
		}
		
		if(idcheck == false)System.out.println("�˸�)) �������� �ʴ� ȸ���Դϴ�.");
	}
}