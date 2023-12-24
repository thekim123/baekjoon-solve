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

        backtrack(arr, new ArrayList<>(), visited, 0, "");

        System.out.println(set.size());

    }


    static void backtrack(int[] arr, List<Integer> list, boolean[] visited, int depth, String selected) {
        if (depth == k) {
            StringBuilder selectedBuilder = new StringBuilder(selected);
            for (int a : list) {
                selectedBuilder.append(a);
            }
            selected = selectedBuilder.toString();
            set.add(Integer.parseInt(selected));
            return;
        }


        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                backtrack(arr, list, visited, depth + 1, selected);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

}
