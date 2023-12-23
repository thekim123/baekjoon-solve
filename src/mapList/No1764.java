package mapList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No1764 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<String, Integer>();
		String input;
		for (int i = 0; i < n; i++) {
			input = br.readLine();
			map.put(input, 1);
		}

		int answer = 0;
		StringBuilder sb = new StringBuilder();
		ArrayList<String> arr = new ArrayList<String>();
		for (int i = 0; i < m; i++) {
			input = br.readLine();
			if (map.containsKey(input) && map.get(input) == 1) {
				answer++;
				arr.add(input);
			}
		}
		Collections.sort(arr);
		System.out.println(answer);
		for (String s : arr) {
			System.out.println(s);
		}
	}
}
