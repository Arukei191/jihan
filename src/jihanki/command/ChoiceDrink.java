package jihanki.command;

import java.util.NoSuchElementException;

import jihanki.JihankiState;
import jihanki.cui.InputUtil;
import jihanki.elements.EnumDrink;

public class ChoiceDrink implements Process {
	@Override
	public void execute() {
		try {
			// ドリンクを選択させる
			printDrink();
			String input = InputUtil.InputString();
			
			// qで終了
			if(input.equals("q")) {
				JihankiState.setNextProcess(EnumProcess.EJECT_EXCHANGE);
				return;
			}
			
			int drinkNum = Integer.parseInt(input);
			EnumDrink drink = EnumDrink.getByNumber(drinkNum);
			
			// ドリンクを購入
			JihankiState.buyDrink(drink.getPrice());
			System.out.println(drink + "を購入しました");
			
		} catch(NumberFormatException e) {
			System.err.println("数値が入力されていません");
		} catch(NoSuchElementException e) {
			System.err.println("ドリンクが選択されていません");
		} catch(IllegalStateException e) {
			System.err.print("投入金額が足りません");
		}
		
		JihankiState.setNextProcess(EnumProcess.INSERT_MONEY);
	}
	
	/**
	 * ドリンク一覧を出力する
	 */
	private void printDrink() {
		System.out.println("番号で選択してください");
		for(EnumDrink drink : EnumDrink.values())
			System.out.println(String.format("[%d] %s %d円", drink.getNumber(), drink, drink.getPrice()));
	}

}
