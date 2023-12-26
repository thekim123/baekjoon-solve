package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No2961 {

    static int minimumDiffer = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int[] sours = new int[n];
        int[] bitters = new int[n];
        for (int i = 0; i < n; i++) {
            sours[i] = sc.nextInt();
            bitters[i] = sc.nextInt();
        }

        boolean[] visited = new boolean[n];
        backtrack(visited, sours, bitters, 0);

        System.out.println(minimumDiffer);
    }


    private static void backtrack(boolean[] visited, int[] sours, int[] bitters, int depth) {
        if (depth == n) {
            int sour = 1;
            int bitter = 0;
            int useCount = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sour = sour * sours[i];
                    bitter += bitters[i];
                    useCount++;
                }
            }

            if (useCount != 0) {
                int tempDifference = Math.abs(bitter - sour);
                if (tempDifference < minimumDiffer) {
                    minimumDiffer = tempDifference;
                }
            }
            return;
        }

        visited[depth] = true;
        backtrack(visited, sours, bitters, depth + 1);

        visited[depth] = false;
        backtrack(visited, sours, bitters, depth + 1);

    }

}
