package binary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2512 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] reqBudget = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < reqBudget.length; i++) {
			reqBudget[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(reqBudget);

		long totalBudget = Long.parseLong(br.readLine());
		System.out.println(binarySearch(totalBudget, reqBudget));
	}

	public static int binarySearch(long totalBudget, int[] reqBudget) {
		int answer = 0;
		int lt = 0;
		int rt = reqBudget[reqBudget.length - 1];

		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (isPossible(mid, totalBudget, reqBudget)) {
				lt = mid + 1;
				answer = mid;
			} else {
				rt = mid - 1;
			}
		}

		return answer;
	}

	public static boolean isPossible(int budget, long totalBudget, int[] reqBudget) {
		boolean result = false;
		for (int i : reqBudget) {
			if (i > budget) {
				totalBudget -= budget;
			} else {
				totalBudget -= i;
			}
		}

		if (totalBudget >= 0) {
			result = true;
		}
		return result;
	}
}
