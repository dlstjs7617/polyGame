package polyGame.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import polyGame.GameManager;
import polyGame.stage.Guild;
import polyGame.unit.Unit;

public class Load {
	
	private String fileName = "save.txt";
	private File file = new File(fileName);
	private FileReader fr;
	private BufferedReader br;
	
	private void setFloorAndMoney(String data) {
		String[] temp = data.split(",");
		GameManager.floor = Integer.parseInt(temp[0]) ;
		Guild.money = Integer.parseInt(temp[1]);
	}
	
	private void playerLoad(String data) {
		ArrayList<Unit> players = new ArrayList<Unit>();
		
		String[] dataArr = data.split("\n");
		for(int i=0; i<dataArr.length; i++) {
			
		}
		
	}
	
	private void inventoryLoad(String data) {
		
	}
	
	public void load() {
		String data = "";
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			if(file.exists()) {
				System.err.println("파일이 없습니다.");
			}else {
				while(br.ready()) {
					data += br.readLine() + "\n"; 
				}
			}
			
			String[] dataArr = data.split("%");
			setFloorAndMoney(dataArr[0]);
			playerLoad(dataArr[1]);
			inventoryLoad(dataArr[2]);
			
			br.close();
			fr.close();
			System.out.println("불러오기 성공");
		} catch (Exception e) {
			System.err.println("불러오기 실패");
			e.printStackTrace();
		}
	}
	
	
}
