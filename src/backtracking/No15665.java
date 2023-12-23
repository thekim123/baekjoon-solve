package backtracking;
import java.io.*;
import java.util.*;

public class No15665 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        backtrack(sb, new ArrayList<>(), m, arr);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void backtrack(StringBuilder sb, List<Integer> list, int m, int[] arr) {
        if (list.size() == m) {
            for (int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1; // 이전에 선택한 숫자를 저장
        for (int i = 0; i < arr.length; i++) {
            if (prev != arr[i]) { // 이전에 선택한 숫자와 다를 경우에만 진행
                list.add(arr[i]);
                backtrack(sb, list, m, arr);
                list.remove(list.size() - 1);
                prev = arr[i]; // 이전 숫자 업데이트
            }
        }
    }
}

