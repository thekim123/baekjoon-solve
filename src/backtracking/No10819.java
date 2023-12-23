package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <h3>문제</h3><br>
 * N개의 정수로 이루어진 배열 A가 주어진다. 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.
 * <p>
 * |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
 * <p>
 * <h3>입력</h3><br>
 * 첫째 줄에 N (3 ≤ N ≤ 8)이 주어진다. 둘째 줄에는 배열 A에 들어있는 정수가 주어진다. 배열에 들어있는 정수는 -100보다 크거나 같고, 100보다 작거나 같다.
 * <p>
 * <h3>출력</h3><br>
 * 첫째 줄에 배열에 들어있는 수의 순서를 적절히 바꿔서 얻을 수 있는 식의 최댓값을 출력한다.
 */
public class No10819 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] output = new int[n];
        boolean[] visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = backtrack(arr, output, visited, 0, 0);
        System.out.println(max);
    }

    public static int backtrack(int[] arr, int[] output, boolean[] visited, int depth, int currentMax) {
        if (depth == arr.length) {
            int sum = calculateSum(output);
            return Math.max(currentMax, sum);
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                currentMax = backtrack(arr, output, visited, depth + 1, currentMax);
                visited[i] = false;
            }
        }

        return currentMax;
    }


    public static int calculateSum(int[] output) {
        int sum = 0;
        for (int i = 0; i < output.length - 1; i++) {
            sum += Math.abs(output[i] - output[i + 1]);
        }
        return sum;
    }

}
