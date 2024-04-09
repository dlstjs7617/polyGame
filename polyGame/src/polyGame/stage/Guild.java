package polyGame.stage;

import java.util.ArrayList;

import polyGame.GameManager;
import polyGame.PrintText;
import polyGame.item.Inventory;
import polyGame.item.Item;
import polyGame.unit.Unit;
import polyGame.unit.UnitManager;
import polyGame.unit.player.Healer;
import polyGame.unit.player.Player;
import polyGame.unit.player.Warrior;
import polyGame.unit.player.Wizard;

public class Guild{
	
	private final int PARTY_SIZE = 3;
	
	private final int LEAVE = 0;
	private final int SELETCT = 1;
	private final int JOIN = 2;
	private final int OUT = 3;
	private final int INVENTORY = 4;
	private final int EQUIPMENT = 5;
	private final int SAVE = 6;
	private final int LOAD = 7;
	
	private final int BRONZE = 1;
	private final int SILVER = 2;
	private final int GOLD = 3;
	
	private final int WARRIOR = 1;
	private final int WIZARD = 2;
	private final int HEALER = 3;
	
	private final int WEAPON = 1;
	private final int ARMOR = 2;
	private final int RING = 3;
	
	private static ArrayList<Unit> players = new ArrayList<Unit>();
	
	private static Guild instance = new Guild();

	
	private final int NAME_SIZE = 10;
	private int count;
	public static int money = 1000000;
	
	private String[] n1 = {"김","이","박","최","정","강","조","윤","차","제갈"};
	private String[] n2 = {"동","지","현","영","미","서","하","예","은","공",};
	private String[] n3 = {"준","안","연","자","아","윤","현","원","우","명",};
	
	private Guild() {
		players.add(new Warrior("김전사",1));
		players.get(0).setParty(true);
		players.add(new Wizard("이법사", 1));
		players.get(1).setParty(true);
		players.add(new Healer("박힐러", 1));
		players.get(2).setParty(true);
		count = 3;
	}
	
	public static Guild getInstance() {
		return instance;
	}
	
	public static ArrayList<Unit> getPlayers(){
		return players;
	}
	
	private void GuildMenu() {
		System.out.println("╔═══════════════════════════════════════╗");
		System.out.println("║          [🌟 길드 메뉴 🌟]	    	║");
		System.out.println("╠═══════════════════════════════════════╣");
		System.out.println("║    🛡️1.파티 편성 	🤝2.길드원 모집	║");
		System.out.println("║    ❌3.길드 추방 	🎒4.인벤토리 	║");
		System.out.println("║    🗡5.파티원 장비	🚪0.나가기		║");
		System.out.println("║    💾6.저장하기		⏳7.불러오기	║");
		System.out.println("╚═══════════════════════════════════════╝");
		
	}
	
	private void printUnit() {
		System.out.println("╔═════════════════════════════════════════════════════════════╗");
		for(int i=0; i<players.size(); i++) {
			Unit unit = players.get(i);
			UnitManager.printPlayer(unit, i+1);
		}
		System.out.println("╚═════════════════════════════════════════════════════════════╝");
	}
	
	private void selectPartyProcess(int idx) {
		Unit unit = players.get(idx);
		if(!unit.isParty() && PARTY_SIZE == count) {
			System.err.println("최대 편성중이라 불가능합니다.");
			return;
		}
		
		if(!unit.isParty()) {
			unit.setParty(true);
			count++;
			System.out.println("파티원 추가완료");
		}else if(unit.isParty()) {
			unit.setParty(false);
			count--;
			System.out.println("파티원 해제완료");
		}
	}
	
	private void selectParty() {
			printUnit();
			int idx = GameManager.inputNumber("파티 편성선택")-1;
			if(idx < 0 || idx >= players.size()) {
				System.err.println("유효하지 않은 길드원");
				return;
			}
			selectPartyProcess(idx);
	}
	
	private String ranName() {
		String name = "";
		name += n1[GameManager.ran.nextInt(NAME_SIZE)];
		name += n2[GameManager.ran.nextInt(NAME_SIZE)];
		name += n3[GameManager.ran.nextInt(NAME_SIZE)];
		
		return name;
	}
	
	private void randomGunild(int level) {
		int job = GameManager.ran.nextInt(3)+1;
		int ranLevel = GameManager.ran.nextInt(level)+level;
		
		if(job == WARRIOR) {
			players.add(new Warrior(ranName(), ranLevel));
			System.out.println("전사가 길드에 들어왔습니다.");
		}else if(job == WIZARD) {
			players.add(new Wizard(ranName(), ranLevel));
			System.out.println("마법사가 길드에 들어왔습니다.");
		}else if(job == HEALER) {
			players.add(new Healer(ranName(), ranLevel));
			System.out.println("힐러가 길드에 들어왔습니다.");
		}
		
	}
	
