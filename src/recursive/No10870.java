package recursive;

import java.util.Scanner;

public class No10870 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int result = calc(n);
		System.out.println(result);
		s.close();

	}

	public static int calc(int n) {
		if (n == 1)
			return 1;
		else if (n == 2)
			return 1;
		else if (n > 2)
			return calc(n - 1) + calc(n - 2);
		else
			return 0;
	}
}
