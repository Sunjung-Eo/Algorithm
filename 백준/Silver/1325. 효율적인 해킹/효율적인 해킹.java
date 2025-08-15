import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static int[] count;
    static int n;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        count = new int[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; ++i) list[i] = new ArrayList<>();

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int computerA = Integer.parseInt(st.nextToken());
            int computerB = Integer.parseInt(st.nextToken());
            list[computerB].add(computerA); 
        }

        for (int i = 1; i < n + 1; ++i) {
            count[i] = bfs(i); 

            if(count[i] > max) {
                max = count[i];
                answer.clear();
                answer.add(i);
            } else if(count[i] == max) answer.add(i); 
        }

        for(int i : answer) sb.append(i).append(" ");
        System.out.println(sb);
    }

    static int bfs(int start){
        boolean[] visited = new boolean[n + 1]; 
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;

        int cnt = 0; 

        while (!que.isEmpty()) {
            int currentComputer = que.poll();

            for (int linkedComputer : list[currentComputer]) {
                if (!visited[linkedComputer]) {
                    visited[linkedComputer] = true;
                    que.offer(linkedComputer);
                    ++cnt; 
                }
            }
        }

        return cnt;
    }
}