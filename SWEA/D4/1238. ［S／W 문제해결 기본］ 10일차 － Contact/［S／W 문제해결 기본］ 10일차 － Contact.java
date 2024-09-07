import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {
    static ArrayDeque<Integer> q = new ArrayDeque<>();
    static ArrayList<Integer>[] arr;
    static int result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t < 11; t++) {
            result = 0;
            String[] input = br.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int start = Integer.parseInt(input[1]);

            arr = new ArrayList[101];
            visited = new boolean[101];

            for (int i = 0; i < 101; i++) {
                arr[i] = new ArrayList<>();
            }

            String[] ftw = br.readLine().split(" ");
            for (int i = 0; i < n / 2; i++) {
                int from = Integer.parseInt(ftw[2 * i]);
                int to = Integer.parseInt(ftw[2 * i + 1]);
                arr[from].add(to);
            }

            bfs(start);
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void bfs(int start) {
        q.offer(start);
        visited[start] = true;
        int max = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            max = 0;

            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                max = Math.max(max, cur);

                for (int next : arr[cur]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            result = max;
        }
    }
}
