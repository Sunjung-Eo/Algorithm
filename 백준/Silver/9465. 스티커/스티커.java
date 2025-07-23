import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int col = Integer.parseInt(br.readLine());
            int[][] board = new int[2][col];

            for (int j = 0; j < 2; j++) {
                String[] line = br.readLine().split(" ");

                for (int k = 0; k < col; k++) {
                    board[j][k] = Integer.parseInt(line[k]);
                }
            }

            int[][] dp = new int[2][col];
            dp[0][0] = board[0][0];
            dp[1][0] = board[1][0];
            
            if (col > 1) {
                dp[0][1] = board[0][1] + dp[1][0];
                dp[1][1] = board[1][1] + dp[0][0];

                for (int j = 2; j < col; j++) {
                    dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + board[0][j];
                    dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + board[1][j];
                }
            }

            int max = Math.max(dp[0][col-1], dp[1][col-1]);
            System.out.println(max);
        }

        br.close();
    }
}
