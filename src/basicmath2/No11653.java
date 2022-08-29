package basicmath2;

import java.util.Scanner;

public class No11653 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int result = n;
		int i = 2;

		while (result!=1) {
			if (result % i == 0) {
				result /= i;
				System.out.println(i);
			}else {
				i++;
			}
		}

	}
}
