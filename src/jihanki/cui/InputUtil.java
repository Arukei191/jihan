package jihanki.cui;

import java.util.Scanner;

public class InputUtil {
	public static Scanner scanner = new Scanner(System.in);
	
	/**
	 * �v�����v�g�u> �v����͂������Ƃ�1�s�̓��͂��󂯕t����
	 * @return
	 */
	public static String InputString() {
		System.out.print("> ");
		return scanner.nextLine();
	}
	
	/**
	 * scanner���N���[�Y����
	 */
	public static void close() {
		scanner.close();
	}
}
