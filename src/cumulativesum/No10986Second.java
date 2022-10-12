package cumulativesum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10986Second {

	// 꽤 오래 해매서 필기합니다.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[m];
		int rest = 0; // 나머지의 누적합
		long result = 0;
		st = new StringTokenizer(br.readLine(), " ");
		// --- 변수선언 끝 ---

		// 연속 구간 합의 나머지이기 때문에 sum[i]%m = sum[j]%m인 것의 경우의 수를 합산합니다.
		// 경우의 수들은 등차수열을 이룹니다.
		// 나머지가 1인게 2개가 있었고 i번째에서 1개가 더 생겼다면
		// i번째의 합이 짝이 될 수 있는 sum[i]%m은 2개입니다.
		for (int i = 0; i < n; i++) {
			rest = (rest + Integer.parseInt(st.nextToken())) % m; // 누적합의 나머지
			if (rest == 0) { // 나머지가 0이면 그 자체로 ++합니다.
				result++;
			}
			result += arr[rest]; // 나머지를 배열에 더하기전에 더해야 합니다.
									// 이유는 이 나머지가 생긴 순번이 가질 수 있는 sum[i]%m이 배열에 저장되어있는 수이기 때문이죠.
			arr[rest]++; // 배열에 ++해줍니다.
		}

		System.out.println(result);

	}
}
