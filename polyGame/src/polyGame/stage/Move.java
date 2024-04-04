package polyGame.stage;

import polyGame.GameManager;
import polyGame.map.MapManager;

public class Move extends Stage{

	private MapManager map = MapManager.getInstance();
	
	@Override
	public boolean update() {
		boolean run = true;
		while(true) {
			System.out.println("======= "+ GameManager.floor +"층 =======");
			map.printMap();
			if(map.move()) {
				return false;
			}else {
				continue;
			}
		}
	}

	@Override
	public void init() {
		
	}

}
