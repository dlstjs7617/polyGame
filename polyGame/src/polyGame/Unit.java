package polyGame;

public abstract class Unit {
	
	private String name;
	
	private int maxHp;
	private int hp;
	private int maxMp;
	private int mp;
	private int power;
	private int defense;
	private int luck;
	private int dex;
	private int level;
	private int maxExp;
	private int exp;
	
	private boolean turn;
	private boolean isDead;
	
	public Unit() {
		this.maxExp = 100;
	}
	
	public Unit(String name, int hp, int mp, int power, int level) {
		this.name = name;
		this.maxHp = hp;
		this.hp = hp;
		this.maxMp = mp;
		this.mp = mp;
		this.power = power;
		this.level = level;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public void init(int hp, int mp, int power, int level) {
		this.maxHp = hp;
		this.hp = hp;
		this.maxMp = mp;
		this.mp = mp;
		this.power = power;
		this.level = level;
	}
	
	public void init(int defense, int luck, int dex) {
		this.defense = defense;
		this.luck = luck;
		this.dex = dex;
	}
	
	
	public void attack(Unit unit) {
		unit.hp -= power;
		
		if(unit.hp <= 0) {
			System.out.println("[" + unit.name + "]이 사망했습니다.");
			
			int expPlus = unit.level * 5;
			setExp(expPlus);
		}
	}
	
	private void levelUp() {
		this.power += 3;
		this.defense += 2;
		this.luck++;
		this.maxHp += 10; 
		this.maxMp += 5; 
	}
	private void setExp(int expPlus) {
		System.out.println("경험치 : " + expPlus + " 획득!");
		this.exp += expPlus;
		
		if(exp >= maxExp) {
			++this.level;
			System.out.println("["+ this.name +"]가 레벨"+ this.level +"이 되었습니다. ");
			exp -= maxExp;
			maxExp += 20;
			levelUp();
		}
		
	}
	
}
	