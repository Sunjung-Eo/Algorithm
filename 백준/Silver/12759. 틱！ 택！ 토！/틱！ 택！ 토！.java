import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[3][3];

        int player = Integer.parseInt(br.readLine().trim()); 
        int n = 0; 
        while (n < 9) {
            String[] input = br.readLine().trim().split(" ");
            int r = Integer.parseInt(input[0]) - 1;
            int c = Integer.parseInt(input[1]) - 1;

            board[r][c] = player;
            

            int check = 0;
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == player && board[i][1] == player 
                		&& board[i][2] == player) {
                    check++;
                }
            }

            for (int i = 0; i < 3; i++) {
                if (board[0][i] == player && board[1][i] == player 
                		&& board[2][i] == player) {
                    check++;
                }
            }

            if ((board[0][0] == player && board[1][1] == player 
            		&& board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player 
                && board[2][0] == player)) {
                check++;
            }

            if (check >= 1) {
                System.out.println(player);
                return;
            }
            
            player = (player == 1) ? 2 : 1;
            n++;
        }

        System.out.println(0);
    }
}
