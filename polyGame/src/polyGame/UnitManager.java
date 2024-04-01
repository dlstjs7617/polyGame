package polyGame;

import java.util.ArrayList;
import java.util.Random;

public class UnitManager {
	
	private ArrayList<Unit> players = new ArrayList<Unit>();
	private ArrayList<Unit> monster = new ArrayList<Unit>();
	
	private String path = "polyGame.";
	private String[] mons = { "UnitBat", "UnitOrc", "UnitSlime", "UnitWolf" };
	private Random ran = new Random();
	
	public UnitManager() {
		players.add(new Player("전사", 500, 200, 30, 1));
		players.get(0).init(30, 5, 2);	// 방어력, 행운, 회피
		players.add(new Player("마법사", 300, 500, 30, 1));
		players.get(1).init(10, 7, 1);
		players.add(new Player("힐러", 300, 200, 10, 1));
		players.get(2).init(5, 10, 10);
	}
	
	public void ranSetMons(int size) {
		for(int i=0; i<size; i++) {
			int rNum = ran.nextInt(mons.length);
			
			try {
				Class<?> clazz = Class.forName(path + mons[rNum]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Unit unit = (Unit)obj;
				
				int ranLevel = ran.nextInt(avgLevel()) + 1;
				monsterStatus(unit, ranLevel);
			} catch (Exception e) {
				
			}
			
		}
	}
	
	private Unit monsterStatus(Unit unit, int level) {
		Unit result = unit;
		if(unit.getName().equals("박쥐")) {
			int hp = ran.nextInt(100)+20;
			int mp = ran.nextInt(100)+30;
			
			
		}else if(unit.getName().equals("오크")) {
			int hp = ran.nextInt(level*10) + 100;
			int mp = ran.nextInt(80)+30;
			
		}else if(unit.getName().equals("슬라임")) {
			int hp = ran.nextInt(100)+20;
			int mp = ran.nextInt(100)+30;
			
		}else if(unit.getName().equals("늑대")) {
			int hp = ran.nextInt(100)+20;
			int mp = ran.nextInt(100)+30;
			
		}
		
		return result;
	}
	
	private int avgLevel() {
		int level = 0;
		for(int i=0; i<players.size(); i++) {
			level += players.get(i).getLevel();
		}
		return level/players.size();
	}
	
	
}
