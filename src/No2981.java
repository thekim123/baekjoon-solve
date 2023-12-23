import java.util.*;

public class No2981 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] num = new int[a];

        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }

        int gcd = findGCDOfArray(num);
        findDivisors(gcd).forEach(System.out::println);
        System.out.println(gcd);


    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int findGCDOfArray(int[] numbers) {
        Arrays.sort(numbers);
        int result = numbers[1] - numbers[0];

        for (int i = 2; i < numbers.length; i++) {
            result = gcd(result, numbers[i] - numbers[i - 1]);
        }

        return result;
    }

    public static List<Integer> findDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) { // i와 몫이 다른 경우에만 몫을 추가
                    divisors.add(n / i);
                }
            }
        }

        Collections.sort(divisors); // 약수를 오름차순으로 정렬
        return divisors;
    }

}
