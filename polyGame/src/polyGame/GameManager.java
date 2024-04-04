package polyGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import polyGame.stage.Stage;
import polyGame.stage.StageBattle;
import polyGame.stage.StageBoss;
import polyGame.stage.StageLobby;
import polyGame.stage.StageMove;
import polyGame.stage.StageVillage;

public class GameManager {
	
	Map<String,Stage> stageList = new HashMap<String, Stage>();

	public static Scanner sc = new Scanner(System.in);
	public static Random ran = new Random();
	public static PrintText text = new PrintText();
	public static String nextStage = "";
	public static String curStage = "";
	
	public static int floor = 1;
	public static int money = 0;
	public static int hpPotion = 0;
	public static int mpPotion = 0;
	
	public GameManager() {
		stageList.put("Lobby", new StageLobby());
		stageList.put("Battle", new StageBattle());
		stageList.put("Move", new StageMove());
		stageList.put("Village", new StageVillage());
		stageList.put("Boss", new StageBoss());
		stageList.put("BadEnd", new StageBoss());
		
		nextStage = "Lobby";
	}
	
	public static int inputString(String message) {
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
		System.out.println("curStage : " + curStage);
		System.out.println("nextStage : " + nextStage);

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
