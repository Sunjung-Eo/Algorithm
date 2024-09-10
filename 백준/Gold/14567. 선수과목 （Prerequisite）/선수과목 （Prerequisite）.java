import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int[][] adjArr = new int[n + 1][n + 1];
		int[] check = new int[n + 1];
		int[] result = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		
		for (int i = 0; i < m; i++) {
			input = br.readLine().trim().split(" ");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			adjArr[from][to] = 1;
			check[to]++;
		}
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (check[i] == 0) {
				visited[i] = true;
				q.add(i);
				result[i] = 1;
			}
		}	
		
		while (!q.isEmpty()) {
			int cur = q.poll();
						
			for (int i = 1; i <= n ; i++) {
				if (adjArr[cur][i] == 1) {
					check[i]--;
					
					if (check[i] == 0) {
						visited[i] = true;
						q.add(i);
						result[i] = Math.max(result[i], result[cur] + 1);
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			sb.append(result[i]).append(" ");
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
