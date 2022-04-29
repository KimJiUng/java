package 평가연습;

public class Car {

	// 필드
	private String carnum;
	private String intimeymd;
	private String intimehm;
	private String outtime;
	private String pay;
	private String intime;
	
	
	// 생성자
	public Car() {}

	public Car(String carnum, String intimeymd, String intimehm, String outtime, String pay, String intime) {
		this.carnum = carnum;
		this.intimeymd = intimeymd;
		this.intimehm = intimehm;
		this.outtime = outtime;
		this.pay = pay;
		this.intime = intime;
	}






	// 메소드
	

	public String getCarnum() {
		return carnum;
	}

	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}

	

	public String getIntimeymd() {
		return intimeymd;
	}

	public void setIntimeymd(String intimeymd) {
		this.intimeymd = intimeymd;
	}

	public String getIntimehm() {
		return intimehm;
	}

	public void setIntimehm(String intimehm) {
		this.intimehm = intimehm;
	}

	public String getOuttime() {
		return outtime;
	}

	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}


	

	
	
	
	
	
}
