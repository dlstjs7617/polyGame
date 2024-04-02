package polyGame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MapManager {
	private final int SIZE = 10;
	
	private ArrayList<ArrayList<DungeonMap>> map = new ArrayList<>();
	private Random ran = new Random();
	private Scanner sc = new Scanner(System.in);
	
	private int y = 0;
	private int x = 0;
	
	public MapManager() {
		resetMap();
		map.get(y).get(x).setCheck(true);
	}
	
	private static MapManager instance = new MapManager();
	
	public static MapManager getInstance() {
		return instance;
	}
	
	public void printMap() {
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(y == i && x == j)
					System.out.print("▶ ");
				else
					System.out.print(map.get(i).get(j));
			}
			System.out.println();
		}
	}
	
	private void setGoal() {
		while(true) {
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);
			
			if(rY != 0 && rX != 0) {
				map.get(rY).get(rX).setGoal(true);				
				break;
			}
		}
	}
	
	private void setMap() {
		
		for(int i=0; i<SIZE; i++) {
			ArrayList<DungeonMap> temp = new ArrayList<DungeonMap>();
			for(int j=0; j<SIZE; j++) {
				int rNum = ran.nextInt(5)+1;
				DungeonMap dunMap = new DungeonMap(rNum);
				temp.add(dunMap);
			}
			map.add(temp);
		}
	}
	
	private void resetMap() {
		map.clear();
		setMap();
		setGoal();
	}
	
	private void moving(String input) {
		int tempY = y;
		int tempX = x;
		if(input.equals("w")) {
			tempY--;
		}else if(input.equals("a")) {
			tempX--;
		}else if(input.equals("s")) {
			tempY++;
		}else if(input.equals("d")) {
			tempX++;
		}
		
		if(tempY < 0 || tempY >= SIZE || tempX < 0 || tempX >= SIZE) {
			System.err.println("벽에 박았습니다.");
			return;
		}
		
		y = tempY;
		x = tempX;
		
	}
	
	private boolean enCount() {
		DungeonMap temp = map.get(y).get(x);
		if(temp.getEncount() == 1 && !temp.getCheck()) {
			temp.setCheck(true);
			System.out.println("적들과 조우했다!!");
			GameManager.nextStage = "Battle";
			return true;
		}else {
			temp.setCheck(true);
			return false;
		}
	}
	
	public boolean move() {
		System.out.println("======이동======");
		System.out.println("     w(↑)     ");
		System.out.println("a(←) s(↓) d(→)");
		System.out.println("==============");
		String input = sc.next();
		
		moving(input);
		return checkEncount();
	}
	
	private boolean checkGoal() {
		DungeonMap temp = map.get(y).get(x);
		if(temp.getGoal()) {
			System.out.println("내려가는 계단을 발견했다.");
			GameManager.nextStage = "Lobby";
			GameManager.floor++;
			resetMap();
			return true;
		}else {
			return false;
		}
	}
	
	
	private boolean checkEncount() {
		if(checkGoal()) {
			return true;
		}
		if(enCount()) {
			return true;
		}else {
			return false;
		}
	}
	
}
