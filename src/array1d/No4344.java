package array1d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No4344 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = Integer.parseInt(br.readLine());
		int sum = 0;
		double[] avg = new double[count];
		double[] rate = new double[count];
		for (int j = 0; j < avg.length; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[Integer.parseInt(st.nextToken())];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			avg[j] = (double) sum / arr.length;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]>avg[j]) {
					rate[j]++;
				}
			}
			rate[j] /= (double)arr.length;
			sum = 0;
		}

		for (double d : rate) {
			System.out.printf("%.3f%%\n",d*100);
		}
	}
}
