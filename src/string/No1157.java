package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1157 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int[] arr = new int[26];
		// a=97
		// A=65
		for (int i = 0; i < input.length(); i++) {
			int alphabetIndex;
			if (input.charAt(i) - 97 >= 0) {
				alphabetIndex = input.charAt(i) - 97;
			} else {
				alphabetIndex = input.charAt(i) - 65;
			}
			arr[alphabetIndex]++;
		}

		int result = 0;
		int temp = -1;
		boolean isDuplicate = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > temp) {
				result = i;
				temp = arr[i];
				isDuplicate = false;
			} else if (arr[i] == temp) {
				isDuplicate = true;
			}
		}
		if (isDuplicate) {
			System.out.println("?");
		} else {
			System.out.println((char) (result + 65));
		}
	}
}
