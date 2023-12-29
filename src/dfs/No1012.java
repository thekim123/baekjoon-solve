package dfs;

import java.util.Arrays;
import java.util.Scanner;

public class No1012 {
    static int m, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();

            int[][] arr = new int[m][n];
            boolean[][] visited = new boolean[m][n];
            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[x][y] = 1;
            }

            int result = 0;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (!visited[l][j] && arr[l][j] == 1)
                        result += dfs(l, j, visited, arr);
                }
            }
            System.out.println(result);

        }
    }

    private static int dfs(int x, int y, boolean[][] visited, int[][] arr) {
        if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || arr[x][y] == 0) return 0;
        visited[x][y] = true;
        dfs(x + 1, y, visited, arr);
        dfs(x, y + 1, visited, arr);
        dfs(x, y - 1, visited, arr);
        dfs(x - 1, y, visited, arr);
        return 1;
    }


}
