package conditionalstmt;

import java.util.Scanner;

public class No9498 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int score = scanner.nextInt();
		String result = "F";
		if (score >= 90 && score <= 100)
			result = "A";
		else if (score >= 80)
			result = "B";
		else if (score >= 70)
			result = "C";
		else if (score >= 60)
			result = "D";
		System.out.println(result);
	}
	
		
}
