import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			String[] input = br.readLine().trim().split(" ");
			int r = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);
			int n = Integer.parseInt(input[2]);
			
			int[][] map = new int[r][c];
			
			for (int i = 0; i < n; i++) {
				input = br.readLine().trim().split(" ");
				int row = Integer.parseInt(input[0]);
				int col = Integer.parseInt(input[1]);
				map[row][col] = 1;
			}
			
			boolean[][] visited = new boolean[r][c];
			
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			int cnt = 0;
			Deque<int[]> q = new ArrayDeque<>();
			
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (map[i][j] == 1 & !visited[i][j]) {
						cnt++;
						q.add(new int[] {i, j});
					}
					
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						int x = cur[0];
						int y = cur[1];
						
						for (int del = 0; del < 4; del++) {
							int nx = x + dr[del];
							int ny = y + dc[del];
							
							if (nx >= 0 && nx < r && ny >= 0 && ny < c
									&& map[nx][ny] == 1 && !visited[nx][ny]) {
								q.add(new int[] {nx, ny});
								visited[nx][ny] = true;
							}
						}
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
