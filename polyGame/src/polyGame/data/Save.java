package polyGame.data;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import polyGame.item.Inventory;
import polyGame.item.Item;
import polyGame.stage.Guild;
import polyGame.unit.Unit;
import polyGame.unit.player.Player;

public class Save {
	public String fileName = "save.txt";
	public File file;
	public FileWriter fw;
	private ArrayList<Unit> players = Guild.getPlayers();
	private Inventory inventory = Inventory.getInstance();
	private ArrayList<Item> itemList = inventory.getItemList();
	public Save() {
		file = new File(fileName);
	}
	
	private String savePlayers() {
		String result = "";
		for(int i=0; i<players.size(); i++) {
			Player player = (Player)players.get(i);
			result += player.getRole()+"/";
			result += player.getName()+"/";
			result += player.getLevel()+"/";
			result += player.isParty()+"`";
			
			if(player.getWeapon() != null) {
				Item item = player.getWeapon();
				result += item.getType()+"/";
				result += item.getName()+"/";
				result += item.getStatus()+"/";
				result += item.getPrice()+"/";
			}else {
				result += "null";				
			}
			result+= "!";
			
			if(player.getArmor() != null) {
				Item item = player.getArmor();
				result += item.getType()+"/";
				result += item.getName()+"/";
				result += item.getStatus()+"/";
				result += item.getPrice()+"/";
			}else {
				result += "null";				
			}
			result+= "!";

			if(player.getRing() != null) {
				Item item = player.getRing();
				result += item.getType()+"/";
				result += item.getName()+"/";
				result += item.getStatus()+"/";
				result += item.getPrice()+"/";
			}else {
				result += "null";	
			}
			result+= "!";
			
			if(i != players.size()-1)
				result += "\n";
		}
		return result;
	}
	
	private String saveItem() {
		String result = "";
		
		for(int i=0; i<itemList.size(); i++	) {
			Item item = itemList.get(i);
			result += item.getType()+"/";
			result += item.getName()+"/";
			result += item.getStatus()+"/";
			result += item.getPrice()+"/";
			result += item.getEa()+"/";
			
			if(i != itemList.size()-1)
				result += "\n";
		}
		
		return result;
	}
	
	public void save() {
		String data = "";
		data += savePlayers() +"%";
		data += saveItem();
		try {
			fw = new FileWriter(file);
			
			fw.write(data);
			
			fw.close();
			System.out.println("저장성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("저장실패");
		}
	}
	
	
}
