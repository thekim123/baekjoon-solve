package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No10828 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arr = new ArrayList<Integer>();
		No10828 stack = new No10828();
		int count = Integer.parseInt(br.readLine());

		for (int i = 0; i < count; i++) {
			String input = br.readLine();
			stack.statement(arr, input);
		}

	}

	public void statement(ArrayList<Integer> arr, String input) throws Exception {
		if ("pop".equals(input)) {
			System.out.println(pop(arr));
		} else if ("top".equals(input)) {
			System.out.println(top(arr));
		} else if ("size".equals(input)) {
			System.out.println(size(arr));
		} else if ("empty".equals(input)) {
			System.out.println(empty(arr));
		} else {
			push(arr, input);
		}
	}

	public int pop(ArrayList<Integer> arr) {
		if (arr.size() == 0) {
			return -1;
		}
		int result = arr.get(arr.size() - 1);
		arr.remove(arr.size() - 1);
		return result;
	}

	public int top(ArrayList<Integer> arr) {
		if (arr.size() == 0) {
			return -1;
		}
		return arr.get(arr.size() - 1);
	}

	public int size(ArrayList<Integer> arr) {
		return arr.size();
	}

	public int empty(ArrayList<Integer> arr) {
		if (arr.size() == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public void push(ArrayList<Integer> arr, String input) {
		int number = Integer.parseInt(input.substring(5));
		arr.add(number);
	}
}
