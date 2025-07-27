import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            board[i][0] = Integer.parseInt(str[0]);
            board[i][1] = Integer.parseInt(str[1]);
        }

        int[] dp = new int[n + 2];
        for (int i = 0; i <= n; i++) {
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            if (i + board[i][0] <= n)
                dp[i + board[i][0]] = Math.max(dp[i + board[i][0]], dp[i] + board[i][1]);
        }

        System.out.println(Math.max(dp[n], dp[n + 1]));
        br.close();
    }
}
