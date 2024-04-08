package polyGame.stage;

import java.util.ArrayList;

import polyGame.GameManager;
import polyGame.PrintText;
import polyGame.unit.Unit;
import polyGame.unit.player.Healer;
import polyGame.unit.player.Warrior;
import polyGame.unit.player.Wizard;

public class Guild{
	
	private final int PARTY_SIZE = 3;
	
	private final int LEAVE = 0;
	private final int SELETCT = 1;
	private final int JOIN = 2;
	private final int OUT = 3;
	private final int INVENTORY = 4;
	private final int EQUIPMENT = 5;
	
	private ArrayList<Unit> players = new ArrayList<Unit>();
	public static int money = 1000000;
	
	public Guild() {
		players.add(new Warrior("김전사",1));
		players.get(0).setParty(true);
		players.add(new Wizard("이법사", 1));
		players.get(1).setParty(true);
		players.add(new Healer("박힐러", 1));
		players.get(2).setParty(true);
	}
	
	public  ArrayList<Unit> getPlayers(){
		return players;
	}
	
	private void GuildMenu() {
		System.out.println("╔═══════════════════════════════════════╗");
		System.out.println("║          [🌟 길드 메뉴 🌟]	    	║");
		System.out.println("╠═══════════════════════════════════════╣");
		System.out.println("║    🛡️1.파티 편성 	🤝2.길드원 모집	║");
		System.out.println("║    ❌3.길드 추방 	🎒4. 인벤토리	║");
		System.out.println("║    🗡5.파티원 장비	🚪0.나가기		║");
		System.out.println("╚═══════════════════════════════════════╝");
		
	}
	
	private void printUnit() {
		System.out.println("╔═══════════════════════════════════════╗");
		for(int i=0; i<players.size(); i++) {
			Unit unit = players.get(i);
			unit.printUnit(unit);
		}
		System.out.println("╚═══════════════════════════════════════╝");
	}
	
	private void selectParty() {
		while(true) {
			printUnit();
		}
	}
	
	public void run() {
		while(true) {
			PrintText.printGuild();
			GuildMenu();
			int sel = GameManager.inputString("선택");
			
			if(sel == LEAVE) {
				break;				
			}else if(sel == SELETCT) {
				selectParty();
			}else if(sel == JOIN) {
				
			}else if(sel == OUT) {
				
			}else if(sel == INVENTORY) {
				
			}else if(sel == EQUIPMENT) {
				
			}
		}
	}
}
