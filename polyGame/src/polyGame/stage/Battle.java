package polyGame.stage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import polyGame.GameManager;
import polyGame.unit.Unit;
import polyGame.unit.UnitManager;

public class Battle extends Stage{
	private UnitManager unitManager = new UnitManager();
	private ArrayList<Unit> playerList = null;
	private ArrayList<Unit> monList = null;
	private Random ran = new Random();
	private Scanner sc = new Scanner(System.in);
	
	private int monDead = 0;
	private int playerDead = 0;
	
	@Override
	public boolean update() {
		boolean battleRun = true;
		boolean turn = false;
		
		while(battleRun) {			
			System.out.println("╔════════════════════════════════╗");
			System.out.println("     🛡️🗡️ 전투를 시작합니다! 🧙‍♂️🔮");
			System.out.println("╚════════════════════════════════╝");

			printPlayer();
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
				int money = ran.nextInt(300)+1 +(GameManager.floor * 30);
				GameManager.money += money;

				System.out.println("╔════════════════════════════════╗");
				System.out.println("\t    💰 " + money +"골드 획득");
				System.out.println("╚════════════════════════════════╝");
				turn = true;
				battleRun = false;
			}
			System.out.println();
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
		while(pLive > cnt) {
			Unit player = playerList.get(cnt);
			System.out.println("╔════════════════════════════════╗");
			System.out.printf("║           %3s의 턴		 ║\n",player.name);
			System.out.println("╠════════════════════════════════╣");
			System.out.println("║🔹 선택할 행동:			 ║");
			System.out.println("║1.⚔️공격				 ║");
			System.out.println("║2.🌀스킬				 ║");
//			System.out.println("║3.미구현				 ║");
			System.out.println("╠════════════════════════════════╣");
			System.out.println("║원하는 행동을 선택하세요.		 ║");
			System.out.println("╚════════════════════════════════╝");
			int sel = inputString();
			System.out.println();
			if(sel == -1)
				continue;
			
			Unit enemy = monList.get(ranAttack(monList));
			Unit pHeal = findLowHp();
			if(sel == 1) {
				player.attack(enemy);
			}else if(sel == 2) {	
				if(player.getName().equals("힐러")) {
					if(!player.skill(pHeal))
						continue;
				}else
					if(!player.skill(enemy))
						continue;
			}
			if(turnEnd(monList))
				break;	
			cnt++;
		}
	}
	
	private int inputString() {
		int number = -1;
		try {
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만입력");
		}
		return number;
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
		
		System.out.println("╔════════════════════════════════╗");
		System.out.println("║     🛡️ 『✨ 전투 결과 ✨』 🗡️	 ║");
		while(!turnEnd(monList) && cnt < monList.size()) {
			Unit unit = monList.get(cnt);
			Unit enemy = playerList.get(ranAttack(playerList));
			unit.attack(enemy);
			cnt++;
		}
		System.out.println("╚════════════════════════════════╝");
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
		
		String temp = String.format("║[Lv.%2d %4s ♥[%3d/%3d] 💧[%3d/%3d](🗡%3d🛡%3d)]", level, name, hp, maxHp, mp, maxMp, power, defense);
		System.out.println(temp);
	}
	
	private void printPlayer() {

		System.out.println("╔════════════════════════════════════════════════════╗");
		for(int i=0; i<playerList.size(); i++) {
			Unit unit = playerList.get(i);
			printUnit(unit);
			
		}
		System.out.println("╚════════════════════════════════════════════════════╝");
	}
	
	private void printMonster() {
		System.out.println("╔════════════════════════════════════════════════════╗");
		for(int i=0; i<monList.size(); i++) {
			Unit unit = monList.get(i);
			printUnit(unit);
		}
		System.out.println("╚════════════════════════════════════════════════════╝");
	}
	
	private int ranAttack(ArrayList<Unit> list) {
		while(true) {
			int rATK = ran.nextInt(list.size());
			if(!list.get(rATK).isDead())
				return rATK;
		}
	}
	
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
