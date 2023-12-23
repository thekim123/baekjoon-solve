package backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class No6603 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            int[] arr = new int[k];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            backtrack(bw, arr, new ArrayList<>());
            bw.newLine();

        }
        bw.flush();
        bw.close();

    }


    public static void backtrack(BufferedWriter bw, int[] arr, List<Integer> list) throws IOException {
        if (list.size() == 6) {
            for (int a : list) {
                bw.append(String.valueOf(a)).append(" ");
            }
            bw.newLine();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int start = list.isEmpty() ? 0 : list.get(list.size() - 1);
            if (!list.contains(arr[i]) && start < arr[i]) {
                list.add(arr[i]);
                backtrack(bw, arr, list);
                list.remove(list.size() - 1);
            }
        }
    }

}
