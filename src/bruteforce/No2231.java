package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2231 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int count;
		int maxDecimal = 0;
		int result = 0;
		int temp = 0;

		for (int i = 6; i >= 0; i--) {
			if (n / Math.pow(10, i) < 1) {
				maxDecimal = (int) Math.pow(10, i - 1);
			}
		}
		System.out.println(maxDecimal);

		for (int i = maxDecimal; i < n; i++) {
			result += i;
			for (int j = 6; maxDecimal/Math.pow(10, j) >= 1; j--) {
				result += temp;
				temp = i%maxDecimal;
				System.out.println(temp);
			}
		}
	}

}
