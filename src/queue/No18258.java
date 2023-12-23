package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class No18258 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            handleCommand(br.readLine(), queue, bw);
        }
        bw.flush();
        bw.close();
    }

    public static void handleCommand(String command, Deque<Integer> queue, BufferedWriter bw) throws Exception {
        if (command.startsWith("push")) {
            int num = Integer.parseInt(command.substring(5));
            queue.offer(num);
        } else if ("pop".equals(command)) {
            bw.write(queue.isEmpty() ? "-1\n" : queue.poll() + "\n");
        } else if ("size".equals(command)) {
            bw.write(queue.size() + "\n");
        } else if ("empty".equals(command)) {
            bw.write(queue.isEmpty() ? "1\n" : "0\n");
        } else if ("front".equals(command)) {
            bw.write(queue.isEmpty() ? "-1\n" : queue.peekFirst() + "\n");
        } else if ("back".equals(command)) {
            bw.write(queue.isEmpty() ? "-1\n" : queue.peekLast() + "\n");
        }
    }
}

