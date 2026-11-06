import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int row = maps.length;
        int col = maps[0].length;
        
        // create visited and re-set
        int[][] visited = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = -1;
            }
        }
        
        // create q and set
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = 1;
        
        //bfs
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            if (x == row - 1 && y == col - 1) break;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dr[i];
                int ny = y + dc[i];
                
                if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                if (maps[nx][ny] == 0 || visited[nx][ny] != -1) continue;
                
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = visited[x][y] + 1;
            }
        }
        
        if (visited[row-1][col-1] != -1) return visited[row-1][col-1];
        return -1;
    }
}