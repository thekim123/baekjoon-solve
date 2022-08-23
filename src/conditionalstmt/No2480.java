package conditionalstmt;

import java.util.Scanner;

public class No2480 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();

		int prizeMoney;
		int sameNumber = 0;

		if (a == b && a == c) {
			sameNumber = a;
			prizeMoney = 10000 + sameNumber * 1000;
		} else if (a == b || a == c) {
			sameNumber = a;
			prizeMoney = 1000 + sameNumber * 100;
		} else if (b == c) {
			sameNumber = b;
			prizeMoney = 1000 + sameNumber * 100;
		} else {
			int temp = a;
			if (temp < b) {
				temp = b;
			} 
			if (temp < c) {
				temp = c;
			}
			
			prizeMoney = temp*100;
		}
		System.out.println(prizeMoney);
	
		scanner.close();
	}
}
