package backtracking;

import java.util.*;

public class No5568 {
    static int k;
    static int result;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] visited = new boolean[n];

        backtrack(arr, new StringBuilder(), visited, 0);

        System.out.println(set.size());

    }


    static void backtrack(int[] arr, StringBuilder sb, boolean[] visited, int depth) {
        if (depth == k) {
            set.add(Integer.parseInt(sb.toString()));
            return;
        }


        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                int originalLength = sb.length();
                visited[i] = true;
                sb.append(arr[i]);
                backtrack(arr, sb, visited, depth + 1);
                visited[i] = false;
                sb.delete(originalLength, sb.length());
            }
        }
    }

}
