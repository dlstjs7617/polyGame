package polyGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameManager {
	
	Map<String,Stage> stageList = new HashMap<String, Stage>();

	public static Scanner sc = new Scanner(System.in);
	public static PrintText text = new PrintText();
	public static String nextStage = "";
	public static String curStage = "";
	
	public GameManager() {
		stageList.put("Lobby", new StageLobby());
		stageList.put("Battle", new StageBattle());
		stageList.put("Move", new StageMove());
		stageList.put("Viilage", new StageVillage());
		stageList.put("Boss", new StageBoss());
		
		nextStage = "Lobby";
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

		if (nextStage.equals(""))
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
