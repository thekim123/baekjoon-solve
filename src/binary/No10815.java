package binary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No10815 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		System.out.println();
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int input = 0;
		for (int i = 0; i < m; i++) {
			input = Integer.parseInt(st.nextToken());
			System.out.println(search(input, arr));
		}

	}

	private static int search(int input, int[] arr) {
		int lt = 0;
		int rt = arr.length - 1;
		int result = 0;
		while (lt <= rt) {
			int mid = (lt + rt) / 2;
			System.out.println("----");
			System.out.println(lt);
			System.out.println(rt);
			System.out.println(arr[mid]);
			System.out.println("----");
			if (arr[mid] == input) {
				result++;
				System.out.println(mid+1);
				if (mid >arr.length) {
					System.out.println("break?");
					break;
				}
				while (arr[mid + 1] == input) {
					System.out.println("++?");
					mid++;
					result++;
				}
				break;
			}
			if (arr[mid] < input) {
				lt = mid + 1;
			} else {
				rt = mid - 1;
			}
		}
		return result;
	}
}

//10
//6 3 2 10 10 10 -10 -10 7 3
//1
//3
