import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] grid = new char[M][N];
        for (int i = 0; i < M; i++) {
            String line = br.readLine().trim();
            grid[i] = line.toCharArray();
        }

        boolean[][] visited = new boolean[M][N];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int j = 0; j < N; j++) {
            if (grid[0][j] == '0') {
                visited[0][j] = true;
                q.add(new int[]{0, j});
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean percolates = false;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            if (r == M - 1) { 
                percolates = true;
                break;
            }
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;
                if (grid[nr][nc] == '0') {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        System.out.println(percolates ? "YES" : "NO");
    }
}
