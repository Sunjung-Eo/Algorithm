import java.util.*;

class Solution {
    int[][] map;
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int h, w;
    
    public int solution(int[][] maps) {
        map = maps;
        h = maps.length;
        w = maps[0].length;
        visited = new boolean[h][w];
        
        int answer = bfs();
        return answer;
    }
    
    public int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        visited[0][0] = true;
        q.add(new int[]{0, 0, 1});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            
            if (x == h - 1 && y == w - 1) {
                return cnt;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (map[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, cnt + 1});
            }
        }
        
        return -1;
    }
}