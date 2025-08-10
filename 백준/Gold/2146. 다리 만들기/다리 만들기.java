import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] a;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static class Point { int r,c; int d;
        Point(int r,int c){this.r=r;this.c=c; this.d=0;}
        Point(int r,int c,int d){this.r=r;this.c=c; this.d=d;}
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        a = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) a[i][j] = Integer.parseInt(st.nextToken());
        }

        int id = 2;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && a[i][j] == 1) {
                    labelIsland(i, j, id);
                    id++;
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int curId = 2; curId < id; curId++) {
            int res = shortestBridgeFromIsland(curId);
            if (res < answer) answer = res;
        }

        System.out.println(answer);
    }

    static void labelIsland(int sr, int sc, int id) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(sr, sc));
        visited[sr][sc] = true;
        a[sr][sc] = id;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k], nc = p.c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (!visited[nr][nc] && a[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    a[nr][nc] = id;
                    q.add(new Point(nr, nc));
                }
            }
        }
    }

    static int shortestBridgeFromIsland(int islandId) {
        int[][] dist = new int[N][N];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] == islandId) {
                    q.add(new Point(i, j, 0));
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k], nc = p.c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                if (a[nr][nc] == islandId) continue;

                if (a[nr][nc] != 0 && a[nr][nc] != islandId) {
                    return p.d;
                }

                if (a[nr][nc] == 0 && dist[nr][nc] == -1) {
                    dist[nr][nc] = p.d + 1;
                    q.add(new Point(nr, nc, p.d + 1));
                }
            }
        }
        return Integer.MAX_VALUE; 
    }
}
