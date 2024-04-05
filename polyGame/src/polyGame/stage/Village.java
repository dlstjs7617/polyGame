package polyGame.stage;

import polyGame.GameManager;
import polyGame.PrintText;
import polyGame.item.Shop;

public class Village extends Stage{
	
	private final int LEAVE = 0;
	private final int GUILD = 1;
	private final int SHOP = 2;
	
	private int hpPotion = 400;
	private int mpPotion = 500;
	
	private Shop shop = new Shop();
	private Guild guild = new Guild();
	
	@Override
	public boolean update() {
		while(true) {
			System.out.println("1.길드 2.상점 0.나가기");
			int sel = GameManager.inputString("선택");
			if(sel == -1)
				continue;
			
			if(sel == GUILD) {
				;
			}else if(sel == SHOP) {
				shop.shopRun();
			}else if(sel == LEAVE) {
				break;
			}
		}
		GameManager.nextStage ="Lobby";
		return false;
	}

	@Override
	public void init() {
	}
	
	private void printMenu() {
		System.out.println("║	1.길드 2.상점 0.나가기	 ║");
	}
	
}
