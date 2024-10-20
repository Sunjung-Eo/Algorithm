import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        
        if (start == end) {
            System.out.println(1);
            return;
        }

        Map<Long, Integer> dp = new HashMap<>();
        Deque<Long> q = new ArrayDeque<>();
        
        dp.put((long) start, 1);
        q.add((long) start);
        
        while (!q.isEmpty()) {
            long cur = q.poll();
            
            if (cur * 2 <= end && !dp.containsKey(cur * 2)) {
                dp.put(cur * 2, dp.get(cur) + 1);
                q.add(cur * 2);
            }
            
            long num = Long.parseLong(cur + "1");
            if (num <= end && !dp.containsKey(num)) {
                dp.put(num, dp.get(cur) + 1);
                q.add(num);
            }
        }
        
        System.out.println(dp.getOrDefault((long) end, -1));        
    }
}
