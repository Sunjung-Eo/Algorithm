import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		
		int[] light = new int[n];
		boolean[] turnOnCheck = new boolean[n];
		
		String[] input = br.readLine().trim().split(" ");
		String[] input2 = br.readLine().trim().split(" ");
		
		int start = 0;
		for (int i = 0; i < n; i++) {
			light[i] = Integer.parseInt(input[i]);
			if (input2[i].equals("1")) {
				turnOnCheck[i] = true;	
				start += light[i];
			} else turnOnCheck[i] = false;
		}
		
		int[] dp = new int[n];
        int max = start;
        dp[0] = start + (turnOnCheck[0] ? -light[0] : light[0]);  
        
        max = Math.max(max, dp[0]);
        
        for (int i = 1; i < n; i++) {
            int change = turnOnCheck[i] ? -light[i] : light[i];
            dp[i] = Math.max(dp[i - 1] + change, start + change);
            max = Math.max(max, dp[i]);
        }
        
        if (start == max) {
            max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, start - light[i]);
            }
        }

        System.out.println(max);
    }
}