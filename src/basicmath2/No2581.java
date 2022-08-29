package basicmath2;

import java.util.Scanner;

public class No2581 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int sum = 0;
		
		int[] arr = new int[n+1];
		for (int i = m; i <= n; i++) {
			for (int j = 2; j < i; j++) {
				if(i%j==0) {
					arr[i] = -1;
					continue;
				}
			}
			if(arr[i] != -1) {
				arr[i] = 1;
			}
			System.out.println(arr[i]);
		}
		
		arr[1] = -1;
		for (int i = m; i < arr.length; i++) {
			if(arr[i]!=-1) {
				sum+=i;
			}
		}
		if(sum==0) {
			sum = -1;
		}
		System.out.println(sum);
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==1) {
				System.out.println(i);
				break;
			}
		}
		
	}
}
