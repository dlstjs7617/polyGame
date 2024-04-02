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
	
	private static MapManager instance = new MapManager();
	
	public static MapManager getInstance() {
		return instance;
	}
	
	public void printMap() {
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(y == i && x == j)
					System.out.print("▶");
				else
					System.out.print(map.get(i).get(j));
			}
			System.out.println();
		}
	}
	
	private void setGoal() {
		int rY = ran.nextInt(SIZE-1)+1;
		int rX = ran.nextInt(SIZE-1)+1;
		map.get(rY).get(rX).setGoal(false);
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
		
		if(tempY < 0 || tempY >= SIZE || tempX < 0 || tempY >= SIZE) {
			System.err.println("벽에 박았습니다.");
			return;
		}
		
		y = tempY;
		x = tempX;
		
	}
	
	private boolean enCount() {
		DungeonMap temp = map.get(y).get(x);
		if(temp.getEncount() == 1) {
			temp.setCheck(true);
			return true;
		}else {
			temp.setCheck(true);
			return false;
		}
	}
	
	private boolean move() {
		System.out.println("======이동======");
		System.out.println("     w(↑)     ");
		System.out.println("a(←) s(↓) d(→)");
		System.out.println("==============");
		String input = sc.next();
		
		moving(input);
		
		if(enCount()) {
			return false;
		}else {
			return true;
		}
	}
	
	
	
}
