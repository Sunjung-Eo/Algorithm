import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] map;
    static int[] start;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '0') {
                    start = new int[]{i, j, 0, 0};
                    map[i][j] = '.';
                }
            }
        }

        System.out.println(bfs());
        br.close();
    }

    private static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[n][m][1 << 6];
        q.add(start);
        visited[start[0]][start[1]][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            int curKeys = cur[3];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == '#') continue;

                char cell = map[nx][ny];

                if (cell == '.') {
                    if (!visited[nx][ny][curKeys]) {
                        visited[nx][ny][curKeys] = true;
                        q.add(new int[]{nx, ny, cnt + 1, curKeys});
                    }

                } else if (cell == '1') {
                    return cnt + 1;

                } else if (cell >= 'a' && cell <= 'f') {
                    int bit = cell - 'a';
                    int newKeys = curKeys | (1 << bit);
                    if (!visited[nx][ny][newKeys]) {
                        visited[nx][ny][newKeys] = true;
                        q.add(new int[]{nx, ny, cnt + 1, newKeys});
                    }

                } else if (cell >= 'A' && cell <= 'F') {
                    int bit = cell - 'A';
                    if ((curKeys & (1 << bit)) != 0 && !visited[nx][ny][curKeys]) {
                        visited[nx][ny][curKeys] = true;
                        q.add(new int[]{nx, ny, cnt + 1, curKeys});
                    }
                }
            }
        }
        return -1;
    }
}