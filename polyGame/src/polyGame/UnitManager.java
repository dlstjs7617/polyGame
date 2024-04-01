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
				unit = monsterStatus(unit, ranLevel);
				monster.add(unit);
			} catch (Exception e) {
				System.err.println("찾지 못한 클래스명");
			}
		}
	}
	
	private Unit monsterStatus(Unit unit, int level) {
		Unit result = unit;
		if(unit.getName().equals("박쥐")) {
			int hp = ran.nextInt(level * 5) + 100;
			int mp = ran.nextInt(level * 3) + 50;
			int luck = level/3;
			int defense = level/5;
			int dex = level/2;
			unit.init(hp, mp, dex, level);
			unit.init(defense, luck, dex);
			
		}else if(unit.getName().equals("오크")) {
			int hp = ran.nextInt(level * 10) + 200;
			int mp = ran.nextInt(level * 5) + 70;
			int luck = level/5;
			int defense = level/2;
			int dex = level/10;
			unit.init(hp, mp, dex, level);
			unit.init(defense, luck, dex);
			
		}else if(unit.getName().equals("슬라임")) {
			int hp = ran.nextInt(level * 5) + 100;
			int mp = ran.nextInt(level * 5) + 50;
			int luck = level/10;
			int defense = level/10;
			int dex = level/10;
			unit.init(hp, mp, dex, level);
			unit.init(defense, luck, dex);
			
		}else if(unit.getName().equals("늑대")) {
			int hp = ran.nextInt(level * 10) + 100;
			int mp = ran.nextInt(level * 10) + 50;
			int luck =  level/3;
			int defense = level/7;
			int dex = level/10;
			unit.init(hp, mp, dex, level);
			unit.init(defense, luck, dex);
			
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
