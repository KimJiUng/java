package dto;

public class Board {

	private int bnum;
	private String btitle;
	private String bcontent;
	private String bwrite;
	private String bdate;
	private int bview;
	private int mnum;
	
	public Board() {}

	public Board(int bnum, String btitle, String bcontent, String bwrite, String bdate, int bview, int mnum) {
		this.bnum = bnum;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwrite = bwrite;
		this.bdate = bdate;
		this.bview = bview;
		this.mnum = mnum;
	}


	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBwrite() {
		return bwrite;
	}

	public void setBwrite(String bwrite) {
		this.bwrite = bwrite;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBview() {
		return bview;
	}

	public void setBview(int bview) {
		this.bview = bview;
	}
	
	
	
	
}
