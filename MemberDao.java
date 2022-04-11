package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import controller.login.Login;
import dto.Member;



public class MemberDao { // DB ���ٰ�ü
	
	private Connection con; // DB ������ ���Ǵ� Ŭ���� : DB ���� Ŭ����
	private PreparedStatement ps; // ����� DB�� SQL ���� �Ҷ� ���Ǵ� �������̽� : DB�����������̽�
	private ResultSet rs; // ������� �����ϴ� �������̽�
	
	public static MemberDao memberDao = new MemberDao(); // DB ���� ��ü;
	public static ArrayList<String> pointlist = new ArrayList<>();
	public MemberDao() {
		try {
			// DB ����
				// 1. DB ����̹� ��������
			Class.forName("com.mysql.cj.jdbc.Driver");
				// 2. DB �ּ� ����
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC", "root", "1234");
			
			
			
		} catch(Exception e) {
			System.out.println("DB���� ���� : "+ e);
		}

	}
	
	// �޼ҵ�
		
		// *���̵� �ߺ�üũ �޼ҵ�(�μ� : ���̵� �μ��� �޾� DB�� �����ϴ��� üũ)
	public boolean idcheck(String id) {
		try {
			// 1. SQL �ۼ�
				// �˻� : select * from ���̺��� where ����(�ʵ��=��)
			String sql = "select * from member where mid=?";
			// 2. SQL ����
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			// 3. SQL ����
			rs = ps.executeQuery(); // select ���� -> �˻��� ����� ���� -> resultset o
				// resultset ó�� �⺻�� : null ----next()---> ��� ���ڵ�
			// 4. SQL ���
			if(rs.next()) { // ���࿡ ���� ������� �����ϸ� -> �ش� ���̵� ���� -> �ߺ�
				return true; // ���̵� �ߺ�
			}
		}catch(Exception e) {
			System.out.println("SQL ���� : "+e);
		}
			
		return false; // �ߺ� �������� ����
	}
	
