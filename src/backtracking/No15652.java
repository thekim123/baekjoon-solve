package backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No15652 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        backtrack(bw, list, n, m);

        bw.flush();
        bw.close();
    }

    public static void backtrack(BufferedWriter bw, List<Integer> list, int n, int m) throws IOException {
        if (list.size() == m) {
            for (Integer integer : list) {
                bw.write(integer + " ");
            }
            bw.newLine();
            return;
        }

        int start = list.isEmpty() ? 1 : list.get(list.size() - 1);
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrack(bw, list, n, m);
            list.remove(list.size() - 1);
        }
    }
}
