import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        final int MOD = 10_007;
        int[][] dp = new int[n + 1][10];

        for (int i = 0; i <= 9; i++) dp[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                int ways = 0;

                for (int k = j; k >= 0; k--) {
                    ways += dp[i-1][k];
                }

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