package mapList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No10816 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int m = Integer.parseInt(br.readLine());
		int[] marr = new int[m];
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < m; i++) {
			int number = Integer.parseInt(st.nextToken());
			map.put(number, 0);
			marr[i] = number;
		}

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}

		for (int i = 0; i < marr.length; i++) {
			System.out.print(map.get(marr[i]) + " ");
		}
	}
}
