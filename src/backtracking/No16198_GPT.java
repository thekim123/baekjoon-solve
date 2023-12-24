package backtracking;

import java.util.Scanner;

public class No16198_GPT {
    static int n;
    static int result;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        visited = new boolean[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        backtrack(0, arr, 0);
        System.out.println(result);
    }

    static void backtrack(int depth, int[] arr, int energy) {
        if (depth == n - 2) {
            result = Math.max(result, energy);
            return;
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                // 왼쪽과 오른쪽에 있는 미방문 구슬 찾기
                int left = i - 1, right = i + 1;
                while (left > 0 && visited[left]) left--;
                while (right < arr.length - 1 && visited[right]) right++;

                // 에너지 계산
                int nextEnergy = arr[left] * arr[right];
                backtrack(depth + 1, arr, energy + nextEnergy);
                visited[i] = false;
            }
        }

    }


}
