package backtracking;

import java.util.Scanner;

public class No12101 {
    static int n, k;
    static int count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        backtrack(0);
        if (sb.toString().isBlank()) {
            sb.append("-1");
        }
        System.out.println(sb);

    }


    private static void backtrack(int number) {
        if (number >= n) {
            if (number == n) {
                count++;
                if (count == k) {
                    sb.setLength(sb.length() - 1);
                }
            }

            return;
        }

        for (int i = 1; i < 4; i++) {
            int prevLength = sb.length();
            sb.append(i).append('+');
            backtrack(number + i);
            if (count >= k) {
                return;
            }
            sb.setLength(prevLength);
        }

    }
}
