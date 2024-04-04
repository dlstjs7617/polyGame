package polyGame.unit;

import java.util.ArrayList;
import java.util.Random;

import polyGame.unit.player.Healer;
import polyGame.unit.player.Warrior;
import polyGame.unit.player.Wizard;

public class UnitManager {
	
	public static ArrayList<Unit> players = new ArrayList<Unit>();
	public static ArrayList<Unit> monster = new ArrayList<Unit>();
	
	private String path = "polyGame.unit.monster.";
	private String[] mons = { "Bat", "Orc", "Slime", "Wolf" };
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
				int ranLevel = ran.nextInt(5)+avgLevel();
				Class<?> clazz = Class.forName(path + mons[rNum]);
				Object obj = clazz.getDeclaredConstructor().newInstance(ranLevel);
				Unit unit = (Unit)obj;
				
				monster.add(unit);
			} catch (Exception e) {
				System.err.println("찾지 못한 클래스명");
				e.printStackTrace();
			}
		}
	}
	
	
	
	private int avgLevel() {
		int level = 1;
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
