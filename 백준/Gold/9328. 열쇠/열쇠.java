import java.io.*;
import java.util.*;

public class Main {
//3
//        5 17
//        *****************
//        .............**$*
//            *B*A*P*C**X*Y*.X.
//*y*x*a*p**$*$**$*
//            *****************
//    cz
//5 11
//        *.*********
//        *...*...*x*
//            *X*.*.*.*.*
//            *$*...*...*
//            ***********
//            0
//            7 7
//            *ABCDE*
//    X.....F
//    W.$$$.G
//    V.$$$.H
//    U.$$$.J
//    T.....K
//*SQPML*
//    irony

    static int h, w;
    static char[][] map;
    static ArrayList<Character> keys;
    static Map<Character, List<int[]>> doors;
    static int ans;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h+2][w+2];

            for (int j = 1; j <= h; j++) {
                String line = br.readLine();
                for (int k = 1; k <= w; k++) {
                    map[j][k] = line.charAt(k-1);
                }
            }

            for (int j = 0; j < h+2; j++) {
                map[j][0] = '.';
                map[j][w+1] = '.';
            }

            for (int j = 0; j < w+2; j++) {
                map[0][j] = '.';
                map[h+1][j] = '.';
            }

            String line = br.readLine();
            keys = new ArrayList<>();
            doors = new HashMap<>();
            for (char c : line.toCharArray()) {
                keys.add(c);
            }

            bfs();
            sb.append(ans).append("\n");
            ans = 0;
        }

        System.out.println(sb.toString());
    }

    private static void bfs() {
        boolean[][] visited = new boolean[h+2][w+2];
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= h+2 || ny >= w+2) continue;
                if (visited[nx][ny]) continue;

                char c = map[nx][ny];
                if (c == '*') continue;

                if (c >= 'A' && c <= 'Z') {
                    if (keys.contains(Character.toLowerCase(c))) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    } else {
                        doors.computeIfAbsent(c, k -> new ArrayList<>()).add(new int[]{nx, ny});
                    }

                } else if (c >= 'a' && c <= 'z') {
                    keys.add(Character.toLowerCase(c));
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});

                    if (doors.containsKey(Character.toUpperCase(c))) {
                        List<int[]> haveKey = doors.get(Character.toUpperCase(c));
                        for (int[] door : haveKey) {
                            visited[door[0]][door[1]] = true;
                            q.add(door);
                        }
                    }

                } else {
                    if (c == '$') ans++;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }

        }
    }
}
