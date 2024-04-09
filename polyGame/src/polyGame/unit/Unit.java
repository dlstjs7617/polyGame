package polyGame.unit;

import polyGame.GameManager;
import polyGame.item.Item;
import polyGame.unit.player.Player;

public abstract class Unit {
	
	
	public String name;
	
	// 체력,마나
	protected int hp;
	protected int maxHp;
	protected int mp;
	protected int maxMp;
	
	// 물리공격/마법공격
	protected int power;
	protected int magicPower;
	
	// 방어,치명,회피
	protected int defense;
	protected int luck;
	protected int dex;
	
	// 레벨,경험치
	protected int level;
	protected int maxExp;
	protected int exp;
	
	// 상태이상 true일시 한턴쉬기
	protected boolean turn;
	
	// 사망처리 true일시 사망
	protected boolean isDead;
	
	// 파티 참여 여부 true -> 참여
	protected boolean party;
	
	// 장비
	Item weapon;
	Item armor;
	Item ring;
	
	public Unit() {
		
	}
	public Unit(int level) {
		this.level = level;
		this.maxExp = 40;
	}
	
	public Unit(String name, int level) {
		this.name = name;
		this.level = level;
		this.maxExp = 40;
	}

	public abstract void init();
	
	public String getName() {
		return this.name;
	}
	
	public int getMaxHp() {
		return maxHp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
		if(this.hp > this.maxHp)
			this.hp = this.maxHp;
	}

	public int getMaxMp() {
		return maxMp;
	}

	public int getMp() {
		return mp;
	}
	
	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getPower() {
		return power;
	}

	public int getDefense() {
		return defense;
	}

	public int getLuck() {
		return luck;
	}
	public int getDex() {
		return dex;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public int getMaxExp() {
		return maxExp;
	}

	public int getExp() {
		return exp;
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	public boolean isParty() {
		return party;
	}
	
	public void setParty(boolean party) {
		this.party = party;
	}
	
	public Item getWeapon() {
		return weapon;
	}
	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}
	public Item getArmor() {
		return armor;
	}
	public void setArmor(Item armor) {
		this.armor = armor;
	}
	public Item getRing() {
		return ring;
	}
	public void setRing(Item ring) {
		this.ring = ring;
	}
	
	public abstract boolean skill(Unit unit);
	protected abstract void levelUp();
	
	public void attack(Unit unit) {
		int agi = unit.dex/luck;
		int cri = unit.luck/dex;
		boolean agility = false; 
		boolean critical = false; 
		if(agi >GameManager.ran.nextInt(unit.dex)+unit.dex/2)
			agility = true;
		
		if(cri >GameManager.ran.nextInt(unit.luck)+unit.dex/2)
			critical = true;
		
		if(!agility && !critical || agility && critical) {
			nomalAttack(unit);
		}else if(critical) {
			criticalAttack(unit);
		}else if(agility) {
			System.out.println("╔════════════════════════════════╗");
			System.out.printf("║   %3s가 너무 빨라 공격이 빗나갔다. 	 ║\n",unit.name);
			System.out.println("╚════════════════════════════════╝");
		}		
		deadUnit(unit);
	}
	
	private void nomalAttack(Unit unit) {
		int damage = 0;
		if(getWeapon() != null) {
			damage = power - unit.defense/3 + getWeapon().getStatus();
		}else {
			damage = power - unit.defense/3;
		}
		
		String temp = String.format("%s가 %s를 %d의 공격!", this.name, unit.getName(), damage);
		
		System.out.println("╔════════════════════════════════╗");
		System.out.println("\t" + temp);
		if(unit.defense < this.power) {
			unit.hp -= damage;			
		}else if(damage < 0){
			System.out.println("   "+unit.getName()+" 의 방어력이 높아 공격이 막혔다!");
		}
		System.out.println("╚════════════════════════════════╝");
	}
	
	private void criticalAttack(Unit unit) {
		int fullPower = 0;
		if(getWeapon() != null) {
			fullPower = power - unit.defense/3 + getWeapon().getStatus();
		}else {
			fullPower = power - unit.defense/3;
		}
		String temp = String.format("%s가 %s를 %d의 치명타 공격!", this.name, unit.getName(), fullPower);

		System.out.println("╔════════════════════════════════╗");
		System.out.println("    " + temp);
		
		if(unit.defense < fullPower) {
			unit.hp -= fullPower;
		}else if(fullPower < 0){
			System.out.println("\t" + unit.getName()+" 의 급소를 맞췄지만 방어력이 높아 공격이 안들어갔다!.");
		}
		System.out.println("╚════════════════════════════════╝");
	}

	protected void deadUnit(Unit unit) {
		if(unit.hp <= 0) {
			System.out.println("╔════════════════════════════════╗");
			System.out.println("\t"+ "💀[" + unit.name + "]이 사망했습니다.");
			System.out.println("╚════════════════════════════════╝");
			unit.hp = 0;
			unit.setDead(!isDead);
			int expPlus = unit.level * 5;
			setExp(expPlus);
		}
	}

	protected void setExp(int expPlus) {
		System.out.println("╔════════════════════════════════╗");
		System.out.println("\t경험치 : " + expPlus + " 획득!");
		System.out.println("╚════════════════════════════════╝");
		
		this.exp += expPlus;
		checkExp();
	}
	
	private void checkExp() {
		if(exp >= maxExp) {
			this.level++;
			levelUp();
			System.out.println("╔════════════════════════════════╗");
			System.out.println("\t" + "["+ this.name +"]가 레벨"+ this.level +"이 되었습니다. ");
			System.out.println("╚════════════════════════════════╝");
			exp -= 0;
			maxExp += 20;
		}
		
	}

	protected void settingLevel() {
		int stop = level;
		int cnt = 1;
		while(cnt++ <= stop) {
			levelUp();
		}
	}
}
	