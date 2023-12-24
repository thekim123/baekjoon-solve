package backtracking;

import java.util.Scanner;

/**
 * multiple 의 계산 방식에 문제가 있음.
 */
public class No16198 {
    static int n;
    static int result;
    static boolean[] visited;
    static int multiple = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        visited = new boolean[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        backtrack(0, arr);
        System.out.println(result);
    }

    static void backtrack(int depth, int[] arr) {
        if (depth == n - 2) {
            if (multiple > result) {
                result = multiple;
            }

            multiple = 1;
            return;
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;

                int multipleNum1 = 0;
                int multipleNum2 = 0;
                for (int j = i; j < arr.length - 1; j++) {
                    if (multipleNum1 != 0) {
                        break;
                    }

                    if (!visited[j + 1]) {
                        multipleNum1 = arr[j + 1];
                    }
                }

                for (int j = i; j > 0; j--) {
                    if (multipleNum2 != 0) {
                        break;
                    }

                    if (!visited[j - 1]) {
                        multipleNum2 = arr[j - 1];
                    }
                }

                multiple = depth == 0
                        ? multipleNum1 * multipleNum2
                        : multiple + multipleNum1 * multipleNum2;
                backtrack(depth + 1, arr);
                visited[i] = false;
            }
        }

    }


}