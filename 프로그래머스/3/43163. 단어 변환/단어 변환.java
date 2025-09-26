import java.util.*;
import java.math.*; 

class Solution {
    String[] wrds;
    boolean[] visited;
    String start, end;
    
    public int solution(String begin, String target, String[] words) {
        start = begin;
        end = target;
        wrds = words;
        visited = new boolean[words.length];
        
        // words 안에 target이 없다면 빠른 return 처리
        boolean check = false;
        for (String s : words) {
            if (s.equals(target)) {
                check = true;
                break;
            }
        }
        if (!check) return 0;
        
        // 탐색
        int answer = bfs();
        return answer;
    }
    
    public int bfs() {
        Queue<String[]> q = new ArrayDeque<>();
        q.add(new String[]{start, "0"});
        
        while (!q.isEmpty()) {
            String[] cur = q.poll();
            String word = cur[0];
            int cnt = Integer.parseInt(cur[1]);
            
            if (word.equals(end)) return cnt;
            
            for (int i = 0; i < wrds.length; i++) {
                if (visited[i]) continue;
                
                String target = wrds[i];
                int diff = 0;
                for (int j = 0; j < target.length(); j++) {
                    if (word.charAt(j) != target.charAt(j)) diff++;
                }
                
                if (diff == 1) {
                    q.add(new String[]{wrds[i], String.valueOf(cnt + 1)});
                }
            }
        }
        
        return 0;
    }
}