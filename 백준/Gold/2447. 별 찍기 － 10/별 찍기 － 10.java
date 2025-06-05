import java.io.*;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb   = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        star(0, 0, n, false);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void star(int row, int col, int size, boolean isBlank) {
        if (isBlank) {
            for (int i = row; i < row + size; i++) {
                for (int j = col; j < col + size; j++) {
                    board[i][j] = ' ';
                }
            }
            return;
        }

        if (size == 1) {
            board[row][col] = '*';
            return;
        }

        int newSize = size / 3;
        int cnt = 0;

        for (int dx = 0; dx < 3; dx++) {
            for (int dy = 0; dy < 3; dy++) {
                cnt++;
                if (cnt == 5) {
                    star(row + dx * newSize, col + dy * newSize, newSize, true);
                } else {
                    star(row + dx * newSize, col + dy * newSize, newSize, false);
                }
            }
        }
    }
}
