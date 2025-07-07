import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] str = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }

        int[] dp = new int[n];
        int max = dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = nums[i];

            if (dp[i] < dp[i-1] + nums[i]) {
                dp[i] = dp[i-1] + nums[i];
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}