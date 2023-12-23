package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 *
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 입력
 * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
 *
 * 출력
 * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 *
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class No15649 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 예시: N = 3
        int M = sc.nextInt(); // 예시: M = 2

        List<Integer> list = new ArrayList<>();
        backtrack(list, N, M);
    }

    public static void backtrack(List<Integer> list, int N, int M) {
        // 수열이 완성된 경우, 출력
        if (list.size() == M) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            // 중복을 피하기 위해 현재 수열에 포함되지 않은 숫자인지 확인
            if (!list.contains(i)) {
                list.add(i); // 수열에 숫자 추가
                backtrack(list, N, M); // 다음 단계로 진행
                list.remove(list.size() - 1); // 이전 단계로 되돌아가기
            }
        }
    }
}
