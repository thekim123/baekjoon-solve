package inputoutput;

import java.util.ArrayList;
import java.util.Scanner;

public class No3003 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] pieceCount = { 1, 1, 2, 2, 2, 8 };
		ArrayList<Integer> input = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			input.add(i, scanner.nextInt());
			input.add(i, pieceCount[i]-input.get(i));
			System.out.println(input.get(i));
		}

	}

	// public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int[] pieceCount = {1,1,2,2,2,8};
//		
//		int[] input = new int[6];
//		int[] result = new int[6];
//		
//		for (int i = 0; i < input.length; i++) {
//			input[i] = scanner.nextInt();
//		}
//		
//		for (int i = 0; i < input.length; i++) {
//			result[i] = pieceCount[i] - input[i];
//			System.out.println(result[i]);
//		}
//	}
}
