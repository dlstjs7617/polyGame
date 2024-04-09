package polyGame.stage;

import java.util.ArrayList;
import java.util.Scanner;

import polyGame.GameManager;
import polyGame.PrintText;
import polyGame.item.Inventory;
import polyGame.item.Item;
import polyGame.unit.Unit;
import polyGame.unit.UnitManager;
import polyGame.unit.player.Player;

public class Battle extends Stage{
	
	private final int ATTACK = 1;
	private final int SKILL = 2;
	private final int BAGPACK = 3;
	
	private UnitManager unitManager = UnitManager.getUnitManager();
	private ArrayList<Unit> playerList = null;
	private ArrayList<Unit> monList = null;
	private Scanner sc = new Scanner(System.in);
	
	private int monDead = 0;
	private int playerDead = 0;
	
	@Override
	public boolean update() {
		boolean battleRun = true;
		
		while(battleRun) {			
			System.out.println("╔════════════════════════════════╗");
			System.out.println("     🛡️🗡️ 전투를 시작합니다! 🧙‍♂️🔮");
			System.out.println("╚════════════════════════════════╝");

			printPlayer();
			printMonster();
			
			// 공격후 몬스터 사망확인
			playerAttack();
			if(checkDead(monList) == monList.size()) {
				int money = GameManager.ran.nextInt(300)+1 +(GameManager.floor * 30);
				Guild.money += money;

				System.out.println("╔════════════════════════════════╗");
				System.out.println("\t    💰 " + money +"골드 획득");
				System.out.println("╚════════════════════════════════╝");
				GameManager.nextStage = "Move";
				return false;
			}
			monsterAttck();
			if(checkDead(playerList) == playerList.size()) {
				System.out.println("게임 패배");
				GameManager.nextStage = "BadEnd";
				return false;
			}
			System.out.println();
		}
		
		return false;
	}

	@Override
	public void init() {
		unitManager.monster.clear();
		unitManager.ranSetMons(GameManager.ran.nextInt(4)+1);
		if(playerList != null) {
			playerList.clear();
		}
		playerList = new ArrayList<Unit>();
		partyPlayer();
		monList = unitManager.monster;
		
		monDead = checkDead(monList);
		playerDead = checkDead(playerList);
	}
	
	private void partyPlayer() {
		ArrayList<Unit> temp = Guild.getPlayers();
		
		for(int i=0; i<temp.size(); i++	) {
			if(temp.get(i).isParty()) {
				playerList.add(temp.get(i));
			}
		}
	}
	
	private void playerAttack() {
		for(int i=0; i<playerList.size(); i++) {
			if(checkDead(monList) == monList.size()) {
				return;
			}
				
				
			Player player = (Player)playerList.get(i);
			if(player.isDead())
				continue;
			PrintText.printBattleMenu(player);
			
			int sel = GameManager.inputNumber("선택");
			Unit monster = monList.get(ranAttack(monList));
			
			
			if(sel == ATTACK) {
				player.attack(monster);			
				
			}else if(sel == SKILL) {
				if(player.getRole().equals("성직자")) {
					if(!player.skill(findLowHp())) {
						i--;
						continue;
					}
				}else {					
					if(!player.skill(monster)) {
						i--;
						continue;
					}
				}
			}else if(sel == BAGPACK) {
				ArrayList<Integer> list = Inventory.selectItemList(6);
				int potion = GameManager.inputNumber("사용할 아이템 선택");
				
				if(potion < 0 || potion >= list.size()) {
					System.out.println("유효하지않는 아이템");
					i--;
					continue;
				}
				
				Item item =Inventory.itemList.get(list.get(potion));
				if(item.getName().contains("HP")) {
					player.setHp(item.getStatus());
					potion(list, item, "체력", potion);
				}else if(item.getName().contains("MP")) {
					player.setMp(item.getStatus());
					potion(list, item, "마나", potion);
				}
			}else {
				i--;
				continue;
			}
			
		}
		
	}
	
	private void potion(ArrayList<Integer> list,Item item, String text, int potion) {
		System.out.println("마나가 "+ item.getStatus() + "회복");
		item.setEa(item.getEa()-1);
		
		if(item.getEa() == 1) 
			Inventory.itemList.remove(list.get(potion));
		else
			item.setEa(item.getEa()-1);
	}
	
	private void monsterNomalAttack(Unit monster) {
		Unit player = playerList.get(ranAttack(playerList));
		monster.attack(player);
	}
	
	private void monsterAttck() {
		for(int i=0; i<monList.size(); i++) {
			if(checkDead(playerList) == playerList.size()) {
				return;
			}
			
			Unit monster = monList.get(i);
			Unit player = playerList.get(ranAttack(playerList));
			if(monster.isDead())
				continue;
			
			int ranATK = GameManager.ran.nextInt(4)+1;
			
			if(ranATK != 1) {
				monsterNomalAttack(monster);
			}else {
				if(!monster.skill(player)) {
					monster.attack(player);
				}
			}
			
		}
	}
	
	private int checkDead(ArrayList<Unit> list) {
		int cnt = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).isDead()) {
				cnt++;
			}
		}
		
		return cnt;
	}
	
	private void printPlayer() {

		System.out.println("╔════════════════════════════════════════════════════╗");
		for(int i=0; i<playerList.size(); i++) {
			Unit unit = playerList.get(i);
			unitManager.printUnit(unit);
			
		}
		System.out.println("╚════════════════════════════════════════════════════╝");
	}
	
	private void printMonster() {
		System.out.println("╔════════════════════════════════════════════════════╗");
		for(int i=0; i<monList.size(); i++) {
			Unit unit = monList.get(i);
			unitManager.printUnit(unit);
		}
		System.out.println("╚════════════════════════════════════════════════════╝");
	}
	
	// 몬스터의 랜덤유닛공격
	private int ranAttack(ArrayList<Unit> list) {
		while(true) {
			int rATK = GameManager.ran.nextInt(list.size());
			if(!list.get(rATK).isDead())
				return rATK;
		}
	}
	
	// 제일 낮은 유닛 회복
	private Unit findLowHp() {
		int low = 0;
		for(int i=0; i<playerList.size(); i++) {
			Unit unit = playerList.get(i);
			if(unit.getHp() < playerList.get(low).getHp()) {
				low = i;
			}
		}
		
		return playerList.get(low);
	}
	
}
