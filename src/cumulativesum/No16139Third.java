package cumulativesum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No16139Third {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] input = br.readLine().toCharArray();
		int count = Integer.parseInt(br.readLine());

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			char temp = st.nextToken().charAt(0);
			int lt = Integer.parseInt(st.nextToken());
			int rt = Integer.parseInt(st.nextToken());
			int result = 0;

			for (int j = lt; j <= rt; j++) {
				if (input[j] == temp) {
					result++;
				}
			}
			sb.append(result+"\n");
			
		}
		
		System.out.println(sb.toString());
	}

}
