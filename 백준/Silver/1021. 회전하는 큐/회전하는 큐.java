import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int m = sc.nextInt(); 

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        int operationCount = 0;

        for (int target : targets) {
            int idx = deque.indexOf(target);
            int halfIdx = deque.size() / 2;

            if (idx <= halfIdx) {
                for (int i = 0; i < idx; i++) {
                    deque.addLast(deque.pollFirst());
                    operationCount++;
                }
            } else {
                for (int i = 0; i < deque.size() - idx; i++) {
                    deque.addFirst(deque.pollLast());
                    operationCount++;
                }
            }

            deque.pollFirst();
        }

        System.out.println(operationCount);
    }
}
