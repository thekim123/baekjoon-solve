package backtracking;

import java.util.Scanner;

public class No18429 {

    static int count;
    static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] visited = new boolean[n];

        backtrack(arr, visited, 0, 0);
        System.out.println(count);

    }


    static void backtrack(int[] arr, boolean[] visited, int depth, int totalGain) {

        /**
         * 제안된 변경 사항은 백트래킹 과정에서의 가지치기(pruning)를 개선하는 것입니다. 이 변경을 통해 얻는 주요 이점은 다음과 같습니다:
         *
         * 불필요한 재귀 호출 감소: totalGain < 0 조건을 더 일찍 검사함으로써, 중량이 이미 500 미만으로 떨어진 경우 더 깊은 재귀 탐색을 방지합니다. 이는 불필요한 계산을 줄여주고, 전체적인 탐색 시간을 단축시킵니다.
         *
         * 가지치기 효율 향상: 조건을 루프 내부가 아닌 재귀 함수의 시작 부분에 배치함으로써, 조건을 만족하지 않는 경로에 대한 탐색을 더 빨리 중단합니다.
         * 이는 탐색 공간을 효과적으로 줄이는 가지치기 기법의 좋은 예시입니다.
         *
         * 성능 향상: depth == arr.length에 도달하기 전에 totalGain < 0 조건을 만족하는 경우가 많다면, 이러한 변경은 전체적인 프로그램의 성능에 상당한 영향을 미칠 수 있습니다.
         * 특히, 탐색 트리의 크기가 크거나 탐색 과정이 복잡할수록 이점이 커집니다.
         *
         * 코드의 가독성 및 유지 보수: 조건을 명확하고 직관적인 위치에 배치함으로써 코드의 가독성을 향상시키고, 추후 유지 보수를 용이하게 합니다.
         * 이러한 방식으로 가지치기를 적용하는 것은 백트래킹 알고리즘에서 매우 중요한 전략입니다. 불필요한 탐색 경로를 최소화함으로써 알고리즘의 효율성을 크게 향상시킬 수 있습니다.
         */
        if (totalGain < 0) return;
        // 가지치기 첨삭

        if (depth == arr.length) {
            if (totalGain >= 0) {
                count++;
            }

            return;
        }


        for (int i = 0; i < arr.length; i++) {
//            if (totalGain < 0) continue;
            if (!visited[i]) {
                visited[i] = true;
                totalGain += arr[i] - k;
                backtrack(arr, visited, depth + 1, totalGain);
                visited[i] = false;
                totalGain -= arr[i] - k;
            }
        }

    }


}
