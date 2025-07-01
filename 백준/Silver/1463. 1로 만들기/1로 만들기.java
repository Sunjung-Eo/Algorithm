import java.io.*;
import java.lang.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[1000001];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i < 1000001; i++) {
            if (i % 2 == 0) {
                dp[i] = 1 + dp[i / 2];
            }

            if (i % 3 == 0 && dp[i] > 1 + dp[i / 3]) {
                dp[i] = 1 + dp[i / 3];
            }

            if (dp[i] > 1 + dp[i - 1]) {
                dp[i] = 1 + dp[i - 1];
            }
        }

        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]);
    }
}