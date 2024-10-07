import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().trim().split(" ");
		int V = Integer.parseInt(input[0]);
		int E = Integer.parseInt(input[1]);
		
		List<Integer>[] arr = new ArrayList[V+1];
		boolean[] visited = new boolean[V+1];
		
		for (int i = 1; i <= V; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			input = br.readLine().trim().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			arr[start].add(end);
			arr[end].add(start);
		}
		
		Deque<Integer> q = new ArrayDeque<>();
		int cnt = 0;
		
		for (int i = 1; i <= V; i++) {
			if (arr[i] != null && !visited[i]) {
				cnt++;
				visited[i] = true;
				
				for (int j : arr[i]) {
					q.add(j);
				}
				
				while(!q.isEmpty()) {
					int cur = q.poll();
					
					if (arr[cur] != null && !visited[cur]) {
						visited[cur] = true;
						
						for (int j : arr[cur]) {
							q.add(j);
						}
					}		
				}
			}	
		}
		
		System.out.println(cnt);
	}

}
