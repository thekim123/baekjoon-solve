package backtracking;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 문제
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * <p>
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 고른 수열은 오름차순이어야 한다.
 * 입력
 * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
 * <p>
 * 출력
 * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 * <p>
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class No15650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        backtrack(list, n, m);
    }

    public static void backtrack(List<Integer> list, int n, int m) {
        if (list.size() == m) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        /**
         * 가지치기 최적화: 오름차순 조건을 더 효율적으로 처리할 수 있습니다.
         * 현재의 구현에서는 모든 숫자에 대해 반복문을 실행하고, 조건문에서 오름차순 여부를 검사합니다.
         * 하지만, 반복문의 시작 지점을 조정하여 불필요한 반복을 줄일 수 있습니다.
         * <p>
         * 4. 개선된 백트래킹 로직 제안:
         * <p>
         * for 반복문의 시작 지점을 마지막으로 선택된 숫자의 다음 숫자로 설정하여 불필요한 반복을 줄일 수 있습니다.
         * 이렇게 하면 list.isEmpty() 또는 list.get(list.size() - 1) >= i와 같은 조건 검사가 필요 없어집니다.
         */
        int start = list.isEmpty() ? 1 : list.get(list.size() - 1) + 1;
        for (int i = start; i <= n; i++) {
            if (!list.contains(i)) {
                list.add(i);
                backtrack(list, n, m);
                list.remove(list.size() - 1);
            }

        }


    }

}
