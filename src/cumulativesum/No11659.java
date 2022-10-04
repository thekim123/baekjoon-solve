package cumulativesum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11659 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n+1];
		int[] s = new int[n+1];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			s[i] = s[i-1]+arr[i];
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int lt = Integer.parseInt(st.nextToken());
			int rt = Integer.parseInt(st.nextToken());
			sb.append(s[rt]-s[lt-1]+"\n");
		}
		
		System.out.println(sb.toString());
	}
}
