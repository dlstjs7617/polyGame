package polyGame.unit.player;

import polyGame.PrintText;
import polyGame.unit.Unit;

public class Healer extends Player{

	public Healer(String name, int level) {
		super(name, level);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void levelUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean skill(Unit unit) {
		if(!checkMana(30)) {
			return false;
		}
		setMp(getMp()-30);
		PrintText.printHealerSkill();
		
		int heal = getLevel()*2+getPower()*2;
		PrintText.delay200();
		System.out.println("╔════════════════════════════════╗");
		System.out.println("║		회복		 ║");
		System.out.println("╚════════════════════════════════╝");
		
		PrintText.delay200();
		System.out.println("╔════════════════════════════════╗");
		System.out.printf( "║   힐러가 %4s에게 %d회복		 ║\n", unit.getName(), heal);
		System.out.println("╚════════════════════════════════╝");
		unit.setHp(unit.getHp()+heal);
		deadUnit(unit);
		return true;
	}

	
}
