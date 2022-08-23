package conditionalstmt;

import java.util.Scanner;

public class No2884 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int hour = scanner.nextInt();
		int minute = scanner.nextInt() - 45;

		if (minute < 0) {
			hour -= 1;
			minute += 60;
		} else if (minute >= 60) {
			minute -= 60;
			hour += 1;
		}
		if (hour > 23) {
			hour -= 24;
		} else if(hour<0) {
			hour+=24;
		}

			System.out.println(hour);
		System.out.println(minute);

	}
}
