package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			Queue<Printer> q = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int length = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < length; j++) {
				int number = Integer.parseInt(st.nextToken());
				q.offer(new Printer(j, number));
			}

			int answer = 0;
			while (!q.isEmpty()) {
				Printer temp = q.poll();
				
				for (Printer p : q) {
					if (p.priority > temp.priority) {
						q.offer(temp);
						temp = null;
						break;
					}
				}
				if (temp != null) {
					answer++;
					if (temp.id == index) {
						System.out.println(answer);
						break;
					}
				}
			}

		}
	}

}

class Printer {
	int id;
	int priority;

	public Printer(int id, int priority) {
		super();
		this.id = id;
		this.priority = priority;
	}

}
