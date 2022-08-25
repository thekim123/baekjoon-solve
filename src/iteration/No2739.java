package iteration;

import java.util.Scanner;

public class No2739 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		for (int i = 1; i < 10; i++) {
			System.out.println(sendMultiple(number, i));
		}
	}

	public static String sendMultiple(int n, int i) {
		return n + " * " + i + " = " + n * i;
	}
}
