package inputoutput;

import java.util.Scanner;

public class No10869 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int numA = scanner.nextInt();
		int numB = scanner.nextInt();
		System.out.println(numA + numB);
		System.out.println(numA - numB);
		System.out.println(numA * numB);
		System.out.println(numA / numB);
		System.out.println(numA % numB);
		scanner.close();
	}
}
