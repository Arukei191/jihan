package jihanki.command;

import jihanki.JihankiState;
import jihanki.cui.InputUtil;

public class InsertMoney implements Process {
	@Override
	public void execute() {
		try {
			System.out.println("投入額: " + JihankiState.getPurchase());
			// 入力を受ける
			String input = InputUtil.InputString();
			
			// qで終了
			if(input.equals("q")) {
				JihankiState.setNextProcess(EnumProcess.EJECT_EXCHANGE);
				return;
			}
			
			// mでドリンク選択に移行
			if(input.equals("m")) {
				JihankiState.setNextProcess(EnumProcess.CHOICE_DRINK);
				return;
			}
			
			// 投入されたお金を加算
			int insertedMoney = Integer.parseInt(input);
			if(insertedMoney < 0) {
				System.err.println("正の値を入力してください");
				return;
			}
			JihankiState.insertMoney(insertedMoney);
		} catch(NumberFormatException e) {
			System.err.println("金額: お金を投入 m: ドリンク一覧を表示 q: 終了");
		}
	}
}
