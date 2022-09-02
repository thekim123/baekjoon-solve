package geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No4513 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String input = "";
		int[] leg = new int[3];

		while (true) {
			input = br.readLine();
			if(input.equals("0 0 0")) {
				break;
			}
			st = new StringTokenizer(input, " ");
			leg[0] = Integer.parseInt(st.nextToken());
			leg[1] = Integer.parseInt(st.nextToken());
			leg[2] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(leg);
			
			if(leg[0]*leg[0] + leg[1]*leg[1] == leg[2]*leg[2]) {
				sb.append("right\n");
			}else {
				sb.append("wrong\n");
			}
			
		}
		
		System.out.println(sb);
		
	}
}
