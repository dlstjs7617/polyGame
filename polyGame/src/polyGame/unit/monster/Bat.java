package polyGame.unit.monster;

import polyGame.item.Item;
import polyGame.unit.Unit;

public class Bat extends Unit{
	public Bat(int level) {
		this.name = "박쥐";
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
		System.out.println("      박쥐의 음파공격");
		if(armor != null) {
			int damage = getPower() * 2 -(unit.getDefense()/3)-(armor.getStatus());
			if(damage <= 0) {
				System.out.println("   " + unit.getName() + "의 방어력이 높아 " + getName() + "의 공격이 막혔다.");
			}else {
				unit.setHp(unit.getHp()-damage);
				System.out.println("   " + getName() +"가 " + unit.getName() + "에게 " + damage +"를 입혔다.");
			}
		}else {
			int damage = getPower()*2 -unit.getDefense();			
			if(damage <= 0) {
				System.out.println("   " + unit.getName() +"의 방어력이 높아 " + getName() + "의 공격이 막혔다.");
			}else {
				unit.setHp(unit.getHp()-damage);
				System.out.println("   " + getName() +"가 " + unit.getName() + "에게 " + damage +"를 입혔다.");
			}
		}
		System.out.println("╚════════════════════════════════╝");
		return true;
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
