package jihanki;

import jihanki.command.EnumProcess;

public class JihankiState {
	/** 現在の投入金額 */
	public static int purchase = 0;
	
	/** 次に実行する処理 */
	public static EnumProcess nextProcess = EnumProcess.INSERT_MONEY;
	
	/**
	 * 投入された金額を加算する
	 * @param money
	 * @return 加算後の金額
	 */
	public static int insertMoney(int money) {
		// 2000, 5000, 10000円札は受け付けない
		if(money > 2000) {
			System.out.println("2000, 5000, 10000円札は使用できません");
			return purchase;
		}
		
		// 1, 5円玉を弾くため、1の位を除去
		if((money % 10) != 0) {
			System.out.println("1, 5円玉は使用できません");
			money = (money / 10) * 10;
		}
		
		// 投入できるのは1万円まで
		if((purchase + money) > 10000) {
			System.out.println("お金は10000円までしか投入できません");
			return purchase;
		}
		
		return purchase += money;
	}
	
	/**
	 * 投入金額からドリンク購入分の金額を減算する
	 * @param price
	 * @return
	 * @throws IllegalStateException 投入金額が不足
	 */
	public static int buyDrink(int price) throws IllegalStateException {
		if(price > purchase)
			throw new IllegalStateException("投入金額が不足");
		
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
