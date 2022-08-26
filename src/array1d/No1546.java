package array1d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1546 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count;
		try {
			count = Integer.parseInt(br.readLine());

			double max = 0;
			double sum = 0;
			double[] scoreArr = new double[count];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < scoreArr.length; i++) {
				scoreArr[i] = Double.parseDouble(st.nextToken());
				sum += scoreArr[i];
				if (scoreArr[i] > max) {
					max = scoreArr[i];
				}
			}
			System.out.println(sum * 100 / (max * count));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
