package array2d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2566 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] arr = new int[9][9];
		int row = 0;
		int col = 0;
		int temp = 0;
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] > temp) {
					temp = arr[i][j];
					row = i;
					col = j;
				}
			}
		}
		System.out.println(temp);
		System.out.println((row+1) + " " + (col+1));
	}

}
