package basicmath2;

import java.util.ArrayList;
import java.util.Scanner;

public class No1929 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();

		int[] arr = new int[n + 1];
		ArrayList<Integer> primeNumber = new ArrayList<Integer>();

		for (int i = m; i <= n; i++) {

		}
		arr[1] = -1;
		for (

				int i = m; i <= n; i++) {
			if (arr[i] != -1) {
				System.out.println(i);
			}

		}

	}

}