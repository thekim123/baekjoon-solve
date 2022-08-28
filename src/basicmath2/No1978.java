package basicmath2;

import java.util.ArrayList;
import java.util.Scanner;

public class No1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] arr = new int[count];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==1) {
				arr[i] = 0;
			}
			for (int j = 2; j < arr[i]; j++) {
				if(arr[i]%j==0) {
					arr[i]=0;
				}
			}
		}
		
		int result = 0;
		for (int i : arr) {
			if(i!=0) {
				result++;
			}
		}
		System.out.println(result);
	}

}
