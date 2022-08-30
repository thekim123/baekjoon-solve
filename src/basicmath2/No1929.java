package basicmath2;

import java.util.Scanner;

public class No1929 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();
		boolean[] arr = new boolean[n + 1];

		for (int i = 2; i < arr.length; i++) {
			arr[i] = true;
		}

		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			if (arr[i]) {
				for (int j = 2; i * j < arr.length; j++) {
					arr[i * j] = false;
				}
			}
		}

		for (int i = 2; i < arr.length; i++) {
			if (arr[i] && i>=m)
				System.out.println(i);
		}

	}

}