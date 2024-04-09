package polyGame.map;

public class DungeonMap {
	private int encount;
	private boolean check;
	private boolean goal;
	
	
	public DungeonMap(int num) {
		this.encount = num;
	}
	
	public int getEncount() {
		return this.encount;
	}
	
	public boolean getCheck() {
		return this.check;
	}
	
	public void setCheck(boolean check) {
		this.check = check;
	}
	
	public boolean getGoal() {
		return this.goal;
	}
	
	public void setGoal(boolean goal) {
		this.goal = goal;
	}
	
	
	@Override
	public String toString() {
		return String.format("%s", check == true ? "⬛ " : "⬜ ");
	}
}
