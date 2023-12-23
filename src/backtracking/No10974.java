package backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class No10974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        backtrack(bw, list, n);

        bw.flush();
        bw.close();
    }

    public static void backtrack(BufferedWriter bw, List<Integer> list, int n) throws IOException {
        if (list.size() == n) {
            for (Integer number : list) {
                bw.append(String.valueOf(number)).append(" ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!list.contains(i)) {
                list.add(i);
                backtrack(bw, list, n);
                list.remove(list.size() - 1);
            }
        }

    }
}
