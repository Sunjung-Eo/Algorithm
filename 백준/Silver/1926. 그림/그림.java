import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String[] input = br.readLine().trim().split(" ");
		int r = Integer.parseInt(input[0]);
		int c = Integer.parseInt(input[1]);
		
		int[][] painting = new int[r][c];
		boolean[][] visited = new boolean[r][c];
		
		for (int i = 0; i < r; i++) {
			input = br.readLine().trim().split(" "); 
			
			for (int j = 0 ; j < c; j++) {
				painting[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		int max = 0;
		int cnt = 0;
		Deque<int[]> q = new ArrayDeque<>();
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int size = 0;
				
				if (painting[i][j] == 1 && !visited[i][j]) {
					q.add(new int[] {i, j});
					visited[i][j] = true;
					size++;
					cnt++;
					
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						int row = cur[0];
						int col = cur[1];
						
						for (int k = 0; k < 4; k++) {
							int nr = row + dr[k];
							int nc = col + dc[k];
							
							if (nr >= 0 && nr < r && nc >= 0 && nc < c
									&& painting[nr][nc] == 1 & !visited[nr][nc]) {
								q.add(new int[] {nr, nc});
								visited[nr][nc] = true;
								size++;
							}
						}
					}
				}
				
				max = Math.max(max, size);
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);
	}
}
