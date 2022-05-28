package jihanki.command;

import java.util.NoSuchElementException;

import jihanki.JihankiState;
import jihanki.cui.InputUtil;
import jihanki.elements.EnumDrink;

public class ChoiceDrink implements Process {
	@Override
	public void execute() {
		try {
			// �h�����N��I��������
			printDrink();
			String input = InputUtil.InputString();
			
			// q�ŏI��
			if(input.equals("q")) {
				JihankiState.setNextProcess(EnumProcess.EJECT_EXCHANGE);
				return;
			}
			
			int drinkNum = Integer.parseInt(input);
			EnumDrink drink = EnumDrink.getByNumber(drinkNum);
			
			// �h�����N���w��
			JihankiState.buyDrink(drink.getPrice());
			System.out.println(drink + "���w�����܂���");
			
		} catch(NumberFormatException e) {
			System.err.println("���l�����͂���Ă��܂���");
		} catch(NoSuchElementException e) {
			System.err.println("�h�����N���I������Ă��܂���");
		} catch(IllegalStateException e) {
			System.err.print("�������z������܂���");
		}
		
		JihankiState.setNextProcess(EnumProcess.INSERT_MONEY);
	}
	
	/**
	 * �h�����N�ꗗ���o�͂���
	 */
	private void printDrink() {
		System.out.println("�ԍ��őI�����Ă�������");
		for(EnumDrink drink : EnumDrink.values())
			System.out.println(String.format("[%d] %s %d�~", drink.getNumber(), drink, drink.getPrice()));
	}

}
