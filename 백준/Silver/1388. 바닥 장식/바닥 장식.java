import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		String[][] board = new String[n][m];
		
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			input = br.readLine().trim().split("");
			
			for (int j = 0; j < m; j++) {
				board[i][j] = input[j];
				
				if (j == 0 && input[j].equals("-")) cnt++;
				else if (j >= 1 && input[j].equals("-") 
						&& input[j-1].equals("|")) cnt++;
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {				
				if (j == 0 && board[j][i].equals("|")) cnt++;
				else if (j >= 1 && board[j][i].equals("|") 
						&& board[j-1][i].equals("-")) cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
