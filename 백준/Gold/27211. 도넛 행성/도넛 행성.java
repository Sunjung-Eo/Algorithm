import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().trim().split(" ");
		
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			input = br.readLine().trim().split(" ");
			
			for (int j = 0 ; j < m; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		visited = new boolean[n][m];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] == 0) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	static void bfs(int r, int c) {
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {r, c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curR = cur[0];
			int curC = cur[1];
			
			for (int del = 0; del < 4; del++) {
				int nr = curR + dr[del];
				if (curR + dr[del] < 0) {
					nr = n + (curR + dr[del]);
					
				} else if (curR + dr[del] >= n) {
					nr = curR + dr[del] - n;
				}
				
				int nc = curC + dc[del];
				if (curC + dc[del] < 0) {
					nc = m + (curC + dc[del]);
					
				} else if (curC + dc[del] >= m) {
					nc = curC + dc[del] - m;
				}

				if (!visited[nr][nc] && map[nr][nc] == 0) {
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
			}
		}	
	}
}
