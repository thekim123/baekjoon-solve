import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int totalTryCount = sc.nextInt();
        for (int i = 0; i < totalTryCount; i++) {
            priorityQueue.add(sc.nextInt());
        }

        int result = 0;
        while (priorityQueue.size() > 1) {
            int firstNumber = priorityQueue.poll();
            int secondNumber = priorityQueue.poll();
            int sum = firstNumber + secondNumber;
            result += sum;
            priorityQueue.add(sum);
        }

        System.out.println(result);
    }

}
