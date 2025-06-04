import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	static int white;
	static int blue;
	static int[][] board;
	

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine()); 
        board = new int[n][n];
        
        for (int i = 0; i < n; i++) {
        	String[] line = br.readLine().split(" ");
        	
        	for (int j = 0; j < n; j++) {
        		board[i][j] = Integer.parseInt(line[j]);
        	}
        }
        
        partition(0, 0, n);
        
        bw.write(white + "\n" + blue);
        bw.close();
        br.close();
    }


	private static void partition(int row, int col, int size) {
		if (check(row, col, size)) {
			if (board[row][col] == 0) {
				white++;
				return;
				
			} else {
				blue++;
				return;
			}
		}
		
		size = size / 2;
		partition(row, col, size);
		partition(row, col+size, size);
		partition(row+size, col, size);
		partition(row+size, col+size, size);
	}


	private static boolean check(int row, int col, int size) {
		int color = board[row][col];
		
		for (int i = row; i < row+size; i++) {
			for (int j = col; j < col+size; j++) {
				if (board[i][j] != color) {
					return false;
				}
			}
		}
		
		return true;
	}
}
