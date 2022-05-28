package jihanki;

import java.util.HashMap;
import java.util.Map;

import jihanki.command.ChoiceDrink;
import jihanki.command.EjectExchange;
import jihanki.command.EnumProcess;
import jihanki.command.InsertMoney;
import jihanki.command.Process;
import jihanki.cui.InputUtil;

public class Main {

	public static void main(String[] args) {
		// プロセスのインスタンスをマッピング
		Map<EnumProcess, Process> proccesses = new HashMap<>();
		proccesses.put(EnumProcess.INSERT_MONEY, new InsertMoney());
		proccesses.put(EnumProcess.CHOICE_DRINK, new ChoiceDrink());
		proccesses.put(EnumProcess.EJECT_EXCHANGE, new EjectExchange());
		
		try {
			while(JihankiState.getNextProcess() != EnumProcess.EXIT)
				proccesses.get(JihankiState.getNextProcess()).execute();
		
		} finally {
			InputUtil.close();
		}
	}

}
