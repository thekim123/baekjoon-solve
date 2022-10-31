package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1158 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		sb.append("<");
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}

		while (true) {
			for (int j = 0; j < k - 1; j++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll());
			if (queue.isEmpty()) {
				break;
			}

			sb.append(", ");
		}

		sb.append(">");
		System.out.println(sb.toString());

	}

}
