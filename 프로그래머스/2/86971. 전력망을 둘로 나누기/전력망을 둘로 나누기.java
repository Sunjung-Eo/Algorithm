import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int[][] adjArr = new int[n + 1][n + 1];

        
        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];
            adjArr[start][end] = adjArr[end][start] = 1;
        }

        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];
            
            adjArr[start][end] = 0;
            adjArr[end][start] = 0;

            boolean[] visited = new boolean[n + 1];
            List<Integer> cnt = new ArrayList<>();
            Deque<Integer> q = new ArrayDeque<>();

            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    int count = 0;
                    q.add(j);
                    visited[j] = true;

                    while (!q.isEmpty()) {
                        int current = q.poll();

                        count++; 

                        for (int k = 1; k <= n; k++) {
                            if (!visited[k] && adjArr[current][k] == 1) {
                                visited[k] = true;
                                q.add(k);
                            }
                        }
                    }
                    cnt.add(count); 
                }
            }

            if (cnt.size() == 2) { 
                answer = Math.min(answer, Math.abs(cnt.get(0) - cnt.get(1)));
            }

            adjArr[start][end] = 1;
            adjArr[end][start] = 1;
        }

        return answer;
    }
}