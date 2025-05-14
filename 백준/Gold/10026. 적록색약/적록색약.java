import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		int r;
		int c;
		
		Node(int a, int b) {
			r = a;
			c = b;
		}
	}
	
	static int N;
	static char[][] board;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
	
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < N; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		visited = new boolean[N][N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					count++;
				}
			}
		}
		
		sb.append(count);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
				if (board[i][j] == 'R') {
					board[i][j] = 'G';
				}
			}
		}
		
		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					count++;
				}
			}
		}
		
		sb.append(" ").append(count);
		System.out.println(sb.toString());
	}

	private static void bfs(int i, int j) {
		Queue<Node> que = new ArrayDeque<Node>();
		visited[i][j] = true;
		que.add(new Node(i, j));
		
		while(!que.isEmpty()) {
			Node cur = que.poll();
			int r = cur.r, c = cur.c;
			
			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k], nc = c + dc[k];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (board[i][j] == board[nr][nc] && !visited[nr][nc]) {
						visited[nr][nc] = true;
						que.add(new Node(nr, nc));
					}
				}			
			}
		}
	}
}
