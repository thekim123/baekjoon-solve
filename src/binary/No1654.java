package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1654 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] arr = new int[k];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		long answer = search(arr, n);
		System.out.println(answer);

	}

	private static long search(int[] arr, int n) {
		long lt = 1;
		long rt = arr[arr.length - 1];
		long result = 0;

		while (lt <= rt) {
			long mid = (lt + rt) / 2;
			if (count(arr, mid, n)) {
				lt = mid + 1;
				result = mid;
			} else {
				rt = mid - 1;
			}
		}
		return result;
	}

	private static boolean count(int[] arr, long mid, int n) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			count += arr[i] / mid;
		}
		if (count >= n) {
			return true;
		}
		return false;
	}

}
