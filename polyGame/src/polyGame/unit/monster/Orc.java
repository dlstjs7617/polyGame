package polyGame.unit.monster;

import polyGame.item.Item;
import polyGame.unit.Unit;

public class Orc extends Unit{
	public Orc(int level) {
		name = "오크";
		this.level = level;
		init();
	}

	@Override
	public boolean skill(Unit unit) {
		if(getMp() < 30) {
			return false;
		}
		setMp(getMp()-30);
		System.out.println("╔════════════════════════════════╗");
		Item armor = unit.getArmor();
		System.out.println("	오크의 바위던지기");
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
		this.maxHp += 10;
		this.hp += 7;
		this.maxMp += 10;
		this.mp += 10;
		this.power += 4;
		this.magicPower += 4;
		this.defense += 3;
		
		if(this.level%3 == 0) {
			this.dex++;
			this.luck++;			
		}
	}
}
