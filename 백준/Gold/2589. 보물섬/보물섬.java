import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        String[][] board = new String[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = input[j];
            }
        }

        int cnt = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j].equals("L")) {
                    boolean[][] visited = new boolean[n][m];
                    Deque<int[]> queue = new ArrayDeque<>();
                    visited[i][j] = true;
                    queue.addLast(new int[]{i, j, 0});

                    int maxDist = 0;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.removeFirst();
                        maxDist = Math.max(maxDist, cur[2]);

                        for (int k = 0; k < 4; k++) {
                            int x = cur[0] + dr[k];
                            int y = cur[1] + dc[k];

                            if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y] && board[x][y].equals("L")) {
                                visited[x][y] = true;
                                queue.addLast(new int[]{x, y, cur[2] + 1});
                            }
                        }
                    }

                    cnt = Math.max(cnt, maxDist);
                }
            }
        }

        System.out.println(cnt);
    }
}
