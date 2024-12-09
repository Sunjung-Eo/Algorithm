import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static boolean inBounds(int x, int y, int R, int C) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void bfs(int startX, int startY, char[][] grid, boolean[][] visited, int R, int C) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int sheepCount = 0;
        int wolfCount = 0;

        if (grid[startX][startY] == 'o') sheepCount++;
        if (grid[startX][startY] == 'v') wolfCount++;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (inBounds(nx, ny, R, C) && !visited[nx][ny] && grid[nx][ny] != '#') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});

                    if (grid[nx][ny] == 'o') sheepCount++;
                    if (grid[nx][ny] == 'v') wolfCount++;
                }
            }
        }

        if (sheepCount > wolfCount) {
            resultSheep += sheepCount;
        } else {
            resultWolf += wolfCount;
        }
    }

    static int resultSheep = 0;
    static int resultWolf = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine(); 

        char[][] grid = new char[R][C];
        boolean[][] visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && grid[i][j] != '#') {
                    bfs(i, j, grid, visited, R, C);
                }
            }
        }
        
        System.out.println(resultSheep + " " + resultWolf);
    }
}
