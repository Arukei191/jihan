package jihanki.elements;

import java.util.NoSuchElementException;

public enum EnumDrink {
	ORANGE_JUICE(1, 120, "オレンジジュース"),
	TOMATO_JUICE(2, 110, "トマトジュース"),
	MONSTER_ENERGY(3, 220, "モンスターエナジー"),
	;
	
	int number;
	int price;
	String name;
	
	private EnumDrink(int number, int price, String name) {
		this.number = number;
		this.price = price;
		this.name = name;
	}
	
	/**
	 * ドリンク番号からドリンクを取得する
	 * @param num
	 * @return
	 * @throws NoSuchElementException 該当する番号のドリンクがない場合
	 */
	public static EnumDrink getByNumber(int num) throws NoSuchElementException {
		for(EnumDrink drink : values()) {
			if(num == drink.getNumber())
				return drink;
		}
		throw new NoSuchElementException("該当するドリンクなし");
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