	private void gachaGuild() {
		System.out.println("1.브론즈 등급 길드원 모집(2000)");
		System.out.println("2.실버 등급 길드원 모집(8000)");
		System.out.println("3.골드 등급 길드원 모집(20000)");
		System.out.println("0.나가기");
		
		int sel = GameManager.inputNumber("선택");
		
		if(sel == BRONZE && money >= 2000) {
			randomGunild(3);
			money -= 2000;
		}else if(sel == SILVER && money >= 8000) {
			randomGunild(7);
			money -= 8000;
		}else if(sel == GOLD && money >= 20000) {
			randomGunild(10);
			money -= 20000;
		}else if(sel == LEAVE) {
			return;
		}
	}
	
	private void getOut() {
		printUnit();
		int idx = GameManager.inputNumber("추방할 길드원 선택")-1;
		
		if(idx < 0 || idx >= players.size()) {
			System.err.println("존재하지 않는 길드우너");
			return;
		}
		int money =  (players.get(idx).getLevel()*5) * 5;
		this.money += money;
		
		players.remove(idx);
		System.out.println("길드원을 추방하고 " + money +"의 돈을 뺏었습니다.");
		count--;
		
	}
	
	private void printInventory() {
		Inventory.printItemList();
	}
	
	private int type(Player unit) {
		int type = 0;
		if(unit.getRole().equals("전사")) {
			type = 1;
		}else if(unit.getRole().equals("마법사")) {
			type = 2;
		}else if(unit.getRole().equals("힐러")) {
			type = 3;
		}
		return type;
	}
	
	private void setItem(Player unit, Item item,int type) {
		if(type > 0 && type <= 3)
			unit.setWeapon(item);
		else if(type == 4)
			unit.setArmor(item);
		else if(type == 5)
			unit.setRing(item);
	}
	
	private void putOn(Player unit,int type) {
		ArrayList<Integer> list = Inventory.selectItemList(type);
		int itemIdx = GameManager.inputNumber("선택")-1; 
		if(itemIdx < 0 || itemIdx >= list.size()) {
			System.err.println("없는 아이템");
			return;
		}
		Item item = Inventory.itemList.get(list.get(itemIdx));
		setItem(unit, item, type);
		Inventory.itemList.remove(item);

	}
	
	private void putOff(Player unit,int type) {
		Item item = unit.getWeapon();
		Inventory.itemList.add(item);
		setItem(unit, null, type);
	}
	
	private void equipment() {
		printUnit();
		int idx = GameManager.inputNumber("장비교체할 길드원 선택")-1;
		
		if(idx < 0 || idx >= players.size()) {
			System.err.println("존재하지 않는 길드원");
			return;
		}
		
		Player unit = (Player)players.get(idx);
		UnitManager.printPlayerStatus(unit);
		
		System.out.println("변경할 부위 선택");
		System.out.println("1.무기 2.방어구 3.반지 4.나가기");
		int sel = GameManager.inputNumber("선택 :");
		
		int type = type(unit);
		
		if(sel == WEAPON) {
			if(unit.getWeapon() == null) {
				putOn(unit,type);				
			}else {
				putOff(unit,type);
			}
			
		}else if(sel == ARMOR) {
			type = 4;
			if(unit.getArmor() == null) {
				putOn(unit,type);				
			}else {
				putOff(unit,type);
			}
		}else if(sel == RING) {
			type = 5;
			if(unit.getRing() == null) {
				putOn(unit,type);				
			}else {
				putOff(unit,type);
			}
		}else if(sel == LEAVE) {
			return;
		}
		
		
	}
	private void allHeal() {
		for(int i=0; i<players.size(); i++) {
			Unit unit = players.get(i);
			unit.setHp(unit.getMaxHp());
			unit.setMp(unit.getMaxMp());
		}
		System.out.println("길드에서 휴식해 회복되었다.");
	}
	
	public void run() {
		while(true) {
			PrintText.printGuild();
			GuildMenu();
			int sel = GameManager.inputNumber("선택");
			
			if(sel == LEAVE) {
				if(count == 0) {
					System.err.println("현재 파티가 0명입니다. 한명이상 편성해야합니다.");
					continue;
				}else {
					allHeal();
					break;				
				}
			}else if(sel == SELETCT) {
				selectParty();
			}else if(sel == JOIN) {
				gachaGuild();
			}else if(sel == OUT) {
				getOut();
			}else if(sel == INVENTORY) {
				printInventory();
			}else if(sel == EQUIPMENT) {
				equipment();
			}else if(sel == SAVE) {
				
			}else if(sel == LOAD) {
				
			}
		}
	}
}
