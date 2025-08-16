import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == M) {
            System.out.println(0);
            return;
        }

        boolean[] visited = new boolean[MAX + 1];
        int[] dist = new int[MAX + 1];

        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[N] = true;
        q.add(N);

        while (!q.isEmpty()) {
            int x = q.poll();

            int[] nexts = new int[] {
                x - 1, x + 1,
                x - A, x + A,
                x - B, x + B
            };

            for (int nx : nexts) {
                if (nx < 0 || nx > MAX || visited[nx]) continue;
                visited[nx] = true;
                dist[nx] = dist[x] + 1;
                if (nx == M) {
                    System.out.println(dist[nx]);
                    return;
                }
                q.add(nx);
            }

            int[] muls = new int[] { x * A, x * B };
            for (int nx : muls) {
                if (nx < 0 || nx > MAX || visited[nx]) continue;
                visited[nx] = true;
                dist[nx] = dist[x] + 1;
                if (nx == M) {
                    System.out.println(dist[nx]);
                    return;
                }
                q.add(nx);
            }
        }
    }
}
