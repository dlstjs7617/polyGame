package polyGame.unit.player;

import polyGame.unit.Unit;

public abstract class Player extends Unit{
	
	private String role;
	
	public Player(String name, int level) {
		super(name,level);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean skill(Unit unit) {
		return false;
	}
	
	protected boolean checkMana(int need) {
		if(this.getMp() < need) {
			System.out.println("╔════════════════════════════════╗");
			System.out.printf("\t %4s는 mp가 부족하다\n",name);
			System.out.println("╚════════════════════════════════╝");
			return false;
		}
		
		return true;
	}
	
}
