import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input =  br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k  = Integer.parseInt(input[1]);

        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            weight[i] = Integer.parseInt(input[0]);
            value[i] = Integer.parseInt(input[1]);
        }

        int[] dp = new int[k+1];
        for (int i = 0; i < n; i++) {
            int wt = weight[i];
            int v = value[i];

            for (int w = k; w >= wt; w--) {
                dp[w] = Math.max(dp[w], dp[w-wt] + v);
            }
        }

        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);
    }
}
