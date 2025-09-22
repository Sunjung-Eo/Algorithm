import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][][] visited;
    static int[] start, end;
    static int ans = Integer.MAX_VALUE;
    static int[] dx = {0, 0, 0, 1, -1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());

       map = new int[n+1][m+1];
       visited = new boolean[n+1][m+1][5];
       for (int i = 1; i <= n; i++) {
           st = new StringTokenizer(br.readLine());

           for (int j = 1; j <= m; j++) {
               map[i][j] = Integer.parseInt(st.nextToken());
           }
       }

       start = new int[3];
       st = new StringTokenizer(br.readLine());
       for (int i = 0; i < 3; i++) {
           start[i] = Integer.parseInt(st.nextToken());
       }

       end = new int[3];
       st = new StringTokenizer(br.readLine());
       for (int i = 0; i < 3; i++) {
           end[i] = Integer.parseInt(st.nextToken());
       }

       bfs();
       System.out.println(ans);
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start[0], start[1], start[2], 0});
        visited[start[0]][start[1]][start[2]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dir = cur[2], cnt = cur[3];

            if (x == end[0] && y == end[1] && dir == end[2]) {
                ans = cnt;
                return;
            }

            for (int k = 1; k <= 3; k++) {
                int nx = x + dx[dir] * k;
                int ny = y + dy[dir] * k;
                if (nx < 1 || nx > n || ny < 1 || ny > m) break;
                if (map[nx][ny] == 1) break;
                if (visited[nx][ny][dir]) continue;

                visited[nx][ny][dir] = true;
                q.add(new int[]{nx, ny, dir, cnt + 1});
            }

            for (int nd = 1; nd <= 4; nd++) {
                if (nd == dir) continue;
                int cost = ((dir == 1 && nd == 2) || (dir == 2 && nd == 1)
                        || (dir == 3 && nd == 4) || (dir == 4 && nd == 3)) ? 2 : 1;

                if (!visited[x][y][nd]) {
                    visited[x][y][nd] = true;
                    q.add(new int[]{x, y, nd, cnt + cost});
                }
            }
        }
    }
}
