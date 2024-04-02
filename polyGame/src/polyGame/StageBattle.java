package polyGame;

import java.util.ArrayList;
import java.util.Random;

public class StageBattle extends Stage{
	UnitManager unitManager = new UnitManager();
	ArrayList<Unit> playerList = null;
	ArrayList<Unit> monList = null;
	Random ran = new Random();
	int monDead = 0;
	int playerDead = 0;
	
	@Override
	public boolean update() {
		boolean battleRun = true;
		boolean turn = false;
		
		while(battleRun) {
			System.out.println("====전투 페이즈====");
			printPlayer();
			System.out.println();
			printMonster();
			
			int pLive = playerList.size() - playerDead;
			int mLive = monList.size() - monDead;
			playerTurn(pLive);
			monsterTurn(mLive);
			monDead = checkDead(monList);
			playerDead = checkDead(playerList);
			
			if(pLive == 0) {
				System.out.println("게임 패배");
				GameManager.nextStage = "Move";
				return false;
			}else if(turnEnd(monList)) {
				System.out.println("====== 승리 ======");
				int money = ran.nextInt(300)+1 +(GameManager.floor * 30);
				GameManager.money += money;
				System.out.println("💰 " + money +"골드 획득");
				System.out.println("=================");
				turn = true;
				battleRun = false;
			}
		}
		
		
		
		GameManager.nextStage = "Move";
		return false;
	}

	@Override
	public void init() {
		unitManager.monster.clear();
		unitManager.ranSetMons(ran.nextInt(4)+1);
		
		playerList = null;
		playerList = unitManager.players;
		
		monList = unitManager.monster;
		
		monDead = checkDead(monList);
		playerDead = checkDead(playerList);
	}
	
	private void playerTurn(int pLive) {
		int cnt = 0;
		System.out.println(pLive);
		while(pLive > cnt) {
			System.out.println("1.⚔️공격 2.🌀스킬 3.미구현");
			int sel = GameManager.inputString("선택");
			
			if(sel == -1)
				continue;
			if(sel == 1) {
				Unit unit = playerList.get(cnt);
				Unit enemy = monList.get(ranAttack(monList));
				unit.attack(enemy);
			}else if(sel == 2) {
				
			}
			cnt++;
			if(turnEnd(monList))
				break;
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
	
	private boolean turnEnd(ArrayList<Unit> unit) {
		boolean isRun = true;
		for(int i=0; i<unit.size(); i++) {
			if(!unit.get(i).isDead())
				isRun = false;
		}
		return isRun;
	}
	
	private void monsterTurn(int mLive) {
		int cnt = 0;
		while(!turnEnd(monList) && cnt < monList.size()) {
			Unit unit = monList.get(cnt);
			Unit enemy = playerList.get(ranAttack(playerList));
			unit.attack(enemy);
			cnt++;
		}
	}
	
	private void printUnit(Unit unit) {
		int level = unit.getLevel();
		String name = unit.isDead() == true ? "💀"+unit.getName(): unit.getName();
		int hp = unit.getHp();
		int maxHp = unit.getMaxHp();
		int mp = unit.getMp();
		int maxMp = unit.getMaxMp();
		int power = unit.getPower();
		int defense = unit.getDefense();
		
		String temp = String.format("[ Lv.%2d %4s ♥[%3d/%3d] 💧[%3d/%3d]  (🗡%3d  🛡%3d) ]", level, name, hp, maxHp, mp, maxMp, power, defense);
		System.out.println(temp);
	}
	
	private void printPlayer() {
		System.out.println("======= [플레이어] =======");
		for(int i=0; i<playerList.size(); i++) {
			Unit unit = playerList.get(i);
			printUnit(unit);
			
		}
		System.out.println("=====================");
	}
	
	private void printMonster() {
		System.out.println("======= [몬스터] =======");
		for(int i=0; i<monList.size(); i++) {
			Unit unit = monList.get(i);
			printUnit(unit);
		}
		System.out.println("=====================");
	}
	
	private int ranAttack(ArrayList<Unit> list) {
		while(true) {
			int rATK = ran.nextInt(list.size());
			if(!list.get(rATK).isDead())
				return rATK;
		}
		
		
	}
	
}
