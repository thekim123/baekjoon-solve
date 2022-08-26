package array1d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No3052 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] restArr = new int[42];
		int number;
		int sum = 0;

		for (int i = 0; i < 10; i++) {
			number = Integer.parseInt(br.readLine()) % 42;
			restArr[number] = 1;
		}
		for (int i : restArr) {
			sum += i;
		}
		System.out.println(sum);

	}

}
