package mapList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No1620 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] arr = new String[n + 1];
		for (int i = 1; i <= n; i++) {
			String input = br.readLine();
			map.put(input, i);
			arr[i] = input;
		}

		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			if (isNumber(input.charAt(0))) {
				System.out.println(arr[Integer.parseInt(input)]);
			} else {
				System.out.println(map.get(input));
			}
		}
	}

	public static boolean isNumber(char a) {
		return Character.isDigit(a);
	}

}
