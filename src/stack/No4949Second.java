package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No4949Second {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = "";
		while (true) {
			Stack<Character> stack = new Stack<>();
			input = br.readLine();

			if (".".equals(input)) {
				break;
			}

			for (int i = 0; i < input.length(); i++) {
				if (setCondition(input.charAt(i))) {
					stack.push(input.charAt(i));
				}
			}

			System.out.println(stack);
			String answer = "yes";
			for (int i = stack.size() - 1; i > 0; i--) {
				System.out.println(stack.get(i));
				try {
					if (stack.get(i) == ')') {
						while (stack.pop() != ')')
							;
					}
					if (stack.get(i) == '[') {
						while (stack.pop() != ']')
							;
					}
				} catch (Exception e) {
					answer = "no";
				}
				System.out.println(stack);
			}
			System.out.println(answer);
		}
	}

	public static boolean setCondition(Character c) {
		return c == '(' || c == ')' || c == '[' || c == ']';

	}

}
