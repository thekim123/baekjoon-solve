package backtracking;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class No15663 {
    static Set<String> preventDuplicatedSet = new HashSet<>();

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

        backtrack(bw, new ArrayList<>(), arr, new boolean[n], m);

        bw.flush();
        bw.close();
    }


    public static void backtrack(BufferedWriter bw, List<Integer> list, int[] arr, boolean[] used, int m) throws IOException {
        if ((list.size() == m)) {
            String listString = list.toString();
            if (!preventDuplicatedSet.contains(listString)) {
                preventDuplicatedSet.add(listString);

                for (int number : list) {
                    bw.append(String.valueOf(number)).append(" ");
                }
                bw.newLine();
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int start = list.isEmpty() ? arr[0] : list.get(list.size() - 1);
            if (!used[i] && arr[i] >= start) {
                used[i] = true;
                list.add(arr[i]);
                backtrack(bw, list, arr, used, m);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }

    }

}
