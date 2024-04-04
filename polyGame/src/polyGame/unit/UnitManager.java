package polyGame.unit.monster;

import java.util.ArrayList;
import java.util.Random;

import polyGame.unit.Unit;
import polyGame.unit.player.Healer;
import polyGame.unit.player.Warrior;
import polyGame.unit.player.Wizard;

public class UnitManager {
	
	public static ArrayList<Unit> players = new ArrayList<Unit>();
	public static ArrayList<Unit> monster = new ArrayList<Unit>();
	
	private String path = "polyGame.";
	private String[] mons = { "UnitBat", "UnitOrc", "UnitSlime", "UnitWolf" };
	private Random ran = new Random();
	
	public UnitManager() {
		players.add(new Warrior("김전사",1));
		players.add(new Wizard("이법사", 1));
		players.add(new Healer("박힐러", 1));
	}
	
	public void ranSetMons(int size) {
		for(int i=0; i<size; i++) {
			int rNum = ran.nextInt(mons.length);
			
			try {
				Class<?> clazz = Class.forName(path + mons[rNum]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Unit unit = (Unit)obj;
				
				int ranLevel = ran.nextInt(5)+avgLevel();
				unit = monsterStatus(unit, ranLevel);
				monster.add(unit);
			} catch (Exception e) {
				System.err.println("찾지 못한 클래스명");
				e.printStackTrace();
			}
		}
	}
	
	private Unit monsterStatus(Unit unit, int level) {
		Unit result = unit;
		if(unit.getName().equals("박쥐")) {
			int hp = ran.nextInt(level * 5) + 100;
			int mp = ran.nextInt(level * 3) + 50;
			int power = ran.nextInt(level * 2) +10;
			int luck = level/3;
			int defense = level/5;
			int dex = level/2;
		}else if(unit.getName().equals("오크")) {
			int hp = ran.nextInt(level * 10) + 200;
			int mp = ran.nextInt(level * 5) + 70;
			int power = ran.nextInt(level * 3) +15;
			int luck = level/5;
			int defense = level/2;
			int dex = level/10;
			
		}else if(unit.getName().equals("슬라임")) {
			int hp = ran.nextInt(level * 5) + 100;
			int mp = ran.nextInt(level * 5) + 50;
			int power = ran.nextInt(level) +10;
			int luck = level/10;
			int defense = level/10;
			int dex = level/10;
			
		}else if(unit.getName().equals("늑대")) {
			int hp = ran.nextInt(level * 10) + 100;
			int mp = ran.nextInt(level * 10) + 50;
			int power = ran.nextInt(level * 3) +5;
			int luck =  level/3;
			int defense = level/7;
			int dex = level/10;
			
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
	
	public static void allHeal() {
		for(int i=0; i<players.size(); i++) {
			Unit unit = players.get(i);
			unit.setHp(unit.getMaxHp());
			unit.setMp(unit.getMaxMp());
		}
	}
	
}
