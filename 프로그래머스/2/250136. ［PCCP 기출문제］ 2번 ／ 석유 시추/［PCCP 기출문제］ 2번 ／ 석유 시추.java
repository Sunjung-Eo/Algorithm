import java.util.*;
import java.math.*;

class Solution {
    static int[][] land;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        this.land = land;
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        
        int[] oil = new int[m];
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    Set<Integer> cols = new HashSet<>();
                    int size = bfs(i, j, cols);
                    
                    for (int col : cols) {
                        oil[col] += size;
                        max = Math.max(max, oil[col]);
                    }
                }
            }
        }
        
        return max;
    }
    
    public int bfs(int x, int y, Set<Integer> cols) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;
        int cnt = 1;
        cols.add(y);
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int posX = now[0];
            int posY = now[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = posX + dx[i];
                int ny = posY + dy[i];
                
                if (nx < 0|| nx >= n|| ny < 0|| ny >= m) continue;
                if (visited[nx][ny] || land[nx][ny] == 0) continue;
                
                q.add(new int[] {nx, ny});
                visited[nx][ny] = true;
                cnt++;
                cols.add(ny);
            }
        }
        
        return cnt;
    }
}