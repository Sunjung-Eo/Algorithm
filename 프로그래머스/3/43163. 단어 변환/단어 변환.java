import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        boolean[] visited = new boolean[n];
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (oneDiff(begin, words[i])) {
                q.offer(new int[]{i, 1});
                visited[i] = true;
            }
        }
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int idx = cur[0];
            int cnt = cur[1];
            
            if (words[idx].equals(target)) return cnt;
            
            for (int i = 0; i < n; i++) {
                if (oneDiff(words[idx], words[i]) && !visited[i]) {
                    q.offer(new int[]{i, cnt + 1});
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
    
    public boolean oneDiff(String a, String b) {
        int diff = 0;
        
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        
        return diff == 1;
    }
}