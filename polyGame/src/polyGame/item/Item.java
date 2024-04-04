package polyGame.item;

public class Item {
	static final int WEAPON = 1; // 무기
	static final int ARMOR = 2; // 갑옷
	static final int RING = 3; // 장신구
	static final int POTION = 4; // 포션
	
	int kind; // 종류
	String name; // 이름
	int status; // 능력
	int price; // 가격
	int ea;	   // 수량
	
	// 아이템 설정 메서드
	public void setItem(int kind, String name, int status, int price) {
		this.kind = kind;
		this.name = name;
		this.status = status;
		this.price = price;
	}

}
