package dfs;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1388 {

    static char[][] floors;
    static boolean[][] visited;
    static int n, m;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        floors = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                floors[i][j] = temp.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, floors[i][j]);
                    count++;
                }
            }
        }

        System.out.println(count);

    }


    private static void dfs(int x, int y, char type) {
        if (x < 0 || y < 0 || x >= n || y >= m) return;
        if (visited[x][y] || floors[x][y] != type) return;

        visited[x][y] = true;
        if (floors[x][y] == '-') dfs(x, y + 1, type);
        if (floors[x][y] == '|') dfs(x + 1, y, type);
    }

}
