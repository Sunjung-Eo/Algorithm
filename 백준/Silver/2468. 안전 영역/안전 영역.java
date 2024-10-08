import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[n][n];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().trim().split(" ");
			
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				
				if (map[i][j] < min) min = map[i][j];
				if (map[i][j] > max) max = map[i][j];
			}
		}
		
		int ans = 1;
		Deque<int[]> q = new ArrayDeque<>();
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		for (int k = min; k <= max; k++) {
			int cnt = 0;
			boolean[][] visited = new boolean[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {			
					if (map[i][j] > k && !visited[i][j]) {
						q.add(new int[] {i, j});
						visited[i][j] = true;
						cnt++;
						
						while (!q.isEmpty()) {
							int[] cur = q.poll();
							int r = cur[0];
							int c = cur[1];
							
							for (int del = 0; del < 4; del++) {
								int nr = r + dr[del];
								int nc = c + dc[del];
								
								if (nr >= 0 && nr < n && nc >= 0 && nc < n 
										&& map[nr][nc] > k && !visited[nr][nc]) {
									q.add(new int[] {nr, nc});
									visited[nr][nc] = true;
								}
							}
						};
					}
				}
			}
			
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
	}
}
