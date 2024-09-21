import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		
		int[] food = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int input = Integer.parseInt(br.readLine().trim());
			food[i] = input;
		}
		
		if (n == 0) {
			System.out.println(0);
			return;
		}	
	 
		if (n == 1) {
			System.out.println(food[1]);
			return;
		}
		
		long[][] dp = new long[n + 1][3];
		dp[1][0] = 0;
        dp[1][1] = dp[1][2] = food[1];
        dp[2][0] = food[2];
        dp[2][1] = food[1] + food[2] / 2;
        dp[2][2] = food[1];
		
        long ans = Math.max(dp[2][0], dp[2][1]);

        for (int i = 3; i <= n; i++) {
        	dp[i][0] = dp[i-1][2] + food[i];
            dp[i][1] = dp[i-1][0] + food[i] / 2;
            dp[i][2] = Math.max(Math.max(dp[i-1][1], dp[i-1][2]), dp[i-1][0]);
        }
        
        ans = Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2]);
        System.out.println(ans);
	}

}
