package dto;

public class Roomlive {

	private int livenum;
	private int roomnum;
	private String mid;
	
	public Roomlive() {	}

	public Roomlive(int livenum, int roomnum, String mid) {
		this.livenum = livenum;
		this.roomnum = roomnum;
		this.mid = mid;
	}

	public int getLivenum() {
		return livenum;
	}

	public void setLivenum(int livenum) {
		this.livenum = livenum;
	}

	public int getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}
	
	
	
	
}
