package polyGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import polyGame.stage.Stage;
import polyGame.stage.Battle;
import polyGame.stage.Boss;
import polyGame.stage.Lobby;
import polyGame.stage.Move;
import polyGame.stage.Village;
import polyGame.unit.UnitManager;

public class GameManager {
	
	Map<String,Stage> stageList = new HashMap<String, Stage>();

	public static Scanner sc = new Scanner(System.in);
	public static Random ran = new Random();
	public static UnitManager unitManager = UnitManager.getUnitManager(); 
	public static PrintText text = new PrintText();
	public static String nextStage = "";
	public static String curStage = "";
	
	public static int floor = 1;
	
	public GameManager() {
		stageList.put("Lobby", new Lobby());
		stageList.put("Battle", new Battle());
		stageList.put("Move", new Move());
		stageList.put("Village", new Village());
		stageList.put("Boss", new Boss());
		stageList.put("BadEnd", new Boss());
		
		nextStage = "Lobby";
	}
	
	public static int inputNumber(String message) {
		int number = -1;
		System.out.print(message + " : ");
		try {
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		return number;
	}

	
	private boolean changeStage() {
		System.out.println("╔═══════════════════════════════════════╗");
		System.out.println("║ curStage : " + curStage);
		System.out.println("║ nextStage : " + nextStage);
		System.out.println("╚═══════════════════════════════════════╝");

		if (curStage.equals(nextStage))
			return true;

		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.init();

		boolean run = true;
		while (true) {
			run = stage.update();
			if (run == false)
				break;
		}

		if (nextStage.equals("BadEnd") || nextStage.equals("End"))
			return false;
		else
			return true;
	}

	public void run() {
		text.intro();
		while(true) {
			boolean run = changeStage();
			if(!run)
				break;
		}
		System.out.println("게임끝");
	}
}
