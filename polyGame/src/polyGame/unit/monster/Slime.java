package polyGame.unit.monster;

import polyGame.item.Item;
import polyGame.unit.Unit;

public class Slime extends Unit{
	public Slime(int level) {
		name = "슬라임";
		this.level = level;
		init();
	}

	@Override
	public boolean skill(Unit unit) {
		if(getMp() < 20) {
			return false;
		}
		setMp(getMp()-20);
		System.out.println("╔════════════════════════════════╗");
		Item armor = unit.getArmor();
		System.out.println("	슬라임의 산성액분출");
		if(armor != null) {
			int damage = getPower() * 2-unit.getDefense()/3-armor.getStatus();
			if(damage <= 0) {
				System.out.println("   " + unit.getName() +"의 방어력이 높아 " + getName() + "의 공격이 막혔다.");
			}else {
				unit.setHp(getHp()-damage);
				System.out.println("   " + getName() +"가 " + unit.getName() + "에게 " + damage +"를 입혔다.");
			}
		}else {
			int damage = getPower()*2 -unit.getDefense();			
			if(damage <= 0) {
				System.out.println("   " + unit.getName() +"의 방어력이 높아 " + getName() + "의 공격이 막혔다.");
			}else {
				unit.setHp(getHp()-damage);
				System.out.println("   " + getName() +"가 " + unit.getName() + "에게 " + damage +"를 입혔다.");
			}
		}
		System.out.println("╚════════════════════════════════╝");
		return true;
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
