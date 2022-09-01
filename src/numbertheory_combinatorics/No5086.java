package numbertheory_combinatorics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No5086 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String result = "";

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == 0) {
				break;
			}
			result = "neither";

			if (a > b && a % b == 0) {
				result = "multiple";
			}

			if (b > a && b % a == 0) {
				result = "factor";
			}

			System.out.println(result);

		}
	}

}
