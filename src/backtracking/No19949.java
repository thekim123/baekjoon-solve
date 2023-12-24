package backtracking;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 문제
 * 컴퓨터공학과 학생인 영재는 이번 학기에 알고리즘 수업을 수강한다.
 * <p>
 * 평소에 자신의 실력을 맹신한 영재는 시험 전날까지 공부를 하지 않았다.
 * <p>
 * 당연하게도 문제를 하나도 풀지 못하였지만 다행히도 문제가 5지 선다의 객관식 10문제였다.
 * <p>
 * 찍기에도 자신 있던 영재는 3개의 연속된 문제의 답은 같지 않게 한다는 자신의 비법을 이용하여 모든 문제를 찍었다.
 * <p>
 * 이때 영재의 점수가 5점 이상일 경우의 수를 구하여라.
 * <p>
 * 문제의 점수는 1문제당 1점씩이다.
 * <p>
 * 입력
 * 시험의 정답이 첫 줄에 주어진다.
 * <p>
 * 출력
 * 영재의 점수가 5점 이상일 경우의 수를 출력하여라.
 */
public class No19949 {

    static int count;
    static int[] answerArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        answerArr = new int[10];
        for (int i = 0; i < answerArr.length; i++) {
            answerArr[i] = sc.nextInt();
        }

        backtrack(0, new ArrayList<Integer>());

        System.out.println(count);
    }


    public static void backtrack(int depth, List<Integer> list) {
        if (depth == 10) {
            int isRight = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == answerArr[i]) {
                    isRight++;
                }
            }

            if (isRight > 4) {
                count++;
            }
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (depth >= 2 && (i == list.get(depth - 2) && i == list.get(depth - 1))) {
                continue;
            }
            list.add(i);
            backtrack(depth + 1, list);
            list.remove(list.size() - 1);
        }


    }


}
