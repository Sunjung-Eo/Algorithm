import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		
		int[] block = new int[n+1];
		String[] input = br.readLine().trim().split(" ");
		
		for (int i = 1 ; i <= n; i++) {
			block[i] = Integer.parseInt(input[i-1]);
		}
		
        int[] dp = new int[n+1];
        dp[1] = 1; 
        
        long[] weightSum = new long[n+1];
        weightSum[1] = block[1];
        
        int max = 1; 
        
        for (int i = 2; i <= n; i++) {
            dp[i] = 1; 
            weightSum[i] = block[i];
            int cnt = 0;
            
            for (int j = i - 1; j >= 1; j--) {
                if (weightSum[j] >= block[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] == dp[j] + 1) cnt = j;
                }                
            }
            if (cnt != 0) weightSum[i] = weightSum[i-1] + block[i];

            max = Math.max(max, dp[i]);
        }
        
		System.out.println(max);
	}

}
