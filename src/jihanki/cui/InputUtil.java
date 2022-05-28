package jihanki.cui;

import java.util.Scanner;

public class InputUtil {
	public static Scanner scanner = new Scanner(System.in);
	
	/**
	 * プロンプト「> 」を入力したあとに1行の入力を受け付ける
	 * @return
	 */
	public static String InputString() {
		System.out.print("> ");
		return scanner.nextLine();
	}
	
	/**
	 * scannerをクローズする
	 */
	public static void close() {
		scanner.close();
	}
}
