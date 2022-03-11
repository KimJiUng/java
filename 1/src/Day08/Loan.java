package Day08;

import Day07.Book;
import Day07.Day07_5_BookApplication;

public class Loan {

	// 1. �ʵ�
	String lname;
	int loanmoney;
	String lid;
	boolean repay;
	final double interest=0.1;
	// 2. ������
	public Loan() {	}

	public Loan(String lname, int loanmoney, String lid, boolean repay) {
		this.lname = lname;
		this.loanmoney = loanmoney;
		this.lid = lid;
		this.repay = repay;
	}


	// 3. �޼ҵ�
	
/////////////////////////////////////////////����/////////////////////////////////////////////////////////







/////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////������///////////////////////////////////////////////////////




/////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////���� ��ǰ ���///////////////////////////////////////////////////////
	void newloan(String loginid) {
		System.out.println("----------------���� ��ǰ ��� ������------------------");
		// 1. �Է¹ޱ�
		System.out.println("���� ��ǰ�̸� �Է� : "); String lname = Day08_5.scanner.next();
		System.out.println("���� �ݾ� �Է� : "); int loan = Day08_5.scanner.nextInt();
		
		// * �ߺ�üũ
		for(Loan temp : Day08_5.loanlist) {
			if(temp!=null && temp.lname.equals(lname)) {
				System.out.println("�˸�)) ���� ������� ���� ��ǰ�Դϴ�.[��Ͻ���]");
				return; // �����ǰ��� �޼ҵ� ���� (��Ͻ���)
			}
		}
		
		// 2. ��üȭ [ �����뿩���� = true, �뿩ȸ��id = null ]
		Loan newloan = new Loan(lname, loan, loginid, false);
		
		// 3. �迭 ����[�ֱ�]
		int index = 0;
		for(Loan temp : Day08_5.loanlist) {
			if(temp==null) {
				System.out.println("�˸�)) ���� ��ǰ ����� �Ϸ�Ǿ����ϴ�.");
				Day08_5.loanlist[index]=newloan;
				return; // ��� ������ �޼ҵ� ����
			}
			index++;
		}
	} // ���� ��ǰ ��� ����
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////////////���� ��ǰ ����///////////////////////////////////////////////////////
	void deleteloan() {
		System.out.println("----------------���� ��ǰ ���� ������------------------");
		System.out.println("������ ���� ��ǰ�̸� �Է� : "); String lname = Day08_5.scanner.next();
		
		
		int a =0;
		for(Loan temp : Day08_5.loanlist) {
			if(temp!=null && temp.lname.equals(lname)) {
				System.out.println("�˻� ��� : ");
				System.out.println("��ǰ�̸�\t����ݾ�\t������");
				System.out.println(temp.lname+"\t"+temp.loanmoney+"\t"+(interest*100)+"%");
				System.out.println("1.���� 2.���"); int ch = Day08_5.scanner.nextInt();
				
				if(ch==1) {
					System.out.println("�˸�)) �ش� ��ǰ�� �����Ǿ����ϴ�.");
					Day08_5.loanlist[a]=null;
					int j = 0;	
					for(Loan temp2 : Day08_5.loanlist) {
						if(temp2==null) {
							for(int i=j; i<Day08_5.loanlist.length; i++) {
								if(i==Day08_5.loanlist.length-1) {
									Day08_5.loanlist[Day08_5.loanlist.length-1] = null;
								}
								else {
									Day08_5.loanlist[i]=Day08_5.loanlist[i+1];
								}
							}
						}
						j++;	
					} // for end
					return;
				} // if end
				else if(ch==2) {
					System.out.println("�˸�)) ������ �޴��� ���ư��ϴ�.");
					return;
				}
				else System.out.println("�˸�)) �� �� ���� �Է��Դϴ�.");
					return;
			}
			a++;
		} // for end
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
///////////////////////////////////////////���� ��ȯ/////////////////////////////////////////////////////////
	void repay(String loginid) {
		System.out.println("----------------���� ��ȯ ������------------------");
		llist(loginid);
		System.out.println("��ȯ�� ���� ��ǰ �̸� �Է� : "); String lname = Day08_5.scanner.next();
		
		int j=0;
		for(Loan temp : Day08_5.loanlist) {
			if(temp!=null && temp.lname.equals(lname)) { // �Է��� ��ǰ���� ������
				if(temp.lid.equals(loginid)) { // ������ id�� ���� �α��ε� id�� �����ϸ�
					if(temp.repay) {
						System.out.println("�˸�)) ���� �������� ��ǰ�� �ƴմϴ�.");
					}
					else {
						System.out.println("���¹�ȣ �Է� : "); int banknum = Day08_5.scanner.nextInt();
						System.out.println("���º�й�ȣ �Է� : "); String bankpw = Day08_5.scanner.next();
						int i=0;
						for(Bankbook temp2 : Day08_5.bankbooks) {
							if(temp2!=null && temp2.banknum==banknum && temp2.bankpw.equals(bankpw)) {
								if(temp2.nowmoney>=temp.loanmoney) {
									System.out.println("�˸�)) ���� ��ȯ�� �Ϸ�Ǿ����ϴ�.");
									temp2.nowmoney -= temp.loanmoney;
									Day08_5.loanlist[i].repay=true; Day08_5.loanlist[j]=null; // �뿩�� -> �뿩���� ���� / �뿩�� ����� id�� �������� ����[null]
									return;
								}
								else System.out.println("�˸�)) ���� ���� �ܾ��� �����մϴ�.[��ȯ����]");
								return;
							}
							i++;
						} // for end
						
					}
					
				}
				else System.out.println("�˸�)) ȸ������ ������ ��ǰ�� �ƴմϴ�.");
				return;
			}
			j++;
		} // for end
		System.out.println("�˸�)) ������ ���� ��ǰ���� �����ϴ�.");	
	}
	
	// * ���� �α��� �� ȸ���� ������� ��ǰ ���
	void llist(String loginid) {
		System.out.println("----------------���� ��ǰ ��� ������------------------");
		System.out.println("��ǰ�̸�\t����ݾ�\t������");
		for(Loan temp : Day08_5.loanlist) {
			if(temp!=null && temp.lid.equals(loginid)) {
				// * ������ �����ϸ鼭 ������(id)�� ���� �α��ε� id�� ������ 
					System.out.println(temp.lname+"\t"+temp.loanmoney+"\t"+(interest*100)+"%");	
			}
			
		} // for end

	}
//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
} // c e
