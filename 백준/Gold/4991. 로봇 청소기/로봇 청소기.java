import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] map;
    static int[][] dist;
    static int w, h, n, ans;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] line = br.readLine().split(" ");
            w = Integer.parseInt(line[0]);
            h = Integer.parseInt(line[1]);

            if (w == 0 && h == 0) {
                System.out.println(sb.toString());
                br.close();
                return;
            }

            map = new char[h][w];
            int posX = -1, posY = -1;
            ArrayList<int[]> dirtyPos = new ArrayList<>();

            for (int i = 0; i < h; i++) {
                String str = br.readLine();

                for (int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);

                    if (map[i][j] == 'o') {
                        posX = i;
                        posY = j;
                    }
                    if (map[i][j] == '*') {
                        dirtyPos.add(new int[]{i, j});
                    }
                }
            }

            n = dirtyPos.size() + 1;
            dist = new int[n][n];

            for (int i = 0; i < n; i++) {
                int startX, startY;
                if (i == 0) {
                    startX = posX;
                    startY = posY;

                } else {
                    startX = dirtyPos.get(i - 1)[0];
                    startY = dirtyPos.get(i - 1)[1];
                }

                int[][] bfsDist = bfs(map, startX, startY);

                for (int j = 0; j < n; j++) {
                    int targetX, targetY;
                    if (j == 0) {
                        targetX = posX;
                        targetY = posY;

                    } else {
                        targetX = dirtyPos.get(j - 1)[0];
                        targetY = dirtyPos.get(j - 1)[1];
                    }

                    dist[i][j] = bfsDist[targetX][targetY];
                }
            }

            ans = Integer.MAX_VALUE;
            visited = new boolean[n];
            visited[0] = true;
            perm(0, 0, 0);

            if (ans == Integer.MAX_VALUE) sb.append(-1).append("\n");
            else sb.append(ans).append("\n");
        }
    }

    private static int[][] bfs(char[][] map, int startX, int startY) {
        int[][] d = new int[h][w];
        for (int[] row : d) Arrays.fill(row, -1);

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startX, startY});
        d[startX][startY] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (map[nx][ny] == 'x' || d[nx][ny] != -1) continue;

                d[nx][ny] = d[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        }

        return d;
    }

    private static void perm(int cur, int count, int sum) {
        if (count == n - 1) {
            ans = Math.min(ans, sum);
            return;
        }

        for (int next = 1; next < n; next++) {
            if (!visited[next] && dist[cur][next] != -1) {
                visited[next] = true;
                perm(next, count + 1, sum + dist[cur][next]);
                visited[next] = false;
            }
        }
    }
}
