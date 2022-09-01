package geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1085 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int[] distance = new int[4]; 
		distance[0] = x;
		distance[1] = y;
		distance[2] = w-x;
		distance[3] = h-y;
		
		Arrays.sort(distance);
		
		System.out.println(distance[0]);
	}
}
