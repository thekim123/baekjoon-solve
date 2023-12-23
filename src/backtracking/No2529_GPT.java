package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2529_GPT {
    static int k;
    static char[] ops;
    static boolean[] visited = new boolean[10];
    static String max = "";
    static String min = String.valueOf(Long.MAX_VALUE);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        ops = new char[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            ops[i] = st.nextToken().charAt(0);
        }

        solve("", 0);
        System.out.println(max);
        System.out.println(min);
    }

    public static void solve(String num, int depth) {
        if (depth == k + 1) {
            if (min.compareTo(num) > 0) min = num;
            if (max.compareTo(num) < 0) max = num;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            if (depth == 0 || check(num.charAt(num.length() - 1), (char) (i + '0'), ops[depth - 1])) {
                visited[i] = true;
                solve(num + i, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean check(char a, char b, char op) {
        if (op == '<') {
            return a < b;
        } else {
            return a > b;
        }
    }
}

