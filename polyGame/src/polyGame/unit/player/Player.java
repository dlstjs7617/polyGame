package polyGame.unit.player;

import polyGame.PrintText;
import polyGame.unit.Unit;

public class Player extends Unit{
	
	private String role;
	
	public Player(String name, int level) {
		super(name,level);
	}

	@Override
	public boolean skill(Unit unit) {
		
		if(this.name.equals("전사")) {
			if(warriorSkill(unit)) {
				return true;
			}else {
				return false;
			}
		}else if(this.name.equals("마법사")) {
			if(wizardSkill(unit)) {
				return true;
			}else {
				return false;
			}
		}else if(this.name.equals("힐러")) {
			if(healerSkill(unit)) {
				return true;
			}else {
				return false;
			}
			
		}
		return false;
	}
	
	
	private boolean warriorSkill(Unit unit) {
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
	
	private boolean wizardSkill(Unit unit) {
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
	
	private boolean healerSkill(Unit unit) {
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
	
	private boolean checkMana(int need) {
		if(this.getMp() < need) {
			System.out.println("╔════════════════════════════════╗");
			System.out.printf("\t %4s는 mp가 부족하다\n",name);
			System.out.println("╚════════════════════════════════╝");
			return false;
		}
		
		return true;
	}
	
}
