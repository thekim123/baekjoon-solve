package sort;

import java.util.Arrays;
import java.util.Scanner;

public class No2587 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[5];

		int avg = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			avg += arr[i] / 5;
		}

		Arrays.sort(arr);
		System.out.println(avg + " " + arr[2]);
	}
}
