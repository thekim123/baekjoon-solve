package basicmath1;

import java.util.Scanner;

public class No1193 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int number = scanner.nextInt();
		int sum = 0;
		int result = 0;

		for (int i = 0; i < 10000000; i++) {
			sum += i;
			if (sum >= number) {
				result = i;
				break;
			}
		}
		if (result % 2 == 0) {
			System.out.println((result - (sum - number)) + "/" + (1 + sum - number));
		} else {
			System.out.println((1 + sum - number) + "/" + (result - (sum - number)));
		}

	}

}
