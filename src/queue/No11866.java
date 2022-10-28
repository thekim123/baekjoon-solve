package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}

		int answer = 0;
		StringBuffer sb = new StringBuffer();
		sb.append("<");
		while (!q.isEmpty()) {
			for (int i = 0; i < k - 1; i++) {
				q.offer(q.poll());
			}
			answer = q.poll();
			sb.append(answer+", ");
		}
		
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.println(sb.toString());

	}

}
