package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[] sum = new int[300001];
		String arrString = br.readLine();
		st = new StringTokenizer(arrString);
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < arr.length; k++) {
					if (i == j || j == k || i == k) {
						continue;
					}
					sum[arr[i] + arr[j] + arr[k]] = 1;

				}
			}
		}

		for (int i = m; i > 10; i--) {
			if (sum[i] == 1) {
				System.out.println(i);
				break;
			}
		}

	}
}
