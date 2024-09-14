import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
		
		String[] input = br.readLine().split(" ");
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
        
        if (M == 0 || N == 0) break;
        
		String[][] board = new String[M][N];
		
		for (int r = 0; r < M; r++) {
			input = br.readLine().split("");
			for (int c = 0; c < N; c++) {
				board[r][c] = input[c];
			}
		}
		
		String[][] result = new String[M][N];
		
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				int sum = 0;
				if (board[r][c].equals("*")) {
					result[r][c] = "*";
					sb.append(result[r][c]);
					continue;
					
				} else {
					if (r > 0 && board[r-1][c].equals("*")) sum++;
					if (r < M-1 && board[r+1][c].equals("*")) sum++;
					if (c > 0 && board[r][c-1].equals("*")) sum++;
					if (c < N-1 && board[r][c+1].equals("*")) sum++;
					if (r > 0 && c > 0 && board[r-1][c-1].equals("*")) sum++;
					if (r > 0 && c < N-1 && board[r-1][c+1].equals("*")) sum++;
					if (r < M-1 && c > 0 && board[r+1][c-1].equals("*")) sum++;
					if (r < M-1 && c < N-1 && board[r+1][c+1].equals("*")) sum++;
				}
				result[r][c] = Integer.toString(sum);	
				sb.append(result[r][c]);
			}
			sb.append("\n");
		}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
		}

}
