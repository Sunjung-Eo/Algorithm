import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");

            for (int j = 0; j <= i; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = board[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + board[i][0];

            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + board[i][j];
            }

            dp[i][i] = dp[i - 1][i - 1] + board[i][i];
        }

        int max = 0;
        for (int j = 0; j < n; j++) max = Math.max(max, dp[n - 1][j]);
        System.out.println(max);
    }
}
