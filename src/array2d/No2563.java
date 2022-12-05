package array2d;

import java.util.Scanner;

public class No2563 {

	static int[][] list = new int[100][100];
	static int area;

	public static void main(String[] args) {
		setVariable();
		int answer = calculateArea();
		System.out.println(answer);
	}

	public static void setVariable() {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			paintArea(x, y);
		}

	}

	public static void paintArea(int x, int y) {
		for (int i = x; i < x + 10; i++) {
			for (int j = y; j < y + 10; j++) {
				list[i][j] = 1;
			}
		}

	}

	public static int calculateArea() {
		int result = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (list[i][j] == 1) {
					result++;
				}
			}
		}

		return result;
	}
}
