package polyGame.item;

import java.util.ArrayList;

public class Shop {
	
	
	private ItemList list = new ItemList();
	private ArrayList<Item> shopList;
	
	public Shop() {
		setShop();
	}

	private void setShop() {
		shopList = list.getShopList();
	}
	
	
	
}
