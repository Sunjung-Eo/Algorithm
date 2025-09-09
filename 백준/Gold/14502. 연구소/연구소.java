import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<int[]> empty = new ArrayList<>();
    static int maxSafe = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) empty.add(new int[]{i, j});
            }
        }

        buildWall(0, 0);
        System.out.println(maxSafe);
    }

    static void buildWall(int start, int count){
        if (count == 3) {
            int safe = spreadVirus();
            maxSafe = Math.max(maxSafe, safe);
            return;
        }

        for (int i = start; i < empty.size(); i++) {
            int x = empty.get(i)[0];
            int y = empty.get(i)[1];
            map[x][y] = 1;
            buildWall(i + 1, count + 1);
            map[x][y] = 0;
        }
    }

    static int spreadVirus() {
        int[][] copy = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) copy[i] = map[i].clone();

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                if (copy[i][j] == 2) q.add(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < copy.length && ny < copy[0].length && copy[nx][ny] == 0) {
                    copy[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        int safe = 0;
        for (int i = 0; i < copy.length; i++)
            for (int j = 0; j < copy[0].length; j++)
                if (copy[i][j] == 0) safe++;

        return safe;
    }
}
