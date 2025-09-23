import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<int[]> pos = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new char[h][w];

        for (int i = 0; i < h; i++) {
            String line = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'C') {
                    pos.add(new int[]{i, j});
                }
            }
        }

        bfs();
        System.out.println(ans);
    }

    private static void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        int[][][] dist = new int[h][w][4];
        for (int[][] arr2d : dist) {
            for (int[] arr1d : arr2d) {
                Arrays.fill(arr1d, Integer.MAX_VALUE);
            }
        }

        int[] start = pos.get(0);
        int[] end = pos.get(1);

        for (int d = 0; d < 4; d++) {
            dist[start[0]][start[1]][d] = 0;
            q.add(new int[]{start[0], start[1], d});
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dir = cur[2];
            int cnt = dist[x][y][dir];

            if (x == end[0] && y == end[1]) {
                ans = Math.min(ans, cnt);
                continue; 
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (map[nx][ny] == '*') continue;

                int ncnt = cnt + (dir == i ? 0 : 1);
                if (dist[nx][ny][i] > ncnt) {
                    dist[nx][ny][i] = ncnt;
                    if (dir == i) q.addFirst(new int[]{nx, ny, i});
                    else q.addLast(new int[]{nx, ny, i});
                }
            }
        }
    }
}
