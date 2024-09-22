import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().trim().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[][] board = new int[N][M];
		boolean[][] check = new boolean[N][M];
		
		String[] Q = br.readLine().trim().split(" ");
		String[] K = br.readLine().trim().split(" ");
		String[] P = br.readLine().trim().split(" ");
		
		int PCount = Integer.parseInt(P[0]);
		for (int i = 1; i < PCount + 1; i++) {
			int row = Integer.parseInt(P[2*i - 1])-1;
			int col = Integer.parseInt(P[2*i])-1;
			board[row][col] = 1;
			check[row][col] = true;
		}

		int KCount = Integer.parseInt(K[0]);
		for (int i = 1; i < KCount+1; i++) {
			int row = Integer.parseInt(K[2*i - 1]) - 1;
			int col = Integer.parseInt(K[2*i]) - 1;
			board[row][col] = 2;
			check[row][col] = true;
			
			int[] dRow = {-2, -2, -1, -1, 1, 1, 2, 2};
			int[] dCol = {-1, 1, -2, 2, -2, 2, -1, 1};
			
			for (int j = 0; j < 8; j++) {
				int newRow = row + dRow[j];
				int newCol = col + dCol[j];
				if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < M && board[newRow][newCol] == 0) {
					check[newRow][newCol] = true;
				}
			}
		}
		
		int QCount = Integer.parseInt(Q[0]);
		for (int i = 1; i < QCount+1; i++) {
			int row = Integer.parseInt(Q[2*i - 1])-1;
			int col = Integer.parseInt(Q[2*i])-1;
			board[row][col] = 3;
			check[row][col] = true;

			
			for (int j = 1; col-j >= 0; j++) {
				if (board[row][col-j] != 0) {
					break;
				} else {
					check[row][col-j] = true;
				}
			}
			
			for (int j = 1; col+j < M; j++) {
				if (board[row][col+j] != 0) {
					break;
				} else {
					check[row][col+j] = true;
				}
			}
			
			for (int j = 1; row-j >= 0; j++) {
				if (board[row-j][col] != 0) {
					break;
				} else {
					check[row-j][col] = true;
				}
			}
			
			for (int j = 1; row+j < N; j++) {
				if (board[row+j][col] != 0) {
					break;
				} else {
					check[row+j][col] = true;
				}
			}
			
			for (int j = 1; row-j >= 0 && col-j >= 0; j++) {
				if (board[row-j][col-j] != 0) {
					break;
				} else {
					check[row-j][col-j] = true;
				}
			}
			
			for (int j = 1; row+j < N && col+j < M; j++) {
				if (board[row+j][col+j] != 0) {
					break;
				} else {
					check[row+j][col+j] = true;
				}
			}
			
			for (int j = 1; row-j >= 0 && col+j < M; j++) {
				if (board[row-j][col+j] != 0) {
					break;
				} else {
					check[row-j][col+j] = true;
				}
			}
			
			for (int j = 1; row+j < N && col-j >= 0; j++) {
				if (board[row+j][col-j] != 0) {
					break;
				} else {
					check[row+j][col-j] = true;
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!check[i][j]) {
					sum++;
				}
			}
		}
		
		System.out.print(sum);
		br.close();
	}
}
