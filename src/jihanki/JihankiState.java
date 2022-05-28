package jihanki;

import jihanki.command.EnumProcess;

public class JihankiState {
	/** Œ»Ý‚Ì“Š“ü‹àŠz */
	public static int purchase = 0;
	
	/** ŽŸ‚ÉŽÀs‚·‚éˆ— */
	public static EnumProcess nextProcess = EnumProcess.INSERT_MONEY;
	
	/**
	 * “Š“ü‚³‚ê‚½‹àŠz‚ð‰ÁŽZ‚·‚é
	 * @param money
	 * @return ‰ÁŽZŒã‚Ì‹àŠz
	 */
	public static int insertMoney(int money) {
		// 2000, 5000, 10000‰~ŽD‚ÍŽó‚¯•t‚¯‚È‚¢
		if(money > 2000) {
			System.out.println("2000, 5000, 10000‰~ŽD‚ÍŽg—p‚Å‚«‚Ü‚¹‚ñ");
			return purchase;
		}
		
		// 1, 5‰~‹Ê‚ð’e‚­‚½‚ßA1‚ÌˆÊ‚ðœ‹Ž
		if((money % 10) != 0) {
			System.out.println("1, 5‰~‹Ê‚ÍŽg—p‚Å‚«‚Ü‚¹‚ñ");
			money = (money / 10) * 10;
		}
		
		// “Š“ü‚Å‚«‚é‚Ì‚Í1–œ‰~‚Ü‚Å
		if((purchase + money) > 10000) {
			System.out.println("‚¨‹à‚Í10000‰~‚Ü‚Å‚µ‚©“Š“ü‚Å‚«‚Ü‚¹‚ñ");
			return purchase;
		}
		
		return purchase += money;
	}
	
	/**
	 * “Š“ü‹àŠz‚©‚çƒhƒŠƒ“ƒNw“ü•ª‚Ì‹àŠz‚ðŒ¸ŽZ‚·‚é
	 * @param price
	 * @return
	 * @throws IllegalStateException “Š“ü‹àŠz‚ª•s‘«
	 */
	public static int buyDrink(int price) throws IllegalStateException {
		if(price > purchase)
			throw new IllegalStateException("“Š“ü‹àŠz‚ª•s‘«");
		
		return purchase -= price;
	}
	
	public static int getPurchase() {
		return purchase;
	}
	
	public static void setNextProcess(EnumProcess nextProcess) {
		JihankiState.nextProcess = nextProcess;
	}
	
	public static EnumProcess getNextProcess() {
		return JihankiState.nextProcess;
	}
}
