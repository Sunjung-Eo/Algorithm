import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().trim().split("");
			
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		boolean[][] visited = new boolean[n][n];
		List<Integer> ans = new ArrayList<>();
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0 , -1, 1};
		
		Deque<int[]> q = new ArrayDeque<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j]) continue;
				
				if (map[i][j] == 1) {
					q.add(new int[] {i, j});
					visited[i][j] = true;
					int cnt = 1;
					
					while (!q.isEmpty()) {
						int[] cur = q.poll();
                        int r = cur[0];
                        int c = cur[1];
                        
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            
                            if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && map[nr][nc] == 1) {
                                visited[nr][nc] = true;
                                q.add(new int[] {nr, nc});
                                cnt++;
                            }
                        }
					}
					
					ans.add(cnt);
				}
			}
		}
		
		System.out.println(ans.size());
		Collections.sort(ans);
		for (int i : ans) {
			System.out.println(i);
		}
 	}
}
