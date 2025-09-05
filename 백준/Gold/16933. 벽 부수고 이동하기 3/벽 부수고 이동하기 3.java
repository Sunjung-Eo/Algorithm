import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static boolean[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static class Node {
        int x, y, distance, brokenWallCnt;
        boolean isDay;

        Node(int x, int y, int brokenWallCnt, boolean isDay, int distance) {
            this.x = x;
            this.y = y;
            this.brokenWallCnt = brokenWallCnt;
            this.isDay = isDay;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            
            for (int j = 0; j < M; j++) {
                map[i][j] = (line.charAt(j) == '1');
            }
        }

        System.out.println(bfs(new Node(0, 0, 0, true, 1)));
    }

    private static int bfs(Node start) {
        Queue<Node> q = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[N][M][K+1][2];
        visited[0][0][0][1] = true;
        q.add(start);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == N-1 && cur.y == M-1) {
                return cur.distance;
            }

            boolean needWait = false;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                int nextDayState = cur.isDay ? 0 : 1;

                if (!map[nx][ny]) {
                    if (!visited[nx][ny][cur.brokenWallCnt][nextDayState]) {
                        visited[nx][ny][cur.brokenWallCnt][nextDayState] = true;
                        q.add(new Node(nx, ny, cur.brokenWallCnt, !cur.isDay, cur.distance + 1));
                    }
                } else {
                    if (cur.isDay && cur.brokenWallCnt < K) {
                        if (!visited[nx][ny][cur.brokenWallCnt + 1][nextDayState]) {
                            visited[nx][ny][cur.brokenWallCnt + 1][nextDayState] = true;
                            q.add(new Node(nx, ny, cur.brokenWallCnt + 1, !cur.isDay, cur.distance + 1));
                        }
                    } else {
                        needWait = true;
                    }
                }
            }

            if (needWait) {
                if (!visited[cur.x][cur.y][cur.brokenWallCnt][1]) {
                    visited[cur.x][cur.y][cur.brokenWallCnt][1] = true;
                    q.add(new Node(cur.x, cur.y, cur.brokenWallCnt, true, cur.distance + 1));
                }
            }
        }

        return -1;
    }
}