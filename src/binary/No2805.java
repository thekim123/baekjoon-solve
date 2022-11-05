package binary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2805 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(search(arr, m));

	}

	public static boolean isPossible(int[] arr, int mid, int m) {
		int sum = 0;
		for (int i : arr) {
			if (i - mid > 0) {
				sum += i - mid;
			}

			if (sum >= m) {
				return true;
			}
		}

		return false;
	}

	public static int search(int[] arr, int m) {
		int answer = 0;

		int lt = 0;
		int rt = 1000000000;
		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (isPossible(arr, mid, m)) {
				answer = mid;
				lt = mid + 1;
			} else {
				rt = mid - 1;
			}
		}

		return answer;
	}

}
