package basicmath2;

import java.util.Scanner;

public class No4948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = 1;
		while (n != 0) {
			n = sc.nextInt();
			if (n == 0) {
				break;
			}
			int result = 0;
			boolean[] arr = new boolean[2 * n + 1];

			for (int i = 2; i < arr.length; i++) {
				arr[i] = true;
			}

			for (int i = 2; i <= (int) Math.sqrt(2 * n); i++) {
				if (arr[i]) {
					for (int j = 2; i * j < arr.length; j++) {
						arr[i * j] = false;
					}
				}
			}

			for (int i = 2; i < arr.length; i++) {
				if (arr[i] && i > n) {
					result++;
				}
			}
			System.out.println(result);
		}
	}

}
