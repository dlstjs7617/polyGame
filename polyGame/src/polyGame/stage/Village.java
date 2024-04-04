package polyGame.stage;

import polyGame.GameManager;
import polyGame.PrintText;
import polyGame.unit.UnitManager;

public class Village extends Stage{
	
	private int hpPotion = 400;
	private int mpPotion = 500;
	
	@Override
	public boolean update() {
		while(true) {
			printNPC();
			int sel = GameManager.inputString("선택");
			if(sel == -1)
				continue;
			
			if(sel == 1) {
				allHeal();
			}else if(sel == 2) {
				printBuy();
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
	
	private void NPCDot() {
		System.out.println("╔════════════════════════════════╗");
		System.out.println("║              [NPC]             ║");
		
		if(GameManager.ran.nextInt(5)+1 == 4) 
			PrintText.printNPCHidden();
		else
			PrintText.printNPC();
			
		System.out.println("╠════════════════════════════════╣");
	}
	private void printNPC() {
		NPCDot();
	    System.out.println("║ 어서오세요, 모험가길드입니다.		 ║");
	    System.out.println("║ 편안한 휴식과 탐험에 필요한 아이템도	 ║");
	    System.out.println("║ 팔고있어요 어떤 일로 오셨나요?	 ║");
		System.out.println("╠════════════════════════════════╣");
		printMenu();
		System.out.println("╚════════════════════════════════╝");
	}
	
	private void printMenu() {
		System.out.println("║	1.회복 2.상점 3.나가기	 ║");
	}
	
	private void allHeal() {
		UnitManager.allHeal();
		System.out.println("╔════════════════════════════════╗");
		System.out.println("║      파티원들이 모두 회복되었다.	 ║");
		System.out.println("╚════════════════════════════════╝");
	}
	
	private void printBuy() {
		NPCDot();
		System.out.println("║ 	    1.HP포션(400💰)	  ║");
		System.out.println("║ 	    2.MP포션(500💰)	  ║");
		System.out.println("╠════════════════════════════════╣");
		System.out.printf("║	소지금 : %5d💰		 ║\n",GameManager.money);
		System.out.println("╚════════════════════════════════╝");
		int sel = GameManager.inputString("선택");
		
		if(sel == 1) {
			if(GameManager.money < hpPotion) {
				System.err.println("소지금이 부족합니다.");
			}else {
				GameManager.hpPotion++;
				GameManager.money -= hpPotion;
			}
		}else if(sel == 2) {
			if(GameManager.money < mpPotion) {
				System.err.println("소지금이 부족합니다.");
			}else {
				GameManager.hpPotion++;
				GameManager.money -= mpPotion;
			}
		}
	}
}
