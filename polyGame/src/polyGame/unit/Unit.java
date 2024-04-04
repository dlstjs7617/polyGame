package polyGame.unit;

import java.util.Random;

public abstract class Unit {
	
	private Random ran = new Random();
	
	public String name;
	
	protected int maxHp;
	protected int hp;
	protected int maxMp;
	protected int mp;
	protected int power;
	protected int defense;
	protected int luck;
	protected int dex;
	protected int level;
	protected int maxExp;
	protected int exp;
	
	protected boolean turn;
	protected boolean isDead;
	
	public Unit() {
		
	}
	
	public Unit(String name, int level) {
		this.name = name;
		this.level = level;
		this.maxExp = 50;
	}

	public abstract void init();
	
	public String getName() {
		return this.name;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	
	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public int getMaxHp() {
		return maxHp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
		if(this.hp > this.maxHp)
			this.hp = this.maxHp;
	}

	public int getHp() {
		return hp;
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

	public int getMaxExp() {
		return maxExp;
	}

	public int getExp() {
		return exp;
	}

	public boolean isDead() {
		return isDead;
	}
	
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	

	public abstract boolean skill(Unit unit);
	
	public void attack(Unit unit) {
		
		boolean agility = ran.nextInt(3)+unit.dex > ran.nextInt(luck*3+1)+10 ? true : false;
		boolean critical = ran.nextInt(luck+1) > unit.dex*3 ? true : false;
		
		if(!agility && !critical) {
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
		if(unit.defense < this.power) {
			unit.hp -= this.power-unit.defense;
			
			String temp = String.format("%s가 %s를 %d의 공격!", this.name, unit.getName(), power-unit.defense);

			System.out.println("╔════════════════════════════════╗");
			System.out.println("\t" + temp);
			System.out.println("╚════════════════════════════════╝");
		}else if(unit.defense >= this.power){
			System.out.println("╔════════════════════════════════╗");
			System.out.println("   "+unit.getName()+" 의 방어력이 높아 공격이 막혔다!");
			System.out.println("╚════════════════════════════════╝");
		}
	}
	
	private void criticalAttack(Unit unit) {
		int fullPower = power*2;
		if(unit.defense < fullPower) {
			unit.hp -= fullPower-unit.defense;

			String temp = String.format("%s가 %s를 %d의 치명타 공격!", this.name, unit.getName(), fullPower-unit.defense);
			
			System.out.println("╔════════════════════════════════╗");
			System.out.println("    " + temp);
			System.out.println("╚════════════════════════════════╝");
		}else if(unit.defense >= fullPower){
			System.out.println("╔════════════════════════════════╗");
			System.out.println("\t" + unit.getName()+" 의 급소를 맞췄지만 방어력이 높아 공격이 안들어갔다!.");
			System.out.println("╚════════════════════════════════╝");
		}
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
			++this.level;
			System.out.println("╔════════════════════════════════╗");
			System.out.println("\t" + "["+ this.name +"]가 레벨"+ this.level +"이 되었습니다. ");
			System.out.println("╚════════════════════════════════╝");
			exp -= maxExp;
			maxExp += 20;
			levelUp();
		}
		
	}

	protected abstract void levelUp();
	
}
	