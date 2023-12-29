package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2667 {

    static int n;
    static boolean[][] visited;
    static int[][] house;
    static List<Integer> houseCounts = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        house = new int[n][n];
        visited = new boolean[n][n];

        // 모든 위치에 대해 탐색
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                house[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (house[i][j] == 1 && !visited[i][j]) {
                    houseCounts.add(dfs(i, j));
                }
            }
        }

        // 결과 출력
        Collections.sort(houseCounts);
        System.out.println(houseCounts.size());
        for (int count : houseCounts) {
            System.out.println(count);
        }
    }

    private static int dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y] || house[x][y] == 0) {
            return 0;
        }

        visited[x][y] = true;

        int count = 1;
        count += dfs(x, y - 1); // 왼쪽
        count += dfs(x, y + 1); // 오른쪽
        count += dfs(x - 1, y); // 위
        count += dfs(x + 1, y); // 아래

        return count;

    }

}
