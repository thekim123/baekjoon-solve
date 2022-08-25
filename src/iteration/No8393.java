package iteration;

import java.util.Scanner;

public class No8393 {
	public static Scanner scanner = new Scanner(System.in);
	private int sum;
	private int num;
	
	public No8393() {
	
	}
	
	public static void main(String[] args) {
		No8393 solve = start();
		solve.setNum();
		solve.calculateSum(solve.getNum(), solve);
		System.out.println(solve.sum);
	}
	


	public static No8393 start() {
		No8393 solve = new No8393();
		return solve;
	}

	public int calculateSum(int n, No8393 solve) {
		if(n==0) {
			return 0;
		}
		solve.setSum(n+sum);
		return calculateSum(n-1, solve);
	}
	
	public int getNum() {
		return this.num;
	}
	
	public int getSum() {
		return sum;
	}


	public void setSum(int sum) {
		this.sum = sum;
	}

	
	public void setNum() {
		this.num = scanner.nextInt();
	}
}
