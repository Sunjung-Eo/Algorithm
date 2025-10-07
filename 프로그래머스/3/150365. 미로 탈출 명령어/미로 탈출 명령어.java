import java.util.*;

class Solution {
    int n, m, k;
    int[] end;
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    char[] c = {'d', 'l', 'r', 'u'};
    String answer = "impossible";
    boolean found = false;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.k = k;
        end = new int[] {r-1, c-1};
        dfs(x-1, y-1, "", 0);
        return answer;
    }

    public void dfs(int x, int y, String s, int depth) {
        if (found) return; 
        
        int dist = Math.abs(end[0] - x) + Math.abs(end[1] - y);
        int remain = k - depth;
        if (dist > remain || (remain - dist) % 2 != 0) return;

        if (depth == k) {
            if (x == end[0] && y == end[1]) {
                answer = s;
                found = true;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                dfs(nx, ny, s + c[i], depth + 1);
                if (found) return; 
            }
        }
    }
}
