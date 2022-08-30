package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2675 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int count = Integer.parseInt(br.readLine());
		int number;
		String init;

		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			number = Integer.parseInt(st.nextToken());
			init = st.nextToken();
			for (int k = 0; k < init.length(); k++) {
				for (int j = 0; j < number; j++) {
					sb.append(init.charAt(k));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

		br.close();
	}
}
