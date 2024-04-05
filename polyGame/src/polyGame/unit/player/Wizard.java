package polyGame.unit.player;

import polyGame.PrintText;
import polyGame.unit.Unit;

public class Wizard extends Player{

	public Wizard(String name, int level) {
		super(name, level);
		role = "마법사";
		init();
	}

	@Override
	public void init() {
		this.hp = 150;
		this.maxHp = this.hp;
		this.mp = 250;
		this.maxMp = this.mp;
		
		this.power = 10;
		this.magicPower = 20;
		
		this.defense = 5;
		this.luck = 3;
		this.dex = 1;
		
		if(this.level != 1) {
			settingLevel();
		}
	}
	@Override
	protected void levelUp() {
		this.level++;
		this.maxHp += 10;
		this.hp += 7;
		this.maxMp += 10;
		this.mp += 10;
		this.power += 5;
		this.magicPower += 7;
		this.defense += 2;
		
		if(this.level%3 == 0) {
			this.luck++;
			this.dex++;
		}
	}

	public boolean skill(Unit unit) {
		if(!checkMana(50)) {
			return false;
		}
		setMp(getMp()-50);
		PrintText.printWizardSkill();
		int attack = magicPower*2 + power;
		int damage = unit.getHp()-attack;
		PrintText.delay200();
		System.out.println("╔════════════════════════════════╗");
		System.out.println("║		호잇		 ║");
		System.out.println("╚════════════════════════════════╝");
		
		PrintText.delay200();
		System.out.println("╔════════════════════════════════╗");
		System.out.printf( "║  마법사가 %4s한테 %4d의 데미지	 ║\n", unit.name, attack);
		System.out.println("╚════════════════════════════════╝");
		unit.setHp(damage);
		deadUnit(unit);
		return true;
	}

}
