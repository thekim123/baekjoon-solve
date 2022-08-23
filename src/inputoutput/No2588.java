package inputoutput;

import java.util.Scanner;

public class No2588 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int multiple = a*b;
		int num = 100;
		int multipleNum;
		
		int[] result = new int[3];
		
		for (int i = 0; i < 3; i++) {
			multipleNum = b/num;
			result[i] = multipleNum * a;
			b -= multipleNum*num;
			num /= 10;
		}
		
		for(int i=2; i>=0; i--) {
			System.out.println(result[i]);
		}
		
		System.out.println(multiple);
	}
}
