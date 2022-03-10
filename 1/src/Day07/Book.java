package Day07;

public class Book { // c s

	// 1. �ʵ�
	String ISBN; // ������ȣ
	String bookname; // ������
	String writer; // �۰�
	boolean borrow; // �����뿩����
	String memberid; //�뿩��id
	
	// 2. ������
	public Book() {}
	
	public Book(String ISBN, String bookname, String writer, boolean borrow, String memberid) {
		this.ISBN = ISBN;
		this.bookname = bookname;
		this.writer = writer;
		this.borrow = borrow;
		this.memberid = memberid;
	}

	// 3. �޼ҵ�
		
		// 1. �����˻�
	void �����˻�() {
		System.out.println("----------------�����˻� ������------------------");
	}
		// 2. �������
	void �������() {
		System.out.println("----------------������� ������------------------");
		System.out.println("ISBN\t������\t�۰�\t�뿩���ɿ���");
		for(Book temp : Day07_5_BookApplication.books) {
			if(temp!=null) {
				if(temp.borrow) { // �ش絵���� �����뿩���ΰ� true �̸�
					System.out.println(temp.ISBN+"\t"+temp.bookname+"\t"+temp.writer+"\t"+"�뿩����");
				}
				else { // �ش絵���� �����뿩���ΰ� false �̸�
					System.out.println(temp.ISBN+"\t"+temp.bookname+"\t"+temp.writer+"\t"+"�뿩��");	
				}
			}
			
		} // for end
			
	}
		// 3. �����뿩
	void �����뿩(String loginid) {
		System.out.println("----------------�����뿩 ������------------------");
		System.out.println("�뿩�� ������ ISBN �Է� : "); String ISBN = Day07_5_BookApplication.scanner.next();
		
		for(Book temp : Day07_5_BookApplication.books) {
			if(temp!=null) {
				if(temp.ISBN.equals(ISBN)) {
					if(temp.borrow) {
						System.out.println("�˸�)) �뿩�� �Ϸ�Ǿ����ϴ�.");
						temp.borrow = false; temp.memberid = loginid;
						return;
					}
					else System.out.println("�˸�)) ���� �뿩���� �����Դϴ�.[�뿩�Ұ���]");
					return;
				}
				
			}
				
		} // for end
		System.out.println("�˸�)) ������ ���� ISBN�� �����ϴ�.");		
	}
		// 4. �����ݳ�
	void �����ݳ�(String loginid) {
		System.out.println("----------------�����ݳ� ������------------------");
		�����뿩���(loginid);
		System.out.println("�ݳ��� ���� ISBN �Է� : "); String ISBN = Day07_5_BookApplication.scanner.next();
		for(Book temp : Day07_5_BookApplication.books) {
			if(temp!=null && temp.ISBN.equals(ISBN)) { // �Է��� isbn�� ������
				if(temp.memberid.equals(loginid)) { // �뿩�� id�� ���� �α��ε� id�� �����ϸ�
					if(temp.borrow==false) {
						System.out.println("�˸�)) �ݳ��� �Ϸ�Ǿ����ϴ�.");
						temp.borrow=true; temp.memberid=null; // �뿩�� -> �뿩�������� ���� / �뿩�� ����� id�� �������� ����[null]
						return;	
					}
					else System.out.println("�˸�)) �뿩���� ������ �ƴմϴ�.");
					return;
				}
				else System.out.println("�˸�)) ȸ������ �뿩�� ������ �ƴմϴ�.");
				return;
			}
		}
		System.out.println("�˸�)) ������ ���� ISBN�� �����ϴ�.");	
	}
	 	// * ���� �α��� �� ȸ���� �뿩���� ���� ���
	void �����뿩���(String loginid) {
		System.out.println("----------------�����뿩��� ������------------------");
		System.out.println("ISBN\t������\t�۰�\t�뿩���ɿ���");
		for(Book temp : Day07_5_BookApplication.books) {
			if(temp!=null && temp.memberid.equals(loginid)) {
				// * ������ �����ϸ鼭 �뿩 id �� ���� �α��ε� id�� ������ 
					System.out.println(temp.ISBN+"\t"+temp.bookname+"\t"+temp.writer+"\t"+"�뿩��");	
			}
			
		} // for end
		System.out.println("�˸�)) ������ ���� ISBN�� �����ϴ�.");
	}
		// 5. �������
	void �������() {
		System.out.println("----------------������� ������------------------");
		// 1. �Է¹ޱ�
		System.out.println("ISBN : "); String ISBN = Day07_5_BookApplication.scanner.next();
		System.out.println("������ : "); String bookname = Day07_5_BookApplication.scanner.next();
		System.out.println("�۰� : "); String writer = Day07_5_BookApplication.scanner.next();
		
		// * �ߺ�üũ
		for(Book temp : Day07_5_BookApplication.books) {
			if(temp!=null && temp.ISBN.equals(ISBN)) {
				System.out.println("�˸�)) ���� ������� ISBN �Դϴ�.[��Ͻ���]");
				return; // ������� �޼ҵ� ���� (��Ͻ���)
			}
		}
		
		// 2. ��üȭ [ �����뿩���� = true, �뿩ȸ��id = null ]
		Book book = new Book(ISBN, bookname, writer, true, null);
		
		// 3. �迭 ����[�ֱ�]
		int index = 0;
		for(Book temp : Day07_5_BookApplication.books) {
			if(temp==null) {
				System.out.println("�˸�)) ��������� �Ϸ�Ǿ����ϴ�.");
				Day07_5_BookApplication.books[index]=book;
				return; // ��� ������ �޼ҵ� ����
			}
			index++;
		}
	}
		// 6. ��������
	void ��������() {
		System.out.println("----------------�������� ������------------------");
	}
	
} // c e
