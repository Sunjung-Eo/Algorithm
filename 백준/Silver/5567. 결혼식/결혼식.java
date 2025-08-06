import java.io.*;
import java.util.*;

public class Main {

    //6
      //      5
        //    1 2
    //  1 3
      //      3 4
        //    2 3
          //  4 5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            if (!map.containsKey(a)) map.put(a, new ArrayList<>());
            map.get(a).add(b);

            if (!map.containsKey(b)) map.put(b, new ArrayList<>());
            map.get(b).add(a);
        }

        boolean[] visited = new boolean[n+1];
        int cnt = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int cur = now[0];
            int depth = now[1];

            if (depth >= 2) continue;

            for (int next : map.getOrDefault(cur, new ArrayList<>())) {
                if (!visited[next]) {
                    visited[next] = true;
                    cnt++;
                    queue.offer(new int[]{next, depth + 1});
                }
            }
        }

        System.out.println(cnt);
    }
}