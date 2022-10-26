package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class No10773 {

	public static void main(String[] args) throws Exception {
		Stack<Integer> stack = new Stack<Integer>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = num(br.readLine());
		for (int i = 0; i < count; i++) {
			int num = num(br.readLine());
			if (num == 0) {
				stack.pop();
			} else {
				stack.push(num);
			}
		}
		
		if(stack.size()==0) {
			System.out.println(stack.size());
		}else {
			int answer = 0;
			for (int i = 0; i < stack.size(); i++) {
				answer += stack.get(i);
			}
			System.out.println(answer);
		}
	}

	public static int num(String input) {
		return Integer.parseInt(input);
	}
}
