package cumulativesum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16139 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();
		int count = Integer.parseInt(br.readLine());

		String temp = "";
		int lt;
		int rt;
		int r = 0;
		for (int i = 0; i < count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String comparator = st.nextToken();

			lt = Integer.parseInt(st.nextToken());
			rt = Integer.parseInt(st.nextToken())+1;
			temp = input.substring(lt, rt);
			for (int j = 0; j < rt-lt; j++) {
				if(temp.charAt(j)==comparator.charAt(0)) {
					r++;
				}
			}
			sb.append(r + "\n");
			r = 0;
			temp = "";
		}

		System.out.println(sb.toString());

	}
}
