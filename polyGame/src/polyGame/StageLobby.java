package polyGame;

public class StageLobby extends Stage{

	
	
	@Override
	public boolean update() {
		System.out.println("=========[던전입구]======");
		System.out.println("1.던전입장 2.마을 3.게임종료");
		System.out.println("======================");
		int sel = GameManager.sc.nextInt();
		if(sel == 1) {
			GameManager.nextStage = "Move";
		}else if(sel == 2) {
			GameManager.nextStage = "Village";
		}else if(sel == 3) {
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
