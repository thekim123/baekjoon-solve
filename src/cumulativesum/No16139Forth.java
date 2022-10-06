package cumulativesum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16139Forth {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] input = br.readLine().toCharArray();
		int count = Integer.parseInt(br.readLine());

		int[][] sum = new int[input.length + 1][26];
		for (int i = 1; i < input.length; i++) {
			for (int j = 0; j < 26; j++) {
				sum[i][j] = sum[i-1][j];
			}
			sum[i][input[i-1] - 97] = sum[i - 1][input[i-1] - 97] + 1;
		}
		
		for (int i = 0; i < sum.length; i++) {
			System.out.print(i+ " : ");
			for (int j = 0; j < 26; j++) {
				System.out.print(sum[i][j] + " ");
			}
			System.out.println();
		}
		
		for (int i = 0; i < count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			char c = st.nextToken().charAt(0);
			int lt = Integer.parseInt(st.nextToken());
			int rt = Integer.parseInt(st.nextToken());
			int a = 0;
			if(input[rt] == c) {
				a = 1;
			}
			
			int result = sum[rt][c-97]+ a - sum[lt][c-97];
			sb.append(result+"\n");
		}

		System.out.println(sb.toString());
	}

}
