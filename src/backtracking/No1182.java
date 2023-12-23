package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1182 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = backtrack(arr, 0, s, 0);
        System.out.println(result);
    }

    public static int backtrack(int[] arr, int depth, int target, int currentSum) {
        if (depth == arr.length) {
            return (currentSum == target) ? 1 : 0;
        }

        // 현재 요소를 포함하는 경우
        int count = backtrack(arr, depth + 1, target, currentSum + arr[depth]);

        // 현재 요소를 포함하지 않는 경우
        count += backtrack(arr, depth + 1, target, currentSum);

        // 첫 번째 요소를 선택하지 않은 경우를 제외
        return (depth == 0 && currentSum == target) ? count - 1 : count;
    }
}


