import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[][] board = new String[n][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine().trim().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = input[j];
            }
        }

        List<int[]> result = new ArrayList<>();
        boolean[][] marked = new boolean[n][m]; 
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (board[i][j].equals("*")) {
                    int size = 0;
                    while (i - size - 1 >= 0 && i + size + 1 < n && j - size - 1 >= 0 && j + size + 1 < m &&
                            board[i - size - 1][j].equals("*") &&
                            board[i + size + 1][j].equals("*") &&
                            board[i][j - size - 1].equals("*") &&
                            board[i][j + size + 1].equals("*")) {
                        size++;
                    }
                    
                    if (size > 0) {
                    	for (int k = 1; k <= size; k++) {
                    		result.add(new int[]{i + 1, j + 1, k});
                    	}
                    	marked[i][j] = true;
                        for (int k = 1; k <= size; k++) {
                            marked[i - k][j] = true;
                            marked[i + k][j] = true;
                            marked[i][j - k] = true;
                            marked[i][j + k] = true;
                        }
                    }
                }
            }
        }

        boolean valid = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j].equals("*") && !marked[i][j]) {
                    valid = false;
                    break;
                }
            }
        }

        if (valid && !result.isEmpty()) {
            sb.append(result.size()).append("\n");
            for (int[] cross : result) {
                sb.append(cross[0]).append(" ").append(cross[1]).append(" ").append(cross[2]).append("\n");
            }
        } else {
            sb.append(-1);
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
