package polyGame.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import polyGame.GameManager;
import polyGame.item.Inventory;
import polyGame.item.Item;
import polyGame.stage.Guild;
import polyGame.unit.Unit;
import polyGame.unit.player.Healer;
import polyGame.unit.player.Player;
import polyGame.unit.player.Warrior;
import polyGame.unit.player.Wizard;

public class Load {
	
	private String fileName = "save.txt";
	private File file;
	private FileReader fr;
	private BufferedReader br;
	private Inventory inven = Inventory.getInstance();
	private ArrayList<Item> itemList = inven.getItemList();
	private ArrayList<Unit> players = new ArrayList<Unit>();
	
	public Load() {
		file = new File(fileName);
	}
	
	private void setFloorAndMoney(String data) {
		String[] temp = data.split(",");
		System.out.println(temp[0]);
		GameManager.floor = Integer.parseInt(temp[0]);
		Guild.money = Integer.parseInt(temp[1]);
	}
	
	
	
	private void playerLoad(String data) {
		
		String[] dataArr = data.split("\n");
		for(int i=0; i<dataArr.length; i++) {
			Player player = null;

			String[] playerData = dataArr[i].split("`");
			String[] playerArr = playerData[0].split("/");
			
			String role = playerArr[0];
			String name = playerArr[1];
			int level = Integer.parseInt(playerArr[2]);
			boolean party = playerArr[3].equals("true") ? true : false;

			if(role.equals("전사")) {
				player = new Warrior(name, level);
				player.setParty(party);
			}if(role.equals("마법사")) {
				player = new Wizard(name, level);
				player.setParty(party);				
			}if(role.equals("성직자")) {
				player = new Healer(name, level);
				player.setParty(party);
			}
			
			playerArr = playerData[1].split("!");
			System.out.println(Arrays.toString(playerArr));
			// 착용장비 설정
			for(int j=0; j<playerArr.length; j++) {
				if(!playerArr[j].equals("null")) {
					String[] itemData = playerArr[j].split("/");
					int type = Integer.parseInt(itemData[0]);
					String itemName = itemData[1];
					int status = Integer.parseInt(itemData[2]);
					int price = Integer.parseInt(itemData[3]);
					
					Item item = new Item(type, itemName, status, price);	
					
					if(j == 1) {
						player.setWeapon(item);
					}else if(j == 2) {
						player.setArmor(item);						
					}else if(j == 3) {
						player.setRing(item);												
					}
 				}
			}
			players.add(player);
			
		}
		
	}
	
	private void inventoryLoad(String data) {
		String[] dataArr = data.split("\n");
		for(int i=0;i <dataArr.length; i++) {
			String[] itemData = dataArr[i].split("/");
			int type = Integer.parseInt(itemData[0]);
			String name = itemData[1];
			int status = Integer.parseInt(itemData[2]);
			int price = Integer.parseInt(itemData[3]);
			Item item = new Item(type, name, status, price);
			itemList.add(item);
		}
	}
	
	private void setGame() {
		Guild.setPlayer(players);
		inven.setItemList(itemList);
	}
	
	public void load() {
		String data = "";
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			if(!file.exists()) {
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
			setGame();
			
			br.close();
			fr.close();
			System.out.println("불러오기 성공");
		} catch (Exception e) {
			System.err.println("불러오기 실패");
			e.printStackTrace();
		}
	}
	
	
}
