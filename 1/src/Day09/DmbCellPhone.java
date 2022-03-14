package Day09;

public class DmbCellPhone extends CellPhone { // c s
	// 서브클래스가 슈퍼클래스 선택 => extends 슈퍼클래스
		// 서브클래스가 슈퍼클래스내 멤버 사용가능
	// 1. 필드
	int channel;
	
	// 2. 생성자
	DmbCellPhone(String model, String color, int channel){
		this.model = model; // this.필드명
		this.color = color;
		// * 현재 클래스에 없는 필드이므로 슈퍼클래스내 멤버 호출
		this.channel = channel;
	}
	
	// 3. 메소드
	void turnOnDmb() {
		System.out.println("채널 : "+channel+"번 DMB 방송 수신을 시작합니다.");
	}
	void changeChannelDmb(int channel) {
		this.channel=channel;
		System.out.println("채널 : "+channel+"번으로 바꿉니다.");
	}
	void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}
	
	
	
} // c e
