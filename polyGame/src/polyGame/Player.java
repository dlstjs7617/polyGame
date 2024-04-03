package polyGame;

public class Player extends Unit{
	public Player(String name, int hp, int mp, int power, int level) {
		super(name,hp,mp,power,level);
	}

	@Override
	public boolean skill(Unit unit) {
		
		if(this.name.equals("전사")) {
			if(warriorSkill(unit)) {
				return true;
			}else {
				return false;
			}
		}else if(this.name.equals("마법사")) {
			if(wizardSkill(unit)) {
				return true;
			}else {
				return false;
			}
		}else if(this.name.equals("힐러")) {
			if(healerSkill(unit)) {
				return true;
			}else {
				return false;
			}
			
		}
		return false;
	}
	
	
	private boolean warriorSkill(Unit unit) {
		if(!checkMana(20)) {
			return false;
		}
		// 스킬 구현
		setMp(getMp()-20);
		PrintText.printWarriorSkill();
		
		return true;
	}
	
	private boolean wizardSkill(Unit unit) {
		if(!checkMana(40)) {
			return false;
		}
		// 스킬 구현
		return true;
	}
	
	private boolean healerSkill(Unit unit) {
		if(!checkMana(30)) {
			return false;
		}
		// 스킬 구현
		return true;
	}
	
	private boolean checkMana(int need) {
		if(this.getMp() < need) {
			System.out.println("╔════════════════════════════════╗");
			System.out.printf("\t %4s는 mp가 부족하다",name);
			System.out.println("╚════════════════════════════════╝");
			return false;
		}
		
		return true;
	}
	
}
