package iteration;

import java.util.Scanner;

public class No10950 {

	public static Scanner scanner = new Scanner(System.in);

	private int count;
	private int numberA;
	private int numberB;

	public No10950() {

	}
	 
	public No10950(int count, int numberA, int numberB) {
		super();
		this.count = count;
		this.numberA = numberA;
		this.numberB = numberB;
	}

	public static void main(String[] args) {
		No10950 solve = start();
		printCalculation(solve);
	}
	
	public static No10950 start() {
		No10950 solve = new No10950();
		solve.setCount(scanNumber());
		return solve;
	}
	
	public static int scanNumber() {
		return scanner.nextInt();
	}
	
	public static void printCalculation(No10950 solve) {
		for (int i = 0; i < solve.getCount(); i++) {
			solve.setNumberA(scanNumber()); 
			solve.setNumberB(scanNumber());
			System.out.println(solve.getNumberA()+solve.getNumberB());
		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getNumberA() {
		return numberA;
	}

	public void setNumberA(int numberA) {
		this.numberA = numberA;
	}

	public int getNumberB() {
		return numberB;
	}

	public void setNumberB(int numberB) {
		this.numberB = numberB;
	}
}
