package jihanki;

import jihanki.command.EnumProcess;

public class JihankiState {
	/** ���݂̓������z */
	public static int purchase = 0;
	
	/** ���Ɏ��s���鏈�� */
	public static EnumProcess nextProcess = EnumProcess.INSERT_MONEY;
	
	/**
	 * �������ꂽ���z�����Z����
	 * @param money
	 * @return ���Z��̋��z
	 */
	public static int insertMoney(int money) {
		// 2000, 5000, 10000�~�D�͎󂯕t���Ȃ�
		if(money > 2000) {
			System.out.println("2000, 5000, 10000�~�D�͎g�p�ł��܂���");
			return purchase;
		}
		
		// 1, 5�~�ʂ�e�����߁A1�̈ʂ�����
		if((money % 10) != 0) {
			System.out.println("1, 5�~�ʂ͎g�p�ł��܂���");
			money = (money / 10) * 10;
		}
		
		// �����ł���̂�1���~�܂�
		if((purchase + money) > 10000) {
			System.out.println("������10000�~�܂ł��������ł��܂���");
			return purchase;
		}
		
		return purchase += money;
	}
	
	/**
	 * �������z����h�����N�w�����̋��z�����Z����
	 * @param price
	 * @return
	 * @throws IllegalStateException �������z���s��
	 */
	public static int buyDrink(int price) throws IllegalStateException {
		if(price > purchase)
			throw new IllegalStateException("�������z���s��");
		
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
