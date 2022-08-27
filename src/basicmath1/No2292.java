package basicmath1;

import java.util.Scanner;

public class No2292 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int number = scanner.nextInt();

		int sum = 1;
		int result = 0;
		while (true) {
			sum += result * 6;
			if (sum >= number) {
				break;
			}
			result++;
		}

		System.out.println(result + 1);
	}
}
