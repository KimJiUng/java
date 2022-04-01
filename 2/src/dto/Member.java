package dto;

public class Member { // 데이터 모델
	
	private int mnum; // 회원 번호
	private String mid; // 회원 아이디
	private String mpassword; // 회원 비밀번호
	private String memail; // 회원 이메일
	private String maddress; // 회원 주소
	private int mpoint; // 회원 포인트
	private String msince; // 회원 가입일
	
	public Member() {}
	
	public Member(int mnum, String mid, String mpassword, String memail, String maddress, int mpoint, String msince) {
		this.mnum = mnum;
		this.mid = mid;
		this.mpassword = mpassword;
		this.memail = memail;
		this.maddress = maddress;
		this.mpoint = mpoint;
		this.msince = msince;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMaddress() {
		return maddress;
	}

	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}

	public int getMpoint() {
		return mpoint;
	}

	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}

	public String getMsince() {
		return msince;
	}

	public void setMsince(String msince) {
		this.msince = msince;
	}
	
	
	
	
	
}
