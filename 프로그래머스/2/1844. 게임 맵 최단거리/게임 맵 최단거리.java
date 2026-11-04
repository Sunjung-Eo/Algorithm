import java.util.*;

class Solution {
    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, -1, 1}; //동, 서, 남, 북
    
    public int solution(int[][] maps) {
        int answer = bfs(maps, maps.length, maps[0].length);
        return answer;
    }
    
    public int bfs(int[][] maps, int n, int m) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[n][m];
        
        q.offer(new int[]{0, 0});
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr == n - 1 && nc == m - 1) return visited[r][c] + 1;
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (maps[nr][nc] == 0) continue;
                if (visited[nr][nc] != 0) continue;
                
                q.offer(new int[]{nr, nc});
                visited[nr][nc] = visited[r][c] + 1;
            }
        }     
        return -1;
    }
}