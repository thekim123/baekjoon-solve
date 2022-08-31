package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No5622 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int[] arr = new int[input.length()];
		int sum = 0;

		for (int i = 0; i < input.length(); i++) {
			arr[i] = input.charAt(i) - 65;
			if (arr[i] < 15) {
				sum = sum + (arr[i] / 3 + 3);
			} else if ((arr[i] >= 19 && arr[i] < 22)) {
				sum += 9;
			} else if ((arr[i] >= 15 && arr[i] < 19)) {
				sum += 8;
			} else {
				sum += 10;
			}
		}
		System.out.println(sum);

	}

}
