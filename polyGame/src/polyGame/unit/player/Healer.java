package polyGame.unit.player;

import polyGame.PrintText;
import polyGame.unit.Unit;

public class Healer extends Player{

	public Healer(String name, int level) {
		super(name, level);
		role = "성직자";
		init();
	}

	@Override
	public void init() {
		this.hp = 180;
		this.maxHp = this.hp;
		this.mp = 200;
		this.maxMp = this.mp;
		
		this.power = 12;
		this.magicPower = 15;
		
		this.defense = 7;
		this.luck = 4;
		this.dex = 3;
		
		if(this.level != 1) {
			settingLevel();
		}
	}

	
	@Override
	protected void levelUp() {
		this.maxHp += 7;
		this.hp += 7;
		this.maxMp += 10;
		this.mp += 10;
		this.power += 5;
		this.magicPower += 5;
		this.defense += 2;
		
		if(this.level%2 == 0) {
			this.luck++;
			this.dex++;
		}
	}

	@Override
	public boolean skill(Unit unit) {
		if(!checkMana(30)) {
			return false;
		}
		setMp(mp-30);
		PrintText.printHealerSkill();
		
		int heal = magicPower+power + getWeapon().getStatus();
		PrintText.delay200();
		System.out.println("╔════════════════════════════════╗");
		System.out.println("║		회복		 ║");
		System.out.println("╚════════════════════════════════╝");
		
		PrintText.delay200();
		System.out.println("╔════════════════════════════════╗");
		System.out.printf( "║   힐러가 %4s에게 %d회복		 ║\n", unit.name, heal);
		System.out.println("╚════════════════════════════════╝");
		unit.setHp(unit.getHp()+heal);
		deadUnit(unit);
		return true;
	}

}
