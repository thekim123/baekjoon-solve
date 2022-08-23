package conditionalstmt;

import java.util.Scanner;

public class No2753 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int year = scanner.nextInt();
		int result = 0;
		
		if (isLeapYear(year)) {
			result = 1;
		}
		System.out.println(result);
	}
	
	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}
}
