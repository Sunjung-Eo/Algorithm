import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1}; //u, d, r, l
    
    public int solution(String dirs) {
        char[] arr = dirs.toCharArray();
        int[] dir = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'U') dir[i] = 0;
            if (arr[i] == 'D') dir[i] = 1;
            if (arr[i] == 'R') dir[i] = 2;
            if (arr[i] == 'L') dir[i] = 3;
        }
        
        boolean[][][] visited = new boolean[11][11][4];
        int[][] map = new int[11][11];
        int x = 5;
        int y = 5;
        int answer = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int d = dir[i];

            int nx = x + dr[d];
            int ny = y + dc[d];
            if (nx < 0 || nx >= 11 || ny < 0 || ny >= 11) continue;

            if (!visited[x][y][d]) {
                visited[x][y][d] = true;
                visited[nx][ny][d ^ 1] = true;
                answer++;
            }
            x = nx; y = ny;
        }
        
        return answer;
    }
}