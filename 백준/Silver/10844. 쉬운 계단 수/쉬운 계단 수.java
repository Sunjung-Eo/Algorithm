import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        final int MOD = 1_000_000_000;
        int[][] dp = new int[n + 1][10];

        for (int i = 1; i <= 9; i++) dp[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                int ways = 0;
                if (j > 0)   ways += dp[i-1][j-1];
                if (j < 9)   ways += dp[i-1][j+1];
                dp[i][j] = ways % MOD;
            }
        }

        int sum = 0;
        for (int d = 0; d < 10; d++) {
            sum = (sum + dp[n][d]) % MOD;
        }

        System.out.println(sum);
    }
}