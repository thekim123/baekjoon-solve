package map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No10815 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(n);
		while (st.hasMoreTokens()) {
			int number = Integer.parseInt(st.nextToken());
			map.put(number, map.getOrDefault(number, 0)+1);
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i < m; i++) {
			int number = Integer.parseInt(st.nextToken());
			if(map.containsKey(number)) {
				System.out.print("1 ");
			} else {
				System.out.print("0 ");
			}
		}

	}

}
