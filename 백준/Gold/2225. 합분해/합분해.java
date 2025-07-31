import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        final int MOD = 1_000_000_000;

        long[][] dp = new long[n+1][k+1];

        for (int j = 1; j <= k; j++) {
            dp[0][j] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }

        for (int j = 2; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % MOD;
            }
        }

        System.out.println(dp[n][k]);
    }
}
