import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        isPicked(1, 0, "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void isPicked(int start, int cnt, String str) throws IOException {
        if (cnt == m) {
            bw.append(str.trim()).append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            isPicked(i + 1, cnt + 1, str + i + " ");
        }
    }
}
