import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int cnt = 1;

        while (n != 0) {
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int min = dijkstra(map, n);

            sb.append("Problem ").append(cnt).append(": ").append(min).append("\n");
            cnt++;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb.toString());
    }

    private static int dijkstra(int[][] map, int n) {
        int[][] dist = new int[n][n];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, map[0][0]});
        dist[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int cost = cur[2];

            if (cost > dist[x][y]) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                int nextCost = cost + map[nx][ny];

                if (nextCost < dist[nx][ny]) {
                    dist[nx][ny] = nextCost;
                    pq.add(new int[]{nx, ny, nextCost});
                }
            }
        }

        return dist[n-1][n-1];
    }
}
