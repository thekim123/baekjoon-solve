package backtracking;

import java.util.Scanner;

public class No15649 {

	private static int n;
	private static int m;
	private static int[] ch;
	private static StringBuilder answer;

	public static void main(String[] args) {
		setVariable();
		dfs(1);
	}

	public static void setVariable() {
		answer = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		ch = new int[n + 1];
		sc.close();
	}

	public static void dfs(int l) {
		if (l == m + 1) {
			for (int i = 0; i < ch.length; i++) {
				if (ch[i] == 1) {
					answer.append(i + " ");
				}
			}

			System.out.println(answer.toString());
			answer = new StringBuilder();

		} else {
			ch[l] = 1;
			dfs(l + 1);
			ch[l] = 0;
			dfs(l + 1);
		}
	}

}
