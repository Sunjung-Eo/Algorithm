import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine().trim());  
        int e = Integer.parseInt(br.readLine().trim());         
        List<Integer>[] com = new ArrayList[v + 1];  
        boolean[] visited = new boolean[v + 1];  
        
        for (int i = 1; i <= v; i++) {
            com[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            String[] input = br.readLine().trim().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            com[start].add(end);
            com[end].add(start); 
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1); 
        visited[1] = true;
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (int next : com[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    cnt++;  
                }
            }
        }
        
        System.out.println(cnt);
    }
}
