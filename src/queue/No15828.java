package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No15828 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int buffer = Integer.parseInt(br.readLine());

		int a = Integer.MIN_VALUE;
		Queue<Integer> q = new LinkedList<Integer>();
		while (true) {
			a = Integer.parseInt(br.readLine());
			if (a == -1) {
				break;
			}

			if (q.size() < buffer && a != 0) {
				q.offer(a);
			}

			if (a == 0) {
				q.poll();
			}

		}

		q.forEach(z -> System.out.println(z));
	}
}
