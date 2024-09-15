import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[][] board = new String[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().trim().split("");
			for (int j = 0; j < N; j++ ) {
				board[i][j] = input[j];
			}
		}
		
		int found = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++ ) {
				String rowSum1 = "";
				String rowSum2 = "";
				
				String colSum1 = "";
				String colSum2 = "";
				
				String diagonalSum1 = "";
				String diagonalSum2 = "";
				String diagonalSum3 = "";
				String diagonalSum4 = "";
				
				for (int z =0; z < 5; z++) {
					// 우
					if (j+z < N) rowSum1 += board[i][j+z];
					// 좌
					if (j-z >= 0) rowSum2 += board[i][j-z];
					// 상
					if (i+z < N) colSum1 += board[i+z][j];
					// 하
					if (i-z >= 0) colSum2 += board[i-z][j];
					// 대각선 오른쪽 아래
					if (i+z < N && j+z  < N) diagonalSum1 += board[i+z][j+z];
					// 대각선 오른쪽 위
					if (i-z >= 0 && j+z  < N) diagonalSum2 += board[i-z][j+z];
					// 대각선 왼쪽 아래
					if (i+z < N && j-z  >= 0) diagonalSum3 += board[i+z][j-z];
					// 대각선 왼쪽 위
					if (i-z >= 0 && j-z  >= 0) diagonalSum4 += board[i-z][j-z];
					
				}
				
				if (rowSum1.equals("MOBIS")) found++;
				if (rowSum2.equals("MOBIS")) found++;
				if (colSum1.equals("MOBIS")) found++;
				if (colSum2.equals("MOBIS")) found++;
				if (diagonalSum1.equals("MOBIS")) found++;
				if (diagonalSum2.equals("MOBIS")) found++;
				if (diagonalSum3.equals("MOBIS")) found++;
				if (diagonalSum4.equals("MOBIS")) found++;
			}
		}
		
		System.out.println(found);
		br.close();

	}
}