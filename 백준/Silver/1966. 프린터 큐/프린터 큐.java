import java.util.*;

public class Main {
    static class Document {
        int index;
        int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int n = sc.nextInt(); 
            int m = sc.nextInt(); 
            Queue<Document> queue = new LinkedList<>();
            List<Integer> priorities = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int priority = sc.nextInt();
                queue.add(new Document(i, priority));
                priorities.add(priority);
            }

            priorities.sort(Collections.reverseOrder());

            int printOrder = 0;
            int priorityIndex = 0;

            while (!queue.isEmpty()) {
                Document current = queue.poll();

                if (current.priority == priorities.get(priorityIndex)) {
                    printOrder++;
                    if (current.index == m) {
                        System.out.println(printOrder);
                        break;
                    }
                    priorityIndex++;
                } else {
                    queue.add(current);
                }
            }
        }
        sc.close();
    }
}
