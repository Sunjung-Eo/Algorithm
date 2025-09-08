import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] groupId;      
    static int[] groupSize;       
    static int groupCnt = 0;    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        groupId = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        groupSize = new int[N * M + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && groupId[i][j] == 0) {
                    groupCnt++;
                    bfs(i, j, groupCnt);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    HashSet<Integer> adjGroups = new HashSet<>();
                    int sum = 1; 
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        int gid = groupId[nx][ny];
                        if (gid > 0 && !adjGroups.contains(gid)) {
                            sum += groupSize[gid];
                            adjGroups.add(gid);
                        }
                    }
                    sb.append(sum % 10);
                    
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void bfs(int x, int y, int gid) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        groupId[x][y] = gid;
        int size = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 0 && groupId[nx][ny] == 0) {
                    groupId[nx][ny] = gid;
                    q.add(new int[]{nx, ny});
                    size++;
                }
            }
        }

        groupSize[gid] = size;
    }
}
