import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n+1];

        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        
        if (n == 1) {
            System.out.println(score[1]);
            return;
        }

        int[] dp =  new int[n+1];
        dp[0] = 0;
        dp[1] = score[1];
        dp[2] = dp[1] + score[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2] + score[i], dp[i-3] + score[i-1] + score[i]);
        }

        System.out.println(dp[n]);
    }
}