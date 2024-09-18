import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().trim().split(" ");
		int a = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		int[] dp = new int[k+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[a] = 0;
		
		for (int i = a; i <= k; i++) {
			if (i + 1 <= k) dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
			if (i * 2 <= k) dp[2 * i] = Math.min(dp[2 * i], dp[i] + 1);	
		}
		
		System.out.println(dp[k]);
	}

}
