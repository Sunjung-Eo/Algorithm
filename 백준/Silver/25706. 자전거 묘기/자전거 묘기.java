import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine().trim());
		int[] map = new int[n];
		
		String[] input = br.readLine().trim().split(" ");
		for (int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(input[i]);
		}
		
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for (int i = n - 1; i >= 0; i--) {
			if (i + 1 < n && map[i] == 0) dp[i] = dp[i + 1] + 1;
			if (map[i] > 0 && i + map[i] + 1 < n) dp[i] = dp[i + map[i] + 1] + 1; 
		}
		
		for (int i : dp) {
			sb.append(i).append(" ");
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
