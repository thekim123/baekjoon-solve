package conditionalstmt;

import java.util.Scanner;

public class No14681 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int result = 4;

		if (a > 0 && b > 0) {
			result = 1;
		} else if (a < 0 && b > 0) {
			result = 2;
		} else if (a < 0 && b < 0) {
			result = 3;
		}
		System.out.println(result);

	}

}
