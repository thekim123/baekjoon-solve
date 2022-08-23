package conditionalstmt;

import java.util.Scanner;

public class No2525 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int hour = scanner.nextInt();
		int minute = scanner.nextInt();
		
		int cookTime = scanner.nextInt();
		
		minute += cookTime;
		if(minute>=60) {
			int temp = minute/60;
			hour+=temp;
			minute-=60*temp;
		}
		
		if(hour>23) {
			hour -=24;
		}
		if(hour<0) {
			hour+=24;
		}

		System.out.println(hour);
		System.out.println(minute);
	}

}
