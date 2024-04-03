package polyGame;

public class StageVillage extends Stage{

	@Override
	public boolean update() {
		while(true) {
			printNPC();
			int sel = GameManager.inputString("선택");
			if(sel == -1)
				continue;
			
			if(sel == 1) {
				
			}else if(sel == 2) {
				
			}else if(sel == 3) {
				break;
			}
		}
		GameManager.nextStage ="Lobby";
		return false;
	}

	@Override
	public void init() {
	}
	
	
	private void printNPC() {
		System.out.println("╔════════════════════════════════╗");
		PrintText.printNPC();
		System.out.println("╠════════════════════════════════╣");
		printMenu();
		System.out.println("╚════════════════════════════════╝");
	}
	
	private void printMenu() {
		System.out.println("║	1.회복 2.상점 3.나가기	║");
	}
}
