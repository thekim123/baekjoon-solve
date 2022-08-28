package basicmath1;

import java.util.Scanner;

public class No2839 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int a = 3;
		int b = 5;
		int result = n;

		for (int i = 0; i <= n / a; i++) {
			for (int j = 0; j <= n / b; j++) {
				if (3 * i + 5 * j == n && i + j < result) {
					result = i + j;
				}
			}
		}
		if(result == n) {
			result = -1;
		}
		System.out.println(result);
	}

}
