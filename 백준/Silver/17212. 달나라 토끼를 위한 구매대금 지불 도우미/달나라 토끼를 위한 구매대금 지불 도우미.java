import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		
		int[] dp = new int[total + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		int[] coins = {1, 2, 5, 7};
		
		for (int i = 1; i <= total; i++) {
			for (int coin : coins) {
				if (i >= coin) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}
		
		System.out.println(dp[total]);
	}

}
