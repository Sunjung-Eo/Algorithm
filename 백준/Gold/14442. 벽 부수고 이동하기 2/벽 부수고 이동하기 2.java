import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static boolean[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static class Node {
        int x, y, distance, brokenWallCnt;

        Node(int x, int y, int brokenWallCnt, int distance) {
            this.x = x;
            this.y = y;
            this.brokenWallCnt = brokenWallCnt;
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
            input = br.readLine().split("");

            for (int j = 0; j < M; j++) {
                map[i][j] = input[j].equals("1");
            }
        }

        System.out.println(bfs(new Node(0, 0, 0, 1)));
    }

    private static int bfs(Node start) {
        Queue<Node> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][K+1];
        visited[0][0][0] = true;
        q.add(start);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == N-1 && cur.y == M-1) {
                return cur.distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < N && nx >= 0 && ny < M && ny >= 0) {
                    int currentState = cur.brokenWallCnt;

                    if (!map[nx][ny] && !visited[nx][ny][currentState]) {
                        visited[nx][ny][currentState] = true;
                        q.add(new Node(nx, ny, currentState, cur.distance + 1));

                    } else if (currentState < K && map[nx][ny] && !visited[nx][ny][currentState]) {
                        visited[nx][ny][currentState] = true;
                        q.add(new Node(nx, ny, currentState + 1, cur.distance + 1));
                    }
                }
            }
        }

        return -1;
    }
}