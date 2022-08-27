package basicmath1;

import java.util.Scanner;

public class No1712 {
	
	public static void main(String[] args) {
		
		int a, b, c;
		int result;
		Scanner scan = new Scanner(System.in);
		
		a = scan.nextInt();
		b = scan.nextInt();
		c= scan.nextInt();
		
		if(c-b<=0){
			result = -1;
		}else {
			result = c-b;
			result = a/result+1; 
		}
		System.out.println(result);
		
	}

}
