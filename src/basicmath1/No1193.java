package basicmath1;

import java.util.Scanner;

public class No1193 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int number = scanner.nextInt();
		int tempNum = number;
		int grade=0;
		for (int i = 0; i < number; i++) {
			tempNum-=i;
			if(tempNum<=0) {
				grade = i;
				System.out.println(grade);
				break;
			}
			System.out.println(tempNum);
			System.out.println(i);
			System.out.println("------");
		}
		if(grade%2==0) {
			
		}
		
		}
	}
