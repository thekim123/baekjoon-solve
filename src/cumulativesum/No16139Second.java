package cumulativesum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16139Second {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] input = br.readLine().toCharArray();
		int count = Integer.parseInt(br.readLine());
		
		String temp = "";
		int lt;
		int rt;
		int r = 0;
		for (int i = 0; i < count; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String comparator = st.nextToken();
			
			lt = Integer.parseInt(st.nextToken());
			rt = Integer.parseInt(st.nextToken());
			for (int j = lt; j <= rt; j++) {
				temp += input[j];
				if(input[j] == comparator.charAt(0)) {
					r++;
				}
			}
			sb.append(r+"\n");
			r=0;
			temp="";
		}
		
		System.out.println(sb.toString());
		
		
	}
}
