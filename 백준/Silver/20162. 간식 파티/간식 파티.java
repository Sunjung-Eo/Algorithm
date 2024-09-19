import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine().trim());
		int[] snack = new int[n];
		
		for (int i = 0; i < n; i++) {
			snack[i] = Integer.parseInt(br.readLine().trim());
		}
		
		int[] dp = new int[n];
		dp[0] = snack[0];
		int max = dp[0];  
        
        for (int i = 1; i < n; i++) {
            dp[i] = snack[i]; 
            
            for (int j = 0; j < i; j++) {
                if (snack[j] < snack[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + snack[i]);  
                }
            }
            
            max = Math.max(max, dp[i]);
        }
		System.out.println(max);
	}

}
