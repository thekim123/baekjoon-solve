package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class No2108 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] navi = new int[8001];
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			navi[arr[i] + 4000]++;
		}

		Arrays.sort(arr);
		int range = getRange(arr);
		int mid = getMid(arr);

		int avg = (int) Math.round(sum / (double) n);
		System.out.println(avg);
		System.out.println(mid);
		System.out.println(getRatio(navi));
		System.out.println(range);
	}

	public static int getRange(int[] arr) {
		return arr[arr.length - 1] - arr[0];
	}

	public static int getMid(int[] arr) {
		int midIdx = (arr.length + 1) / 2 - 1;
		if (arr.length % 2 != 0) {
			return arr[midIdx];
		}
		int answer = (arr[midIdx] + arr[midIdx + 1]) / 2;
		return answer;
	}

	public static int getRatio(int[] navi) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int temp = 0;
		int result = 0;
		for (int i = 0; i < navi.length; i++) {
			if (temp < navi[i]) {
				temp = navi[i];
				arr = new ArrayList<Integer>();
				arr.add(i);
			} else if (temp == navi[i]) {
				arr.add(i);
			}
		}
		Collections.sort(arr);

		result = arr.get(0) - 4000;
		if (arr.size() != 1) {
			result = arr.get(1) - 4000;
		}
		return result;
	}
}
