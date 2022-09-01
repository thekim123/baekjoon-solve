package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No7568 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int count = Integer.parseInt(br.readLine());
		int[] weightArray = new int[count];
		int[] heightArray = new int[count];
		int[] resultWeightArr = new int[count];

		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			weightArray[i] = Integer.parseInt(st.nextToken());
			heightArray[i] = Integer.parseInt(st.nextToken());
		}

		for (int j = 0; j < resultWeightArr.length-1; j++) {
			for (int i = 0; i < count-1; i++) {
				if (weightArray[i] > weightArray[i + 1]) {
					resultWeightArr[j] = i;
				}
			}
		}
		
		for (int i : resultWeightArr) {
			System.out.println(i);
		}
	}
}
