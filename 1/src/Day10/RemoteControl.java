package Day10;

public interface RemoteControl { // �������̽� ����

	// ��� ����
		// 1. ��� �ʵ� : ������ ������
		public int MAX_VOLUME = 10; // �������� �ִ� ����
		public int MIN_VOLUME = 0; // �������� �ּ� ����
		
		// 2. �߻� �޼ҵ�** : ����o ����x
			// abstract : �߻� [�������̽������� ����]
		public void turnOn(); // {} ���� [����x]
		public void turnOff(); // ���� x
		public void setVolume(int volume); // ����x
		
		// 3. ����Ʈ �޼ҵ� : ����o ����o 
		default void setMute(boolean mute) {
			if(mute) {
				System.out.println("���� ó��");
			} else {
				System.out.println("���� ����");
			}
		}
		
		// 4. ���� �޼ҵ� : ����o ����o [��ü���� ����]
		static void changeBattery() {
			System.out.println("������ ��ü�մϴ�.");
		}
	
	
	
} // i e