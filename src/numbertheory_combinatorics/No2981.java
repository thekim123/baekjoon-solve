package numbertheory_combinatorics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2981 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= arr[count-1]; i++) {
            boolean judge = true;
            int temp = arr[0] % i;
            for (int j = 1; j < count; j++) {
                if (arr[j] % i != temp) {
                    judge = false;
                    break;
                }
            }
            if (judge == true) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb.toString());
    }

}
