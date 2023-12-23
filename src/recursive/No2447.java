package recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2447 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        while (n != 1) {
            n /= 3;
            count++;
        }

        printStar(count);
    }

    public static String printStar(int n) {
        if (n == 3) {
            String space = " ";
        }
        String star = "*";
        return star;
    }

}
