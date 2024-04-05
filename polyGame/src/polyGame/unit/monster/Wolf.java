package polyGame.unit.monster;

import polyGame.unit.Unit;

public class Wolf extends Unit{
	public Wolf(int level) {
		name = "늑대";
		init();
	}

	@Override
	public boolean skill(Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void init() {
		this.hp = 80;
		this.maxHp = this.hp;
		this.mp = 50;
		this.maxMp = this.mp;
		
		this.power = 7;
		this.magicPower = 10;
		
		this.defense = 4;
		this.luck = 3;
		this.dex = 1;
		
		if(this.level != 1) {
			settingLevel();
		}
	}

	@Override
	protected void levelUp() {
		this.level++;
		this.maxHp += 7;
		this.hp += 7;
		this.maxMp += 10;
		this.mp += 10;
		this.power += 3;
		this.magicPower += 5;
		this.defense += 2;
		
		if(this.level%2 == 0)
			this.luck++;
		
		if(this.level%3 == 0)
			this.dex++;
	}
}
