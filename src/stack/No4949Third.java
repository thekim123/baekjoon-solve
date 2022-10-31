package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No4949Third {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String input = br.readLine();
			
			if(input.equals(".")) {
				break;
			}
			
			Stack<Character> stack = new Stack<>();
			String answer = "yes";
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '(' || input.charAt(i) == '[') {
					stack.push(input.charAt(i));
				} else if (input.charAt(i) == ')') {
					if (stack.isEmpty() || stack.peek() != '(') {
						stack.push(input.charAt(i));
						answer = "no";
						break;
					}
					stack.pop();
				} else if (input.charAt(i) == ']') {
					if (stack.isEmpty() || stack.peek() != '[') {
						stack.push(input.charAt(i));
						answer = "no";
						break;
					}
					stack.pop();
				}
			}
			
			if (stack.isEmpty()) {
				answer = "yes";
			} else {
				answer = "no";
			}
			
			System.out.println(answer);
		}
	}

}
