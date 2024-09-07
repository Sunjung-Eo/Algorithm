import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static long result;
    static int n;
    static List<int[]> worms;
    static boolean[] visited;

    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            result = Long.MAX_VALUE;

            n = Integer.parseInt(br.readLine().trim());
            worms = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().trim().split(" ");
                worms.add(new int[2]);
                for (int j = 0; j < 2; j++) {
                    worms.get(i)[j] = Integer.parseInt(input[j]);
                }
            }

            visited = new boolean[n];

            // Optimize DFS to prevent unnecessary calls
            dfs(0, 0);
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void dfs(int idx, int cnt) {
        if (cnt == n / 2) {
            long totalWormX = 0;
            long totalWormY = 0;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    totalWormX += worms.get(i)[0];
                    totalWormY += worms.get(i)[1];
                } else {
                    totalWormX -= worms.get(i)[0];
                    totalWormY -= worms.get(i)[1];
                }
            }

            long tmp = totalWormX * totalWormX + totalWormY * totalWormY;
            result = Math.min(tmp, result);
            return;
        }

        // Iterate from current index to prevent redundant calculations
        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, cnt + 1); // Use i + 1 to avoid selecting the same worm
                visited[i] = false;
            }
        }
    }
}
