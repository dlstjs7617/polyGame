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
	private int count;
	
	public Guild() {
		players.add(new Warrior("김전사",1));
		players.get(0).setParty(true);
		players.add(new Wizard("이법사", 1));
		players.get(1).setParty(true);
		players.add(new Healer("박힐러", 1));
		players.get(2).setParty(true);
		count = 3;
	}
	
	public  ArrayList<Unit> getPlayers(){
		return players;
	}
	
	private void GuildMenu() {
		System.out.println("╔═══════════════════════════════════════╗");
		System.out.println("║          [🌟 길드 메뉴 🌟]	    	║");
		System.out.println("╠═══════════════════════════════════════╣");
		System.out.println("║    🛡️1.파티 편성 	🤝2.길드원 모집	║");
		System.out.println("║    ❌3.길드 추방 	🎒4.인벤토리 	║");
		System.out.println("║    🗡5.파티원 장비	🚪0.나가기		║");
		System.out.println("╚═══════════════════════════════════════╝");
		
	}
	
	private void printUnit() {
		System.out.println("╔═════════════════════════════════════════════════════════════╗");
		for(int i=0; i<players.size(); i++) {
			Unit unit = players.get(i);
			unit.printPlayer(unit, i+1);
		}
		System.out.println("╚═════════════════════════════════════════════════════════════╝");
	}
	
	private void selectPartyProcess(int idx) {
		Unit unit = players.get(idx);
		if(!unit.isParty() && PARTY_SIZE == count) {
			System.err.println("최대 편성중이라 불가능합니다.");
			return;
		}
		
		if(!unit.isParty()) {
			unit.setParty(true);
			count++;
			System.out.println("파티원 추가완료");
		}else if(unit.isParty()) {
			unit.setParty(false);
			count--;
			System.out.println("파티원 해제완료");
		}
	}
	
	private void selectParty() {
			printUnit();
			int idx = GameManager.inputString("파티 편성선택")-1;
			if(idx < 0 || idx >= players.size()) {
				System.err.println("유효하지 않은 길드원");
			}
			selectPartyProcess(idx);
	}
	
	public void run() {
		while(true) {
			PrintText.printGuild();
			GuildMenu();
			int sel = GameManager.inputString("선택");
			
			if(sel == LEAVE) {
				if(count == 0) {
					System.err.println("현재 파티가 0명입니다. 한명이상 편성해야합니다.");
					continue;
				}
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
