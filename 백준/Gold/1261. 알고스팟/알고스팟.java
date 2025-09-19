import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static int[][] visited;
    static int n, m, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] lime = br.readLine().split("");

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(lime[j]);
            }
        }

        visited = new int[n][m];
        for (int[] row : visited) Arrays.fill(row, Integer.MAX_VALUE);
        bfs();

        System.out.println(ans);
    }

    private static void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.addFirst(new int[]{0, 0, 0});
        visited[0][0] = 0;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0], y = cur[1], cnt = cur[2];

            if (x == n - 1 && y == m - 1) {
                ans = cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                int nextCnt = cnt + map[nx][ny];

                if (visited[nx][ny] > nextCnt) {
                    visited[nx][ny] = nextCnt;
                    if (map[nx][ny] == 0) dq.addFirst(new int[]{nx, ny, nextCnt});
                    else dq.addLast(new int[]{nx, ny, nextCnt});
                }
            }
        }
    }
}
