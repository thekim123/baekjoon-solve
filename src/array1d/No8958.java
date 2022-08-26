package array1d;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No8958 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = Integer.parseInt(br.readLine());
		int startNum = 0;
		int sum = 0;
		String oxProblem = null;

		for (int i = 0; i < count; i++) {
			oxProblem = br.readLine();
			for (int j = 0; j < oxProblem.length(); j++) {
				if (oxProblem.charAt(j)== 'O') {
					startNum++;
					sum += startNum;
				} else {
					startNum = 0;
				}
			}
			System.out.println(sum);
			startNum=0;
			sum=0;
		}
	}
}
