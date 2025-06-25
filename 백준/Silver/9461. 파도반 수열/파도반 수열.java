import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int maxIdx = -1;
        
        for (int i = 0; i < n; i++) {
        	nums[i] = Integer.parseInt(br.readLine());
        	
        	if (nums[i] > maxIdx) {
        		maxIdx = nums[i];
        	}
        }
        
        long[] dp;
        if (maxIdx <= 5) {
        	dp = new long[6];
        	
        } else {
        	dp = new long[maxIdx + 1];
        }

        dp[1] = dp[2] = dp[3] = 1L;
        dp[4] = dp[5] = 2L;
        
        if (maxIdx > 5) {
        	for (int i = 6; i < maxIdx + 1; i++) {
        		dp[i] = dp[i-1] + dp[i-5];
        	}
        }
        
        for (int num : nums) {
        	bw.write(dp[num] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
