package polyGame.item;

public class Item {
	static final int SWORD = 1; // 검(전사)
	static final int SATFF = 2; // 스태프(마법사)
	static final int WAND = 3; // 완드(힐러)
	static final int ARMOR = 4; // 갑옷
	static final int RING = 5; // 장신구
	static final int POTION = 6; // 포션
	
	int type; // 타입
	String name; // 이름
	int status; // 능력
	int price; // 가격
	int ea;	   // 수량
	
	// 아이템 설정 메서드
	public Item(int type, String name, int status, int price) {
		this.type = type;
		this.name = name;
		this.status = status;
		this.price = price;
	}
	
	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getStatus() {
		return status;
	}

	public int getPrice() {
		return price;
	}
	
	public int getEa() {
		return ea;
	}

	public void setEa(int ea) {
		this.ea = ea;
	}


	
	
}
