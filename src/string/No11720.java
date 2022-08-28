package string;

import java.util.Scanner;

public class No11720 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		int sum = 0;
		String in = sc.next();
		
		for (int i = 0; i < count; i++) {
			sum+= in.charAt(i)-48;
		}
		
		System.out.println(sum);
	}
}
