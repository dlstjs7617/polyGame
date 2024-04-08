package polyGame.unit.monster;

import polyGame.unit.Unit;

public class Bat extends Unit{
	public Bat(int level) {
		this.name = "박쥐";
		this.level = level;
		init();
	}

	@Override
	public boolean skill(Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void init() {
		this.hp = 70;
		this.maxHp = this.hp;
		this.mp = 40;
		this.maxMp = this.mp;
		
		this.power = 5;
		this.magicPower = 6;
		
		this.defense = 2;
		this.luck = 2;
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
		this.power += 2;
		this.magicPower += 5;
		this.defense += 2;
		
		if(this.level%2 == 0)
			this.dex++;
		
		if(this.level%3 == 0)
			this.luck++;
	}
}