		// 1. ȸ������ �޼ҵ� (�μ� : DB�� ���� ���̵�,��й�ȣ,�̸����ּ�)
	public boolean signup(Member member) {
		try {
			// 1. SQL �ۼ� [ȸ����ȣ(�ڵ���ȣ=auto) ������ ��� �ʵ� ����]
			String sql = "insert into member(mid, mpassword, memail, maddress, mpoint, msince) values(?,?,?,?,?,?)";
			// 2. SQL ����
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMid()); // 1�� ?�� ���̵� �־��ֱ�
			ps.setString(2, member.getMpassword()); // 2�� ?�� ��й�ȣ �־��ֱ�
			
			ps.setString(3, member.getMemail()); // 3�� ?�� �̸��� �־��ֱ�
			ps.setString(4, member.getMaddress()); // 4�� ?�� �ּ� �־��ֱ�
			ps.setInt(5, member.getMpoint()); // 5�� ?�� ����Ʈ �־��ֱ�
			ps.setString(6, member.getMsince()); // 6�� ?�� ������ �־��ֱ�
			// 3. SQL ����
			ps.executeUpdate(); // insert ����
			return true;
			
		} catch(Exception e) {
			System.out.println("SQL ���� : "+e);
		}

		
		return false;
	}
		// 2. �α��� �޼ҵ� (�μ� : �α��ν� �ʿ��� ���̵�,��й�ȣ)
	public boolean login(String id, String password) {
		try {
			// 1. SQL �ۼ�
				// and = &&
				// or = ||
			String sql = "select * from member where mid=? and mpassword=?";
			// 2. SQL ����
			ps = con.prepareStatement(sql);
			ps.setString(1, id); // ù��° ?�� id ���� �ֱ�
			ps.setString(2, password); // �ι�° ?�� password ���� �ֱ�
			// 3. SQL ����
			rs = ps.executeQuery(); // select ����
			// 4. SQL ���
			if(rs.next()) { // select�� ������� ������
				return true; // ���̵�� ��й�ȣ�� �����ϸ� -> �α��� ����
			}
		} catch(Exception e) {
			System.out.println("SQL ���� : "+e);
		}
		return false; // �α��� ����
	}
		// 3. ���̵�ã�� �޼ҵ� (�μ� : ���̵�ã��� �ʿ��� �̸���)
	public String findid(String email) {
		try {
			// 1. SQL �ۼ�
			String sql = "select * from member where memail=?";
			// 2. SQL ����
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			// 3. SQL ����
			rs = ps.executeQuery();
			// 4. SQL ���
			if(rs.next()) {
				
				return rs.getString(2);
			}
		} catch(Exception e) {
			System.out.println("SQL ���� : "+e);
		}
		
		
		return null;
	}
		// 4. ��й�ȣã�� �޼ҵ� (�μ� : ��й�ȣã��� �ʿ��� �̸���, ���̵�)
	public String findpw(String email, String id) {
		try {
			// 1. SQL �ۼ�
			String sql = "select * from member where memail=? && mid=?";
			// 2. SQL ����
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, id);
			// 3. SQL ����
			rs = ps.executeQuery();
			// 4. SQL ���
			if(rs.next()) {
				
				return rs.getString(3);
			}
		} catch(Exception e) {
			System.out.println("SQL ���� : "+e);
		}
		
		return null;
	}
	
	// 5. ���̵�� ȸ������ ȣ��
	public Member getMember(String id) {
		try {
			// 1. SQL �ۼ�
			String sql = "select * from member where mid=?";
			// 2. SQL ����
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			// 3. SQL ����
			rs = ps.executeQuery();
			// 4. SQL ���
			if(rs.next()) {
				// 1. ��ü����
				Member member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
				// rs.next() : ����� ���� ���ڵ�(��,����)
				// rs.getInt(�ʵ������ȣ) : �ش� �ʵ��� �ڷ����� ���������� ��������
				// rs.getString(�ʵ������ȣ) : �ش� �ʵ��� �ڷ����� ���ڿ��� ��������
				// 2. ��ȯ
				return member;
			}
			
			
		} catch(Exception e) {
			System.out.println("SQL ���� : "+e);
		}
		return null;
		
		
	}
	// 6. ȸ��Ż�� [ ȸ����ȣ�� �μ��� �޾� �ش� ȸ����ȣ�� ���ڵ� ���� ]
	public boolean delete(int num) {
		try {
			// 1. SQL �ۼ�
					// ���ڵ� ���� : delete from ���̺��� where ����
			String sql = "delete from member where mnum=?";
			// 2. SQL ����
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			// 3. SQL ����
			ps.executeUpdate();
			// 4. SQL ���
			return true;
		} catch(Exception e) {
			System.out.println("SQL ���� : "+e);
		}
		return false;
	}
	// 7. ȸ����������
	public boolean modify(String pw, String newpw, String newpwcheck, String newemail, String newaddress) {
		try {
						// ���� : update ���̺��� set �ʵ��1=������1, �ʵ��2=������2 where ����
			String sql2 = "update member set mpassword=?,memail=?,maddress=? where mnum=?";
			ps = con.prepareStatement(sql2);
			ps.setString(1, newpw);
			ps.setString(2, newemail);
			ps.setString(3, newaddress);
			ps.setInt(4, Login.member.getMnum());
			ps.executeUpdate();
			return true;

		} catch(Exception e) {
			System.out.println("!!!! " + e);
		}
		return false;
	}
	
	
	
	
	// 8. �α��ν� ����Ʈ+10
	public boolean pointplus() {
		try {
			load();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			String now =Login.member.getMid()+format.format(new Date());
			String sql = "update member set mpoint=? where mnum=?";
			ps = con.prepareStatement(sql);
			boolean p = false;
			for(int i=0; i<pointlist.size(); i++) {
				if(pointlist.get(i).equals(now)) {
					p=true;
				}
			}
			if(p==true) {
				ps.setInt(1, Login.member.getMpoint());
			}else {
				ps.setInt(1, (Login.member.getMpoint()+10));
				i = Login.member.getMid()+format.format(new Date());
				save();
			}
			ps.setInt(2, Login.member.getMnum());
			ps.executeUpdate();
			
			
			return true;
		} catch(Exception e) {
			System.out.println("sql ���� : "+ e);
		}
		return false;
	}
	
	public static String i;
	
	// ���� ����
	public static void save() {
		
		try {
			FileOutputStream outputStream = new FileOutputStream("D:/java/����Ʈ.txt", true);
			String a = i+"\n";
			outputStream.write(a.getBytes());
			
		}catch(Exception e) {
			System.out.println("�˸�)) ���� ���� ����(�����ڿ��� ����)");
		}
	}
	// ���� �ҷ�����
	public static void load() {
		try {
			FileInputStream fileInputStream = new FileInputStream("D:/java/����Ʈ.txt");
			byte[] bytes = new byte[1024];
			fileInputStream.read(bytes);
			String file = new String(bytes);
			String[] point = file.split("\n");

			int i=0; // �ε�����
			for(String temp : point) { 
				if(i+1==point.length) break;			
				pointlist.add(temp);
				i++; // �ε��� ����
			}
			
		} catch(Exception e) {
			System.out.println("�˸�)) ���� �ε� ����(�����ڿ��� ����)");
		}
	}
	
	// 9. �ش� ȸ����ȣ�� �ش� id ã��
	public String getmid(int mnum) {
		try {
			String sql = "select mid from member where mnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, mnum);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch(Exception e) {
			System.out.println("ȸ��idã�� SQL ���� : "+e);
		}
		return null;
	}
	
	// 10. ��ü ȸ���� ��ȯ
	public int membertotal() {
		try {
			String sql = "select count(*) from member"; 
							// count(*) : ��� ���ڵ� ��(��������)
							// count(�ʵ��) : ��� ���ڵ� ��(���������)
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch(Exception e) {
			System.out.println("��ü ȸ���� ��ȯ ���� : "+e);
		}
		return 0;
	}
	
	// 11. ��¥�� ȸ������ �� ��ȯ
	public Map<String, Integer> total(String a, String table) {
		try {
			Map<String , Integer> map = new HashMap<>();
			String sql = "select "+a+", count(*) from "+table+" group by "+a;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				map.put(rs.getString(1), rs.getInt(2));
			}
			return map;
		} catch(Exception e) {
			System.out.println("��¥�� ȸ�����Լ� ��ȯ ���� : "+e);
		}
		return null;
	}
	


}