package function;

import java.util.Scanner;

public class No1065 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();

		int hundredNo = 0;
		int tenNo = 0;
		int oneNo = 0;

		int result = number;
		if (number >= 100) {
			result = 99;
			
			for (int i = 100; i <= number; i++) {
				hundredNo = i / 100;
				tenNo = i / 10 - hundredNo * 10;
				oneNo = i % 10;

				if (hundredNo - tenNo == tenNo - oneNo) {
					result += 1;
				}
			}
		}
		System.out.println(result);

	}

}
