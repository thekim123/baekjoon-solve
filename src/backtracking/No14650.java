package backtracking;

import java.util.Scanner;

/**
 * 문제
 * 욱제는 ‘삼’이란 음절을 참 좋아한다. 인삼, 홍삼, 해삼, 삼성, 이춘삼(李春森), 삼식이, 삼시세끼, ㄴㄴ 그거 안 삼, 삼과 죽음, 알았삼, 금강삼도 식후경, 걷다보니 신천역 삼, 그리고 특히 일이삼을 좋아한다. 그래서 욱제는 3을 가지고 놀아보기로 했삼.
 * <p>
 * 3개 숫자(0, 1, 2)만 가지고 N자리 3의 배수를 만들어 보삼. 만드는 배수는 자연수 이삼. 0으로 시작하는 수는 만들 수 없는 수 이삼. 3의 배수가 몇 개나 나올 수 있삼?
 * <p>
 * 입력
 * N을 입력 받으삼. (1 ≤ N ≤ 9)
 * <p>
 * 출력
 * 0, 1, 2만 가지고 만들 수 있는 N자리 3의 배수의 개수를 출력하삼.
 */
public class No14650 {

    static int count;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        char[] arr = new char[n];
        backtrack(0, arr);

        System.out.println(count);
    }

    public static void backtrack(int depth, char[] arr) {
        if (depth == n) {
            if (arr[0] != '0') {
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < arr.length; i++) {
                    temp.append(arr[i]);
                }
                int tempNum = Integer.parseInt(temp.toString());
                if (tempNum != 0 && tempNum % 3 == 0) {
                    count++;
                }
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            arr[depth] = (char) (i + '0');
            backtrack(depth + 1, arr);
        }

    }

}
