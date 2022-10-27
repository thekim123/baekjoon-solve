package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class No4949 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = null;
		while (true) {

			input = br.readLine();
			if (input.equals(".")) {
				break;
			}

			String answer = "yes";
			Stack<Character> stack1 = new Stack<Character>();
			Stack<Character> stack2 = new Stack<Character>();
			for (int i = 0; i < input.length(); i++) {
				for (Character c : input.toCharArray()) {
					if (c == '(') {
						stack1.push(c);
					}
					
					if (c == ')') {
						
						if (stack1.isEmpty()) {
							answer = "no";
							break;
						}
						
						stack1.pop();
					}

					if (c == '[') {
						stack2.push(c);
					}
					
					if (c == ']') {
						
						if (stack2.isEmpty()) {
							answer = "no";
							break;
						}
						
						stack2.pop();
					}
				}
			}
			System.out.println(answer);
		}
	}

}
