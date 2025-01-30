import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        StringBuilder result = new StringBuilder();

        StringBuilder reverse = new StringBuilder(input);
        reverse.reverse();

        int index = 0;
        final int THREE = 3;
        while (index * THREE  < reverse.length()) {
            int calculateNumber = 0;
            if (index * THREE < input.length()) {
                int first = reverse.charAt(index * THREE) - '0';
//                System.out.println("first index: " + index * THREE);
//                System.out.println("first: " + first);
                calculateNumber += first;
            }

            if (index * THREE + 1 < input.length()) {
                int second = reverse.charAt(index * THREE + 1) - '0';
//                System.out.println("second: " + second * 2);
                calculateNumber += second * 2;
            }

            if (index * THREE + 2 < reverse.length()) {
                int third = reverse.charAt(index * THREE + 2) - '0';
//                System.out.println("third: " + third * 4);
                calculateNumber += third * 4;
            }

            result.insert(0, calculateNumber);
            index++;
        }

        System.out.println(result);

    }
}
