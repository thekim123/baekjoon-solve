package string;

import java.util.Scanner;

public class No10809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input  = sc.next();
		int[] arr = new int[26];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		
		for (int i = 0; i < input.length(); i++) {
			if(arr[input.charAt(i)-97]!=-1) {
				continue;
			} 
			arr[input.charAt(i)-97] = i;
		}

		for (int i : arr) {
			System.out.println(i);
		}
	}
}
