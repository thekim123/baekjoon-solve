package numbertheory_combinatorics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2609 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int number;
		if (a > b) {
			number = b;
		} else {
			number = a;
		}

		int result1 = 1;
		for (int i = 2; i <= number; i++) {
			if (b % i == 0 && a % i == 0) {
				result1 = i;
			}
		}

		System.out.println(result1);
		System.out.println(a * b / result1);
	}

}
