package polyGame.unit.player;

import polyGame.PrintText;
import polyGame.unit.Unit;

public class Warrior extends Player{
	
	public Warrior(String name, int level) {
		super(name, level);
		role = "전사";
		init();
	}

	@Override
	public void init() {
		this.hp = 300;
		this.maxHp = this.hp;
		this.mp = 80;
		this.maxMp = this.mp;
		
		this.power = 20;
		this.magicPower = 10;
		
		this.defense = 10;
		this.luck = 3;
		this.dex = 3;
		if(this.level != 1)
			settingLevel();
	}

	@Override
	protected void levelUp() {
		this.level++;
		this.maxHp += 15;
		this.hp += 7;
		this.maxMp += 5;
		this.mp += 10;
		this.power += 7;
		this.magicPower += 3;
		this.defense += 2;
		
		if(this.level%3 == 0) {
			this.luck++;
			this.dex++;
		}
	}
	
	@Override
	public boolean skill(Unit unit) {
		if(!checkMana(20)) {
			return false;
		}
		// 스킬 구현
		setMp(getMp()-20);
		PrintText.printWarriorSkill();
		int attack = power*2 + magicPower;
		int damage = unit.getHp()- attack;
		
		PrintText.delay200();
		System.out.println("╔════════════════════════════════╗");
		System.out.println("║	아아 이 서늘하고도 묵직한 감각	 ║");
		System.out.println("║	      2년만 이구만	  	 ║");
		System.out.println("╚════════════════════════════════╝");
		
		PrintText.delay200();
		System.out.println("╔════════════════════════════════╗");
		System.out.printf( "║   전사가 %4s한테 %4d의 데미지	 ║\n", unit.name, attack);
		System.out.println("╚════════════════════════════════╝");
		unit.setHp(damage);
		deadUnit(unit);
		return true;
	}

}
