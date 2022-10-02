package numbertheory_combinatorics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1934 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = Integer.parseInt(br.readLine());
		int a, b, number;

		for (int i = 0; i < count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			if (a > b) {
				number = b;
			} else {
				number = a;
			}

			int result = 1;
			int temp = 2;
			while (temp <= number) {
				if (a % temp == 0 && b % temp == 0) {
					result = temp;
				}
				temp++;
			}
			
			System.out.println(a * b / result);
		}

	}
}
