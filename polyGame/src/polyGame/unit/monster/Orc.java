package polyGame.unit.monster;

import polyGame.unit.Unit;

public class Orc extends Unit{
	public Orc(int level) {
		name = "오크";
		init();
	}

	@Override
	public boolean skill(Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void init() {
		this.hp = 100;
		this.maxHp = this.hp;
		this.mp = 100;
		this.maxMp = this.mp;
		
		this.power = 10;
		this.magicPower = 8;
		
		this.defense = 10;
		this.luck = 2;
		this.dex = 2;
		
		if(this.level != 1) {
			settingLevel();
		}
	}

	@Override
	protected void levelUp() {
		this.level++;
		this.maxHp += 10;
		this.maxMp += 10;
		this.power += 4;
		this.magicPower += 4;
		this.defense += 3;
		
		if(this.level%2 == 0)
		
		if(this.level%3 == 0) {
			this.dex++;
			this.luck++;			
		}
	}
}
