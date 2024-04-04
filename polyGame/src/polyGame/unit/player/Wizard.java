package polyGame.unit.player;

import polyGame.PrintText;
import polyGame.unit.Unit;

public class Wizard extends Player{

	public Wizard(String name, int level) {
		super(name, level);
	}
	
	@Override
	protected void levelUp() {
	}
	
	public boolean skill(Unit unit) {
		if(!checkMana(40)) {
			return false;
		}
		setMp(getMp()-50);
		PrintText.printWizardSkill();
		
		int damage = unit.getHp()-getPower()*3;
		PrintText.delay200();
		System.out.println("╔════════════════════════════════╗");
		System.out.println("║		호잇		 ║");
		System.out.println("╚════════════════════════════════╝");
		
		PrintText.delay200();
		System.out.println("╔════════════════════════════════╗");
		System.out.printf( "║  마법사가 %4s한테 %4d의 데미지	 ║\n", unit.getName(), getPower()*3);
		System.out.println("╚════════════════════════════════╝");
		unit.setHp(damage);
		deadUnit(unit);
		return true;
	}


}
