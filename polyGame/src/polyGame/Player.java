package polyGame;

public class Player extends Unit{
	public Player(String name, int hp, int mp, int power, int level) {
		super(name,hp,mp,power,level);
	}

	@Override
	public boolean skill() {
		// TODO Auto-generated method stub
		return false;
	}
}
