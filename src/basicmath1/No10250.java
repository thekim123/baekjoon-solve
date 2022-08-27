package basicmath1;

import java.util.Scanner;

public class No10250 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		for (int i = 0; i < c; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();
			if (n % h == 0) {
				System.out.println(String.format("%d%02.0f", h, Math.ceil((float) n / h)));
			} else {
				System.out.println(String.format("%d%02.0f", n % h, Math.ceil((float) n / h)));
			}
		}
	}

}
