package iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1110 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String number = br.readLine();
		String calc = number;
		Integer finalNumber = 0;
		String a = null;
		int ten = 0;
		int count = 0;
		while (count == 0 || Integer.parseInt(number) != finalNumber) {
			finalNumber = Integer.parseInt(number);
			count++;
			if (calc.length() == 1) {
				ten = calc.charAt(0) - 48;
				a = String.valueOf((calc.charAt(0) - 48));
			} else {
				ten = calc.charAt(1) - 48;
				a = String.valueOf(((calc.charAt(0) - 48) + (ten)) % 10);
			}
			System.out.println(ten);
			System.out.println(a);
			finalNumber = Integer.parseInt(ten + a);
			System.out.println(finalNumber);
			calc = String.valueOf(finalNumber);
			System.out.println("---");
		}
		System.out.println(count);
	}

}
