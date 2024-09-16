import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int N, M, K;
    static int[][] room;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}; 
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        room = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().trim().split(" ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(input[j]);
            }
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    count++; 
                }
            }
        }

        System.out.println(count);
    }

    static void bfs(int r, int c) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];

            for (int del = 0; del < 4; del++) {
                int nr = curR + dr[del];
                int nc = curC + dc[del];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && Math.abs(room[curR][curC] - room[nr][nc]) <= K) {
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
            }
        }
    }
}
