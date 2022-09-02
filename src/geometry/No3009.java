package geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3009 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] x = new int[3];
		int[] y = new int[3];
		boolean[] newX = new boolean[1001];
		boolean[] newY = new boolean[1001];
		int resultX = 0;
		int resultY = 0;

		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			
			if (!newX[x[i]]) {
				newX[x[i]] = true;
			} else {
				newX[x[i]] = false;
			}
			
			if (!newY[y[i]]) {
				newY[y[i]] = true;
			} else {
				newY[y[i]] = false;
			}
		}
		
		for (int i = 0; i < x.length; i++) {
			if (newX[x[i]]) {
				resultX = x[i];
			}
			if (newY[y[i]]) {
				resultY = y[i];
			}
		}
		
		System.out.println(resultX + " " + resultY);

	}

}
