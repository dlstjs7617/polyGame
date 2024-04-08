package polyGame.item;

import java.util.ArrayList;

import polyGame.stage.Guild;

public class Inventory {
	public static ArrayList<Item> itemList = new ArrayList<Item>();

	private static final Inventory instance = new Inventory();
    
    private Inventory(){
    	
    }
 
    public static Inventory getInstance(){
        return instance;
    }
	
	
    public ArrayList<Item> getItemList(){
    	return itemList;
    }
    
	public Item clone(Item item) {
		int type = item.getType();
		String name = item.getName();
		int status = item.getStatus();
		int price = item.getPrice();
		
		Item result = new Item(type, name, status, price);
		return result;
	}
	
	public void sellMyItem(int idx) {
		if(idx < 0 || idx >= itemList.size()) {
			System.err.println("없는 아이템");
			return;
		}
		Item item = itemList.get(idx);
		if(item.getEa() <= 1) {
			Guild.money += item.getPrice();
			itemList.remove(item);
		}else {
			Guild.money += item.getPrice();
			item.setEa(item.getEa()-1);
		}
	}
	
	public boolean check(Item item, String message) {
		for(int i=0; i<itemList.size(); i++) {
			Item temp = itemList.get(i);
			
			if(temp.getName().equals(item.getName()) && temp.getType() == item.getType()) {
				if(message.equals("구매")) {
					temp.setEa(temp.getEa()+1);
					Guild.money -= item.getPrice();
					return true;
				}
			}
		}
		
		return false;
	}
	
	public int size() {
		return itemList.size();
	}
	
	public void printItemList() {
		System.out.println("╔══════════════════════════════════════════╗");
		for(int i=0; i<itemList.size(); i++) {
			System.out.println("  " + (i+1) +". " + itemList.get(i));
		}
		System.out.println("╚══════════════════════════════════════════╝");
	}
	
	public void printItemList(int type) {
		System.out.println("╔══════════════════════════════════════════╗");
		for(int i=0; i<itemList.size(); i++) {
			if(itemList.get(i).getType() == type)
				System.out.println("  " + (i+1) +". " + itemList.get(i));
		}
		System.out.println("╚══════════════════════════════════════════╝");
	}
	
	public ArrayList<Integer> selectItemList(int type) {
		ArrayList<Integer> list = new ArrayList<>();
		int cnt = 0;
		System.out.println("╔══════════════════════════════════════════╗");
		for(int i=0; i<itemList.size(); i++) {
			if(itemList.get(i).getType() == type) {
				list.add(i);
				System.out.println("  " + (cnt++ + 1) +". " + itemList.get(i));
			}
		}
		System.out.println("╚══════════════════════════════════════════╝");
		return list;
	}
	
	public void createItem(Item item) {
		itemList.add(item);
		item.setEa(1);
	}

	public Item readItem(int idx) {
		Item item = clone(itemList.get(idx)); 
		return item;
	}
	
}
