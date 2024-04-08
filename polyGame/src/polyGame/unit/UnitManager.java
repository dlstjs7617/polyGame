package polyGame.unit;

import java.util.ArrayList;
import java.util.Random;

import polyGame.stage.Guild;
import polyGame.unit.player.Healer;
import polyGame.unit.player.Player;
import polyGame.unit.player.Warrior;
import polyGame.unit.player.Wizard;

public class UnitManager {
	
	public static ArrayList<Unit> players = Guild.getPlayers();
	public static ArrayList<Unit> monster = new ArrayList<Unit>();
	
	private String path = "polyGame.unit.monster.";
	private String[] mons = { "Bat", "Orc", "Slime", "Wolf" };
	private Random ran = new Random();
	private Guild guild = Guild.getInstance();
	
	private UnitManager() {
		
	}
	
	private static UnitManager unitManager = new UnitManager();
	
	public static UnitManager getUnitManager() {
		return unitManager;
	}
	
	public void ranSetMons(int size) {
		for(int i=0; i<size; i++) {
			int rNum = ran.nextInt(mons.length);
			
			try {
				int ranLevel = ran.nextInt(3)+avgLevel();
				System.out.println(ranLevel);
				Class<?> clazz = Class.forName(path + mons[rNum]);
				Object obj = clazz.getDeclaredConstructor(int.class).newInstance(ranLevel);
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
	
	public void printUnit(Unit unit) {
		String name = unit.isDead() == true ? "💀"+unit.getName(): unit.getName();
		String weaponStat = unit.getWeapon() == null ? "" : "+("+ unit.getWeapon().getStatus()+")"; 
		String armorStat = unit.getArmor() == null ? "" : "+("+ unit.getArmor().getStatus()+")";
		
		String temp = String.format("║[Lv.%2d %4s ♥[%3d/%3d] 💧[%3d/%3d](🗡%3d%s🛡%3d%s)]",
				unit.getLevel(), name, unit.getHp(), unit.getMaxHp(), unit.getMp(), unit.getMaxMp(),
				unit.getPower(), weaponStat, unit.getDefense(), armorStat);
		System.out.println(temp);
	}
	
	public static void printPlayer(Unit unit, int idx) {
		Player player = (Player)unit;
		String role = player.getRole();
		String name = unit.isDead() == true ? "💀"+unit.getName(): unit.getName();
		String weaponStat = unit.getWeapon() == null ? "" : "+("+ unit.getWeapon().getStatus()+")"; 
		String armorStat = unit.getArmor() == null ? "" : "+("+ unit.getArmor().getStatus()+")";
		String ringStat = unit.getRing() == null ? "" : "+("+ unit.getRing().getStatus()+")"; 

		String temp = String.format("║%d.[Lv.%2d %4s(%3s) ♥[%3d/%3d] 💧[%3d/%3d] \n║   (🗡%3d%s🛡%3d%s)] [🏃‍♂️:%2d/🍀%2d%s] 파티여부 : %s",
				idx ,unit.getLevel(), name, role, unit.getHp(), unit.getMaxHp(), unit.getMp(), unit.getMaxMp(),
				unit.getPower(), weaponStat, unit.getDefense(), armorStat, unit.getDex(), unit.getLuck(), ringStat, unit.isParty());
		System.out.println(temp);
	}
	
	public static void printPlayerStatus(Unit unit) {
		Player player = (Player)unit;
		String role = player.getRole();
		
		String w = player.getWeapon() == null ? "미착용" : unit.getWeapon() +"";
		String a = player.getArmor() == null ? "미착용" : unit.getArmor() +"";
		String r = player.getRing() == null ? "미착용" : unit.getRing() +"";
		
		String name = unit.isDead() == true ? "💀"+unit.getName(): unit.getName();
		String temp = String.format("║[Lv.%2d %4s ♥[%3d/%3d] 💧[%3d/%3d](🗡%3d🛡%3d)]\n║파티중 : %s \n"
				+ "║무기 : %s \n║방어구 : %s \n║반지 :  %s", 
				unit.getLevel(), name, unit.getHp(), unit.getMaxHp(), unit.getMp(), unit.getMaxMp(), 
				unit.getPower(), unit.getDefense(), unit.isParty(), w, a, r);

		
		System.out.println("╔══════════════════════════════════════════════╗");
		System.out.println(temp);
		System.out.println("╚══════════════════════════════════════════════╝");
	}
	
	
}
