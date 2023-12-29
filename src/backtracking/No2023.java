package backtracking;

import java.util.Scanner;

public class No2023 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        backtrack(1, 2);
        backtrack(1, 3);
        backtrack(1, 5);
        backtrack(1, 7);

    }


    private static void backtrack(int depth, int num) {
        if (depth == n) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            int newNum = num * 10 + i;
            if (isPrime(newNum))
                backtrack(depth + 1, newNum);
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
