package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1920 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			if (count(arr, Integer.parseInt(st.nextToken()))) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}

	}

	public static boolean count(int[] arr, int n) {
		int lt = 0;
		int rt = arr.length - 1;
		int c = 0;
		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (arr[mid] == n) {
				return true;
			}
			if (arr[mid] > n) {
				rt = mid - 1;
			} else {
				lt = mid + 1;
			}
		}
		return false;
	}

}
