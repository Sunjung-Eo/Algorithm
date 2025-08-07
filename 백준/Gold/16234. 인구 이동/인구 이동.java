import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int min = Integer.parseInt(input[1]);
        int max = Integer.parseInt(input[2]);
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        int days = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        boolean[][] visited = new boolean[n][n];
        Deque<int[]> stack = new ArrayDeque<>();

        while (true) {
            visited = new boolean[n][n];
            boolean moved = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        int sum = board[i][j];
                        List<int[]> union = new ArrayList<>();
                        union.add(new int[]{i, j});
                        visited[i][j] = true;

                        Queue<int[]> q = new LinkedList<>();
                        q.add(new int[]{i, j});

                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            int x = cur[0];
                            int y = cur[1];

                            for (int d = 0; d < 4; d++) {
                                int nx = x + dr[d];
                                int ny = y + dc[d];

                                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                                    int diff = Math.abs(board[x][y] - board[nx][ny]);
                                    if (diff >= min && diff <= max) {
                                        visited[nx][ny] = true;
                                        q.add(new int[]{nx, ny});
                                        union.add(new int[]{nx, ny});
                                        sum += board[nx][ny];
                                    }
                                }
                            }
                        }

                        if (union.size() > 1) {
                            moved = true;
                            int avg = sum / union.size();
                            for (int[] pos : union) {
                                board[pos[0]][pos[1]] = avg;
                            }
                        }
                    }
                }
            }

            if (!moved) break;
            days++;
        }

        System.out.println(days);
    }
}
