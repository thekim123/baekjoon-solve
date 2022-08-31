package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2941 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String croatian = br.readLine();
		int countWord = 0;

		char[] temp = croatian.toCharArray();

		for (int i = 0; i < temp.length - 2; i++) {
			if (temp[i] == 'd' && temp[i + 1] == 'z' && temp[i + 2] == '=') {
				countWord ++;
				temp[i] = temp[i + 1] = temp[i + 2] = '.';
				i += 2;
			}
		}

		for (int i = 0; i < temp.length - 1; i++) {
			if (isTwoCharCroatic(temp[i], temp[i+1])) {
				countWord++;
				temp[i] = temp[i+1] = '.';
				i++;
			}
		}
		
		for (int i = 0; i < temp.length; i++) {
			if(temp[i]!='.') {
				countWord++;
			}
		}

		System.out.println(countWord);

	}

	static boolean isTwoCharCroatic(char firstChar, char secondChar) {
		boolean result = false;
		if ((firstChar == 'c' && secondChar == '=')
				||(firstChar == 'c' && secondChar == '-')
				||(firstChar == 'd' && secondChar == '-')
				||(firstChar == 'l' && secondChar == 'j')
				||(firstChar == 'n' && secondChar == 'j')
				||(firstChar == 's' && secondChar == '=')
				||(firstChar == 'z' && secondChar == '=')) {
			result = true;
		}
		return result;
	}
}
