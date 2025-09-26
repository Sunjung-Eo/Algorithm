import java.util.*;
import java.math.*;

class Solution {
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {      
                bfs(i, computers);    
                cnt++;              
            }
        }
        return cnt;
    }
    
   public void bfs(int start, int[][] computers) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < computers.length; i++) {
                if (!visited[i] && computers[cur][i] == 1) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}