package polyGame.item;

import java.util.ArrayList;

public class ItemList {
	
	private ArrayList<Item> shopList = new ArrayList<Item>();
	public ItemList() {
		setList();
	}
	
	private void setList() {
		createSword();
		createSatff();
		createWand();
		createArmor();
		createRing();
		createPotion();
	}
	
	public ArrayList<Item> getShopList(){
		return shopList;
	}
	
	private void createSword() {
		int type = 1;
		String name = "철검";
		int status = 10;
		int price = 600;
		
		Item item = new Item(type, name, status, price);
		shopList.add(item);
		
		type = 1;
		name = "은빛 검";
		status = 20;
		price = 2000;
		item = new Item(type, name, status, price);
		shopList.add(item);
		
		type = 1;
		name = "폭풍 검";
		status = 35;
		price = 5000;
		item = new Item(type, name, status, price);
		shopList.add(item);

		type = 1;
		name = "에테리얼 소울검";
		status = 50;
		price = 15000;
		item = new Item(type, name, status, price);
		shopList.add(item);
				
		type = 1;
		name = "드래곤 슬레이어";
		status = 100;
		price = 40000;
		item = new Item(type, name, status, price);
		shopList.add(item);
		
		type = 1;
		name = "테스트용 돈털이아이템";
		status = 100;
		price = 1000000;
		item = new Item(type, name, status, price);
		shopList.add(item);
	}
	
	private void createSatff() {
		int type = 2;
		String name = "떡갈나무 지팡이";
		int status = 10;
		int price = 600;
		
		Item item = new Item(type, name, status, price);
		shopList.add(item);
		
		type = 2;
		name = "루비 지팡이";
		status = 20;
		price = 2000;
		item = new Item(type, name, status, price);
		shopList.add(item);
		
		type = 2;
		name = "고대의 지팡이";
		status = 35;
		price = 5000;
		item = new Item(type, name, status, price);
		shopList.add(item);

		type = 2;
		name = "천상의 별 지팡이";
		status = 50;
		price = 15000;
		item = new Item(type, name, status, price);
		shopList.add(item);
				
		type = 2;
		name = "세계수의 가지";
		status = 100;
		price = 40000;
		item = new Item(type, name, status, price);
		shopList.add(item);
	}
	
	private void createWand() {
		int type = 3;
		String name = "빛의 라이트 완드";
		int status = 10;
		int price = 600;
		
		Item item = new Item(type, name, status, price);
		shopList.add(item);
		
		type = 3;
		name = "성자의 완드";
		status = 20;
		price = 2000;
		item = new Item(type, name, status, price);
		shopList.add(item);
		
		type = 3;
		name = "고대의 에이션트 완드";
		status = 35;
		price = 5000;
		item = new Item(type, name, status, price);
		shopList.add(item);

		type = 3;
		name = "혼돈의 카오스 완드";
		status = 50;
		price = 15000;
		item = new Item(type, name, status, price);
		shopList.add(item);
				
		type = 3;
		name = "용용이 완드";
		status = 100;
		price = 40000;
		item = new Item(type, name, status, price);
		shopList.add(item);
	}
	
	private void createArmor() {
		int type = 4;
		String name = "철 아머";
		int status = 10;
		int price = 600;
		
		Item item = new Item(type, name, status, price);
		shopList.add(item);
		
		type = 4;
		name = "풀 플레이트 아머";
		status = 20;
		price = 2000;
		item = new Item(type, name, status, price);
		shopList.add(item);
		
		type = 4;
		name = "신령의 갑옷 ";
		status = 35;
		price = 5000;
		item = new Item(type, name, status, price);
		shopList.add(item);

		type = 4;
		name = "천둥의 갑주";
		status = 50;
		price = 15000;
		item = new Item(type, name, status, price);
		shopList.add(item);
				
		type = 4;
		name = "신의 빛나는 갑옷";
		status = 100;
		price = 40000;
		item = new Item(type, name, status, price);
		shopList.add(item);
	}
	
	private void createRing() {
		int type = 5;
		String name = "황금 반지";
		int status = 1;
		int price = 600;
		
		Item item = new Item(type, name, status, price);
		shopList.add(item);
		
		type = 5;
		name = "행운의 반지";
		status = 2;
		price = 2000;
		item = new Item(type, name, status, price);
		shopList.add(item);
		
		type = 5;
		name = "자연의 반지";
		status = 3;
		price = 5000;
		item = new Item(type, name, status, price);
		shopList.add(item);

		type = 5;
		name = "고대의 반지";
		status = 4;
		price = 15000;
		item = new Item(type, name, status, price);
		shopList.add(item);
				
		type = 5;
		name = "천상의 별빛 반지";
		status = 5;
		price = 40000;
		item = new Item(type, name, status, price);
		shopList.add(item);
	}
	

	private void createPotion() {
		int type = 6;
		String name = "HP포션";
		int status = 50;
		int price = 150;
		
		Item item = new Item(type, name, status, price);
		shopList.add(item);
		
		type = 6;
		name = "MP포션";
		status = 50;
		price = 200;
		item = new Item(type, name, status, price);
		shopList.add(item);
		
	
	}
	
}
