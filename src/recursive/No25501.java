package recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No25501 {

	private String input;
	private int isPalin;
	private int count;
	private int l;
	private int r;

	public No25501(String input, int r) {
		this.input = input;
		this.l = 0;
		this.r = r;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getCount() {
		return count;
	}

	public int getIsPalin() {
		return isPalin;
	}

	public void setIsPalin(int isPalin) {
		this.isPalin = isPalin;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public No25501 recursion(No25501 T) {
		T.setCount(T.getCount() + 1);
		if (T.getL() >= T.getR()) {
			T.setIsPalin(1);
			return T;
		} else if (T.getInput().charAt(l) != T.getInput().charAt(r)) {
			T.setIsPalin(0);
			return T;
		} else {
			T.setL(T.getL() + 1);
			T.setR(T.getR() - 1);
			return recursion(T);
		}
	}

	public No25501 isPalindrome(No25501 T) {
		return recursion(T);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++) {
			String input = br.readLine();
			No25501 T = new No25501(input, input.length() - 1);
			T.isPalindrome(T);
			System.out.println(T.getIsPalin() + " " + T.getCount());
		}
	}
}
