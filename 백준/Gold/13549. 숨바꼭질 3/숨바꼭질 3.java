import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            System.out.println(n - k);
            return;
        }

        final int MAX = 200000 + 1;
        int[] dist = new int[MAX];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Deque<Integer> dq = new ArrayDeque<>();
        dist[n] = 0;
        dq.addFirst(n);

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            if (cur == k) break;

            int d = dist[cur];

            int nx = cur * 2;
            if (nx < MAX && dist[nx] > d) {
                dist[nx] = d;
                dq.addFirst(nx);
            }

            nx = cur - 1;
            if (nx >= 0 && dist[nx] > d + 1) {
                dist[nx] = d + 1;
                dq.addLast(nx);
            }

            nx = cur + 1;
            if (nx < MAX && dist[nx] > d + 1) {
                dist[nx] = d + 1;
                dq.addLast(nx);
            }
        }

        System.out.println(dist[k]);
    }
}
