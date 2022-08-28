package basicmath1;

import java.util.Scanner;

public class No2775 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		int n;
		int k;

		int[][] result;

		for (int z = 0; z < count; z++) {
			n = scanner.nextInt();
			k = scanner.nextInt();
			result = new int[n + 1][k];
			
			for (int i = 0; i < k; i++) {
				result[0][i] = i + 1;
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < k; j++) {
					for (int x = 0; x <= j; x++) {
						result[i][j] += result[i - 1][x];
					}
				}
			}
			System.out.println(result[n][k - 1]);
		}

	}
}
