package jihanki.elements;

import java.util.NoSuchElementException;

public enum EnumDrink {
	ORANGE_JUICE(1, 120, "�I�����W�W���[�X"),
	TOMATO_JUICE(2, 110, "�g�}�g�W���[�X"),
	MONSTER_ENERGY(3, 220, "�����X�^�[�G�i�W�["),
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
	 * �h�����N�ԍ�����h�����N���擾����
	 * @param num
	 * @return
	 * @throws NoSuchElementException �Y������ԍ��̃h�����N���Ȃ��ꍇ
	 */
	public static EnumDrink getByNumber(int num) throws NoSuchElementException {
		for(EnumDrink drink : values()) {
			if(num == drink.getNumber())
				return drink;
		}
		throw new NoSuchElementException("�Y������h�����N�Ȃ�");
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
