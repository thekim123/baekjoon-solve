package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2110 {

	public static void main(String[] args) throws IOException {
		// 입력값 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 결과 출력
		Arrays.sort(arr);
		int answer = search(arr, c);
		System.out.println(answer);
	}

	public static int search(int[] arr, int c) {
		int lt = 1;
		int rt = arr[arr.length - 1];
		int answer = 0;
		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			if (getMaxLength(arr, mid) >= c) {
				lt = mid + 1;
				answer = mid;
			} else {
				rt = mid - 1;
			}
		}
		return answer;
	}

	public static int getMaxLength(int[] arr, int mid) {
		int ep = arr[0];
		int count = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] - ep >= mid) {
				count++;
				ep = arr[i];
			}
		}
		return count;
	}

}
