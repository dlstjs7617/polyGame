package polyGame;

public class PrintText {
	
	private String intro = "\"아르카나의 심연, 그 어둠 속으로 당신의 발자취가 빛을 잃기 시작한다.\n"
			+ " 이곳은 전설적인 함정과 위험으로 가득 찬 미지의 던전이다.\n"
			+ " 당신은 이 지하 세계의 비밀을 밝히기 위해 도전을 시작한다.\n";
	
	public void intro() {
		for(int i=0; i<intro.length(); i++) {
			System.out.print(intro.charAt(i));
//			delay100();
		}
	}
	
	public void DungeonFloor(int floor) {
		System.out.println("====== " + floor + "층 =====");
	}
	
	private void delay100() {
		try {
			Thread.sleep(100);
		} catch (Exception e) {
		}
	}
	
	private void delay200() {
		try {
			Thread.sleep(200);
		} catch (Exception e) {
		}
	}
	
	private void delay300() {
		try {
			Thread.sleep(300);
		} catch (Exception e) {
		}
	}
}
