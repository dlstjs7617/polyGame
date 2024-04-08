package polyGame.item;

import java.util.ArrayList;

import polyGame.GameManager;
import polyGame.PrintText;
import polyGame.stage.Guild;

public class Shop {
	
	private final int BUY = 1;
	private final int SELL = 2;
	private final int LEAVE = 0;
	
	private final int WEAPON = 1;
	private final int SHIELD = 2;
	private final int ORNAMENT = 3;
	private final int HEALING = 4;
	
	private final int SWORD = 1;
	private final int SATFF = 2;
	private final int WAND = 3;
	private final int ARMOR = 4;
	private final int RING = 5;
	private final int HPPOTION = 6;
	private final int MPPOTION = 7;
	
	private ItemList list = new ItemList();
	private Inventory inventory = Inventory.getInstance();
	private ArrayList<Item> shopList;
	
	public Shop() {
		setShop();
	}

	private void setShop() {
		shopList = list.getShopList();
	}
	
	private void printMenu() {
		System.out.println("	1.구매 2.판매 0.나가기	");
	}
	
	private void buyMenu() {
		System.out.println("╔════════════════════════════════╗");
		System.out.println("║     1.무기 2.갑옷 3.반지 4.포션	 ║");	
		System.out.println("╚════════════════════════════════╝");
		int sel = GameManager.inputNumber("선택");
	
		if(sel == WEAPON)
			printWeaponMenu();
		else if(sel == SHIELD)
			printArmor();
		else if(sel == ORNAMENT)
			printRing();
		else if(sel == HEALING)
			printPotion();
		
	}
	
	private void sellMenu() {
		inventory.printItemList();
		if(inventory.size() == 0) {
			System.err.println("팔 아이템이 없습니다.");
			return;
		}
		int idx = GameManager.inputNumber("선택")-1;
		
		if(idx < 0 || idx > inventory.size()) {
			System.err.println("없는 아이템");
			return;
		}
		inventory.sellMyItem(idx);
	}
	
	private void printWeaponMenu() {
		while(true) {
			System.out.println("╔═══════════════════════════════════════════════╗");
			System.out.println("║  1.검(전사) 2.스태프(마법사) 3.완드(힐러) 0.나가기	║");	
			System.out.println("╚═══════════════════════════════════════════════╝");
			int sel = GameManager.inputNumber("선택");
			
			if(sel == SWORD)
				buyItem(SWORD);
			else if(sel == SATFF)
				buyItem(SATFF);
			else if(sel == WAND)
				buyItem(WAND);
			else if(sel == LEAVE)
				break;
		}
	}
	
	private void printArmor() {
		buyItem(ARMOR);
	}
	
	private void printRing() {
		buyItem(RING);
	}
	
	private void printPotion() {
		buyItem(HPPOTION);
	}
	
	private ArrayList<Integer> printItem(int type) {
		int cnt = 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("╔══════════════════════════════════════════╗");
		for(int i=0; i<shopList.size(); i++) {
			Item item = shopList.get(i);
			if(item.getType() == type) {
				System.out.println("  "+cnt++ +"."+ item);
				list.add(i);
			}else {
				
			}
		}
		System.out.println("╚══════════════════════════════════════════╝");
		return list;
	}

	private void buyItem(int type) {
		System.out.println("소지금 : " + Guild.money + "골드");
		ArrayList<Integer> selList = printItem(type);
		int goods = GameManager.inputNumber("상품선택")-1;
		
		if(goods < 0 || goods >= selList.size()) {
			System.err.println("없는 상품");
			return;
		}

		int idx = selList.get(goods);
		
		Item item = inventory.clone(shopList.get(idx));
		if(item.getPrice() > Guild.money) {
			System.err.println("잔액 부족");
			return;
		}
		
		if(!inventory.check(item, "구매")) {
			inventory.createItem(item);
			Guild.money -= item.getPrice();
		}
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
	    System.out.println("║ 어서오세요,  냥캣🐾상점입니다.	 ║");
	    System.out.println("║ 던전에서 나온 전리품을 사거나.	 ║");
	    System.out.println("║ 탐험에 필요한 아이템을 팔고있어요	 ║");
	    System.out.println("║ 팔고있어요 어떤 일로 오셨나요?	 ║");
		System.out.println("╠════════════════════════════════╣");
		printMenu();
		System.out.println("╚════════════════════════════════╝");
	}
	
	public void shopRun() {
		while(true) {
			printNPC();
			int sel = GameManager.inputNumber("선택");
			
			if(sel == BUY) {
				buyMenu();
			}else if(sel == SELL) {
				sellMenu();
			}else if(sel == LEAVE) {
				break;
			}
		}
	}
}
