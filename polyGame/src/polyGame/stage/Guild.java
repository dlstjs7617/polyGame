package polyGame.stage;

import java.util.ArrayList;

import polyGame.unit.Unit;
import polyGame.unit.player.Healer;
import polyGame.unit.player.Warrior;
import polyGame.unit.player.Wizard;

public class Guild{
	
	private ArrayList<Unit> players = new ArrayList<Unit>();
	
	public Guild() {
		players.add(new Warrior("김전사",1));
		players.add(new Wizard("이법사", 1));
		players.add(new Healer("박힐러", 1));
	}
}
