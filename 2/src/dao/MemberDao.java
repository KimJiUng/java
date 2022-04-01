package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Member;



public class MemberDao { // DB ���ٰ�ü
	
	private Connection con; // DB ������ ���Ǵ� Ŭ���� : DB ���� Ŭ����
	private PreparedStatement ps; // ����� DB�� SQL ���� �Ҷ� ���Ǵ� �������̽� : DB�����������̽�
	private ResultSet rs; // ������� �����ϴ� �������̽�
	
	public static MemberDao memberDao = new MemberDao(); // DB ���� ��ü;
	
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
				// �˻� : select * from ���̺�� where ����(�ʵ��=��)
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
	
	

}
