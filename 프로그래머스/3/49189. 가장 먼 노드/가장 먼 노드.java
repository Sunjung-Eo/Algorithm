import java.util.*;

class Solution {
    static int[] dist;
    
    public int solution(int n, int[][] edge) {
        dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);  
            graph.get(e[1]).add(e[0]);   
        }

        count(graph);
        
        int max = 0;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (max < dist[i]) {
                max = dist[i];
                cnt = 1;
                
            } else if (max == dist[i]) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    public void count(List<List<Integer>> graph) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (dist[next] != -1) continue;     

                dist[next] = dist[cur] + 1;       
                q.offer(next);
            }
        }
    }   
}