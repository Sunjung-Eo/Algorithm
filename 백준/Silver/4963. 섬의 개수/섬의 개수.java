import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			String[] input = br.readLine().trim().split(" ");
			int r = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[0]);
			
			if (r == 0 && c == 0) {
				break;
				
			} else {
				int[][] map = new int[r][c];
				boolean[][] visited = new boolean[r][c];
				
				for (int i = 0; i < r; i++) {
					input = br.readLine().trim().split(" ");
					
					for (int j = 0; j < c; j++) {
						map[i][j] = Integer.parseInt(input[j]);
					}
				}
				
				Deque<int[]> q = new ArrayDeque<>();
				int cnt = 0;
				int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1}; //상 하 좌 우 상좌 상우 하좌 하우
				int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
				
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (visited[i][j]) continue;
						
						if (!visited[i][j] && map[i][j] == 1) {
							q.add(new int[] {i, j});
							visited[i][j] = true;
							cnt++;
							
							while (!q.isEmpty()) {
								int[] cur = q.poll();
								int curR = cur[0];
								int curC = cur[1];
								
								for (int k = 0; k < 8; k++) {
									int nr = curR + dr[k];
									int nc = curC + dc[k];
									
									if (nr >= 0 && nr < r && nc >= 0 && nc < c
											&& map[nr][nc] == 1 && !visited[nr][nc]) {
										q.add(new int[] {nr, nc});
										visited[nr][nc] = true;
									}
								}
							}
						}
					}
				}				
				sb.append(cnt).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
