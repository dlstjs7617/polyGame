package polyGame.stage;

import polyGame.GameManager;
import polyGame.PrintText;

public class Lobby extends Stage{

	private final int DUNGEON = 1;
	private final int VILLAGE = 2;
	private final int EXIT = 0;
	
	@Override
	public boolean update() {
		PrintText.printLobby();
		
		int sel = GameManager.inputNumber("선택");
		if(sel == DUNGEON) {
			GameManager.nextStage = "Move";
		}else if(sel == VILLAGE) {
			GameManager.nextStage = "Village";
		}else if(sel == EXIT) {
			GameManager.nextStage = "End";
		}else {
			return true;
		}
		
		return false;
	}

	@Override
	public void init() {
	}

}
