package jihanki.elements;

public enum EnumMoney {
	THOUSAND_YEN(1000),
	FIVE_HUNDRED_YEN(500),
	HUNDRED_YEN(100),
	FIFTY_YEN(50),
	TEN_YEN(10),
	;
	
	int value;
	
	private EnumMoney(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
