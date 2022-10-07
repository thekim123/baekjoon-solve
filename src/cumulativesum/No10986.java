package cumulativesum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10986 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int[] sum = new int[n + 1];
		int[] arr = new int[n + 1];

		int result = 0;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) % m;
			if (arr[i] == 0) {
				result++;
			}
			sum[i] = sum[i - 1] + arr[i];
		}

		int temp = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				temp = sum[j] - sum[j - i];
				if (temp % m == 0) {
					result++;
				}
			}
		}
		System.out.println(result);

	}
}
