package array1d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No5597 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[28];
		boolean[] abc = new boolean[31];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			abc[arr[i]] = true;
		}

		for (int i = 1; i < abc.length; i++) {
			if (abc[i] == false) {
				System.out.println(i);
			}
		}
	}
}
