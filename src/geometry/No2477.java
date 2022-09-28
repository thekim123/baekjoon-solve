package geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2477 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int count = Integer.parseInt(br.readLine());
		int[] directionArea = new int[4];
		int[] direction = new int[6];
		int[] arrayWidth = new int[3];
		int[] arrayHeight = new int[3];
		
		int area = 1;
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			direction[i] = Integer.parseInt(st.nextToken());
			directionArea[direction[i]]++;
			if(direction[i]==1 || direction[i]==2) {
				arrayWidth[i] = Integer.parseInt(st.nextToken());
			} else {
				arrayHeight[i] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for (int i = 0; i < array.length; i++) {
//			if(directionArea[i] = 1) {
//				area *= 
//			}
//		}
//		
		
	}
}

/*
 * 7
4 50
2 160
3 30
1 60
3 20
1 100
*/
