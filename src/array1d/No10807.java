package array1d;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10807 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int v = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(input, " ");
		int[] arr = new int[n];
		int answer = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == v) {
				answer++;
			}
		}

		System.out.println(answer);

	}
}
