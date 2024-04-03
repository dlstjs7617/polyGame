package polyGame;

public class PrintText {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BOLD = "\u001B[1m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_BROWN = "\u001B[33m";
	public static final String ANSI_GRAY = "\u001B[90m";
	   
	   
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
	
	
	
	public static void printWarriorSkill() {
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⢷⣷⣣⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⢏⣿⣿⡵⡀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⣠⣮⣷⣿⣿⣿⣿⣷⣄⣄⠀⠀⠀⠀⠈⢞⣿⣿⡵⡀⠀⠀⠀⠀⠀\r\n"
				+ " ⠀⠀⡠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣏⢦⣤⡀⠀⠀⠀⠫⣻⣿⣾⢄⠀⠀⠀\r\n"
				+ " ⠀⣔⣿⣿⣿⣿⣿⣿⠿⣿⠻⢟⣿⣿⣿⣿⣿⡆⠀⠀⠀⠑⡿⣿⣯⢆⠀⠀\r\n"
				+ " ⢰⣸⢿⣻⢟⠃⠉⠉⠀⡠⠤⠸⣸⣿⣿⣿⡳⠁⠀⠀⠀⠀⡨⠺⠿⠇⢓⡄\r\n"
				+ " ⠧⠊⠁⠘⣖⣳⠠⣶⣋⡹⠁⠀⠛⣩⢻⠋⠀⠀⠀⠀⠀⢀⠇⠀⠀⠀⠀⢾⠀\r\n"
				+ "⠀⠀⢠⠂⠁⠓⠒⠊⠀⡠⠤⡀⢠⠀⠚⠀⠀⠀⠀⠀⡠⠊⢀⠤⡤⣔⠩⠼⡀\r\n"
				+ "⠀⠀⢇⠀⠀⢀⡠⢔⣪⠠⠖⠇⡘⠀⠀⠀⢀⠄⠒⠉⢀⠔⠁⠀⣧⢞⠮⠭⠵⡀\r\n"
				+ "⠀⠀⠘⠒⠉⣾⣀⣀⠀⣀⣀⠦⠗⠹⠙⠃⠁⠀⡠⠔⡡⠔⠒⠉⡨⢴⢹⣿⣏⡆\r\n"
				+ "⠀⠀⠀⠀⡸⠉⠀⠀⠁⠀⠀⠀⠀⣇⡠⡄⡶⠯⠔⠈⠀⠀⡠⠊⠀⠀⡿⣿⣿⡇\r\n"
				+ "⠀⠀⠀⢀⠇⠀⠀⠀⠀⢀⣀⠤⡤⠵⠊⢸⠀⡠⠤⠤⠐⠉⠀⠀⠀⠀⣷⣿⢿⡇\r\n"
				+ "⠀⠀⢀⠃⠀⢀⣀⣀⣀⣠⣀⣀⣿⠉⠉⠉⠉⠀⠀");
	}
	
	public static void printWizardSkill() {
		System.out.println("\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠊⠁⡀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⢀⡠⠔⡊⠌⠍⠌⠅⡃⠮⡁⠀⠈⠁⠂⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⡰⢁⠂⠅⡂⠅⡊⡐⠅⡂⠱⡉⢢⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⢰⢁⠂⢌⢐⢐⠩⢈⠂⠅⡂⠅⡂⠆⢜⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⢸⢐⠨⢐⠠⠂⢌⠰⢨⢐⠠⢁⢺⠀⢸⢅⡀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠈⢆⠌⡐⠨⠨⠸⠀⠀⢖⠨⢐⠊⢢⢊⢐⠨⡢⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠈⠑⢄⢅⠡⠡⢑⢒⠡⠨⢘⢐⢊⡐⡐⢠⠃⠀⠀⠐⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⡀⡀⢀⢐⡅⠌⠌⡐⣐⠨⠬⠔⠔⠕⠕⠪⠠⠀⠢⡒⡑⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⢐⢵⢘⠌⡐⠨⡑⡃⡑⡠⠡⠁⠅⠡⣁⠃⠀⢐⠌⡊⠈⠀⠀⠀⠀\r\n"
				+ "⠠⠤⠤⣀⢀⡀⡑⣀⡡⢑⠩⠐⠐⠀⠈⠍⠉⠉⠁⠀⠉⠓⠐⠉⠀⢀⣀⠀⠀⠀\r\n"
				+ "⠑⢅⢅⠂⡂⡂⢅⢸⠠⠡⠈⠀⠀⠀⡨⠤⡀⠀⠀⠀⠀⢀⣑⠦⢄⠎⠀⠹⡄⡤\r\n"
				+ "⠀⠀⠀⠁⠑⢲⠡⢈⢂⠥⠤⠤⠂⢎⠄⠅⢕⠀⠀⠀⠀⢰⠚⠪⡅⠓⠒⢚⠰⠁\r\n"
				+ "⠀⠀⠀⠀⡎⢈⠘⠂⢘⠀⠀⠀⠀⡌⠈⠊⠀⡉⡆⠀⠀⢈⢲⢓⠁⠀⠐⠙⠦⠀\r\n"
				+ "⠀⠀⠀⠀⠁⠑⠒⠊⠈⠀⠀⠀⠀⠈⠈⠈⠈⠁⠁⠀⠀⠀⠁⠉⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
	}
	
	public static void printHealerSkill() {
		System.out.println("\r\n"
				+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
				+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
				+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠉⠉⠀⠀⠉⠉⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
				+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⠀⠀⣶⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
				+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
				+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
				+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
				+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
				+ "⣿⣿⣿⣷⣬⣝⡋⠉⠉⠛⠛⠉⠙⠁⠀⠀⠈⠋⠉⠛⠛⠉⠉⢙⣫⣥⣾⣿⣿⣿\r\n"
				+ "⣿⣿⣿⣿⣿⣿⣿⣶⣶⣦⣄⡀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣶⣶⣿⣿⣿⣿⣿⣿⣿\r\n"
				+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
				+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
				+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
				+ "");
	}
	
	public static void delay100() {
		try {
			Thread.sleep(100);
		} catch (Exception e) {
		}
	}
	
	public static void delay200() {
		try {
			Thread.sleep(200);
		} catch (Exception e) {
		}
	}
	
	public static void delay300() {
		try {
			Thread.sleep(300);
		} catch (Exception e) {
		}
	}
}
