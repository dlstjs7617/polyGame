package polyGame.unit.monster;

import polyGame.unit.Unit;

public class Slime extends Unit{
	public Slime(int level) {
		name = "슬라임";
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
		this.hp = 60;
		this.maxHp = this.hp;
		this.mp = 40;
		this.maxMp = this.mp;
		
		this.power = 5;
		this.magicPower = 5;
		
		this.defense = 6;
		this.luck = 2;
		this.dex = 2;
		
		if(this.level != 1) {
			settingLevel();
		}
	}

	@Override
	protected void levelUp() {
		this.maxHp += 10;
		this.hp += 7;
		this.maxMp += 10;
		this.mp += 10;
		this.power += 2;
		this.magicPower += 2;
		this.defense += 2;
		
		if(this.level%3 == 0) {
			this.dex++;
			this.luck++;			
		}
	}
}
