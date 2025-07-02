import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long [] dp = new long [91];
        dp[1] = dp[2] = 1;

        for (int i = 3; i < 91; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]);
    }
}