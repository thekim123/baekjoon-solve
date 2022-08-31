package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1316 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int countRepeatWord = 0;
		int count = Integer.parseInt(br.readLine());

		for (int j = 0; j < count; j++) {

			String input = br.readLine();
			char[] wordCharset = input.toCharArray();
			boolean[] arr = new boolean[26];

			for (int i = 1; i < wordCharset.length; i++) {
				if (arr[wordCharset[i] - 97] && wordCharset[i] != wordCharset[i - 1]) {
					countRepeatWord++;
					break;
				}
				if (wordCharset[i] != wordCharset[i - 1]) {
					arr[wordCharset[i - 1] - 97] = true;
				}

			}

		}
		System.out.println(count - countRepeatWord);
	}

}
