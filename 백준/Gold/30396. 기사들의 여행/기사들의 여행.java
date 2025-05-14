import java.io.*;
import java.util.*;

public class Main {
	static int N = 4;
	static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String start = readBoard(br);
		String target = readBoard(br);
		
		int count = bfs(start, target);
		System.out.println(count);
	}

	private static String readBoard(BufferedReader br) throws IOException {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(br.readLine());
		}
		return sb.toString();
	}
	
	private static int bfs(String start, String target) {
		Queue<String> que = new ArrayDeque<String>();
		Map<String, Integer> dist = new HashMap<String, Integer>();
		que.add(start);
		dist.put(start, 0);
		
		while (!que.isEmpty()) {
			String cur = que.poll();
			int d = dist.get(cur);
			
			if (cur.equals(target)) return d;
			
			for (int i = 0; i < N * N; i++) {
				if (cur.charAt(i) == '0') continue;
				
				int r = i / N, c= i % N;
				for (int j = 0; j < 8; j++) {
					int nr = r + dr[j], nc = c + dc[j];
					
					if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
					
					int to = nr * N + nc;
					if (cur.charAt(to) == '0') {
						String next = moveKnight(cur, i, to);
						
						if (!dist.containsKey(next)) {
							que.add(next);
							dist.put(next, d+1);
						}
					}
				}
			}
		}
		
		return -1;
	}
	
	private static String moveKnight(String line, int from, int to) {
		char[] str = line.toCharArray();
		str[from] = '0';
		str[to] = '1';
		return new String(str);
	}
}
