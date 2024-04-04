package polyGame.unit.player;

import polyGame.PrintText;
import polyGame.unit.Unit;

public class Warrior extends Player{

	public Warrior(String name, int level) {
		super(name, level);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void levelUp() {
		
	}
	
	@Override
	public boolean skill(Unit unit) {
		if(!checkMana(20)) {
			return false;
		}
		// 스킬 구현
		setMp(getMp()-20);
		PrintText.printWarriorSkill();
		
		int damage = unit.getHp()-getPower()*3;
		
		PrintText.delay200();
		System.out.println("╔════════════════════════════════╗");
		System.out.println("║	아아 이 서늘하고도 묵직한 감각	 ║");
		System.out.println("║	      2년만 이구만	  	 ║");
		System.out.println("╚════════════════════════════════╝");
		
		PrintText.delay200();
		System.out.println("╔════════════════════════════════╗");
		System.out.printf( "║   전사가 %4s한테 %4d의 데미지	 ║\n", unit.getName(), getPower()*3);
		System.out.println("╚════════════════════════════════╝");
		unit.setHp(damage);
		deadUnit(unit);
		return true;
	}

}
