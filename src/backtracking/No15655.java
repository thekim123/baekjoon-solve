package backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * <b>문제</b><br>
 * N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.
 * <br>
 * N개의 자연수 중에서 M개를 고른 수열
 * 고른 수열은 오름차순이어야 한다.
 * <p></p>
 * <b>입력</b><br>
 * 첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
 * <p>
 * 둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.
 * <p></p>
 * <b>출력</b><br>
 * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 * <br>
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class No15655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();
        backtrack(bw, list, arr, m);

        bw.flush();
        bw.close();

    }

    public static void backtrack(BufferedWriter bw, List<Integer> list, int[] arr, int m) throws IOException {
        if (list.size() == m) {
            for (Integer number : list) {
                bw.append(String.valueOf(number)).append(" ");
            }
            bw.newLine();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int start = list.isEmpty() ? 0 : list.get(list.size() - 1);
            if (start < arr[i]) {
                list.add(arr[i]);
                backtrack(bw, list, arr, m);
                list.remove(list.size() - 1);
            }

        }


    }
}
