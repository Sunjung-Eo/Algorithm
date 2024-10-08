import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().trim().split(" ");
		
		long f = Integer.parseInt(input[0]);
		long s = Integer.parseInt(input[1]);
		long g = Integer.parseInt(input[2]);
		int u = Integer.parseInt(input[3]);
		int d = Integer.parseInt(input[4]);
		
		long[] dp = new long[(int)f + 1];
		boolean[] visited = new boolean[(int)f + 1];
		
		Deque<Integer> q = new ArrayDeque<>();
		q.add((int)s);
		visited[(int) s] = true;
		
		while(!q.isEmpty()) {
			int cul = q.poll();
			
			if (cul + u <= f && !visited[cul + u]) {
				dp[cul + u] = dp[cul] + 1;
				visited[cul + u] = true;
				q.add(cul + u);
			}
			
			if (cul - d >= 1 && !visited[cul - d]) {
				dp[cul - d] = dp[cul] + 1;
				visited[cul - d] = true;
				q.add(cul - d);
			}
		}
		
		if (s == g) {
			System.out.println("0");
		} else if(dp[(int) g] != 0) {
			System.out.println(dp[(int) g]);
		} else {
			System.out.println("use the stairs");
		}
	}
}
