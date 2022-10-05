package cumulativesum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2559 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n + 1];
		int[] sum = new int[n + 1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i - 1] + arr[i];
		}

		int result = Integer.MIN_VALUE; // -273 * k = 절대온도 * k
		for (int i = 0; i < sum.length-k; i++) {
			int temp = sum[i+k]-sum[i];
			if (temp > result) {
				result = temp;
			}
		}
		
		System.out.println(result);
	}

}
