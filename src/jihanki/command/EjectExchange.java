package jihanki.command;

import java.util.ArrayList;
import java.util.List;

import jihanki.JihankiState;
import jihanki.elements.EnumMoney;

public class EjectExchange implements Process {
	@Override
	public void execute() {
		// ‚¨’Þ‚è‚ð•\Ž¦‚·‚é
		List<String> exchanges = exchange(JihankiState.getPurchase(), EnumMoney.values(), 0, new ArrayList<String>());
		
		System.out.println("‚¨‚Â‚è: ");
		if(exchanges.isEmpty()) {
			System.out.println("‚È‚µ");
		} else {
			exchanges.forEach(System.out::println);
		}

		JihankiState.setNextProcess(EnumProcess.EXIT);
	}
	
	private List<String> exchange(int purchase, EnumMoney[] moneys, int index, List<String> exchanges) {
		if(index >= moneys.length)
			return exchanges;
		
		int money = moneys[index].getValue();
		int amount = purchase / money;
		purchase %= money;
		if(amount != 0)
			exchanges.add(money + " => " + amount);
		
		return exchange(purchase, moneys, index + 1, exchanges);
	}
}
