import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] dx = {0, 0, 1, 0, -1};
        int[] dy = {0, -1, 0, 1, 0};

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());

            int[] moveA = new int[M];
            int[] moveB = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) moveA[i] = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) moveB[i] = Integer.parseInt(st.nextToken());

            int[][] chargers = new int[A][4];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    chargers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ax = 1, ay = 1, bx = 10, by = 10;
            int totalCharge = 0;

            for (int t = 0; t <= M; t++) {
                int maxCharge = 0;
                for (int i = 0; i < A; i++) {
                    for (int j = 0; j < A; j++) {
                        int chargeA = 0, chargeB = 0;
                        if (Math.abs(ax - chargers[i][0]) + Math.abs(ay - chargers[i][1]) <= chargers[i][2]) {
                            chargeA = chargers[i][3];
                        }

                        if (Math.abs(bx - chargers[j][0]) + Math.abs(by - chargers[j][1]) <= chargers[j][2]) {
                            chargeB = chargers[j][3];
                        }

                        if (i == j && chargeA > 0 && chargeB > 0) {
                            maxCharge = Math.max(maxCharge, chargeA);
                        } else {
                            maxCharge = Math.max(maxCharge, chargeA + chargeB);
                        }
                    }
                }
                
                totalCharge += maxCharge;

                if (t < M) {
                    ax += dx[moveA[t]];
                    ay += dy[moveA[t]];
                    bx += dx[moveB[t]];
                    by += dy[moveB[t]];
                }
            }

            sb.append("#").append(tc).append(" ").append(totalCharge).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}