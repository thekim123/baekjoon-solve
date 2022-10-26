package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class No9012 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++) {
			Stack<Character> stack = new Stack<Character>();
			String answer = "YES";
			for (Character c : br.readLine().toCharArray()) {
				if (c == '(') {
					stack.push(c);
				}else {
					if(stack.isEmpty()) {
						answer = "NO";
					}else {
						stack.pop();
					}
				}
			}
			
			if(!stack.isEmpty()) {
				answer = "NO";
			}
			System.out.println(answer);

		}

	}
}
