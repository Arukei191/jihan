package jihanki.command;

import jihanki.JihankiState;
import jihanki.cui.InputUtil;

public class InsertMoney implements Process {
	@Override
	public void execute() {
		try {
			System.out.println("�����z: " + JihankiState.getPurchase());
			// ���͂��󂯂�
			String input = InputUtil.InputString();
			
			// q�ŏI��
			if(input.equals("q")) {
				JihankiState.setNextProcess(EnumProcess.EJECT_EXCHANGE);
				return;
			}
			
			// m�Ńh�����N�I���Ɉڍs
			if(input.equals("m")) {
				JihankiState.setNextProcess(EnumProcess.CHOICE_DRINK);
				return;
			}
			
			// �������ꂽ���������Z
			int insertedMoney = Integer.parseInt(input);
			if(insertedMoney < 0) {
				System.err.println("���̒l����͂��Ă�������");
				return;
			}
			JihankiState.insertMoney(insertedMoney);
		} catch(NumberFormatException e) {
			System.err.println("���z: �����𓊓� m: �h�����N�ꗗ��\�� q: �I��");
		}
	}
}
