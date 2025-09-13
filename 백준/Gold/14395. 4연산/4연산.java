import java.io.*;
import java.util.*;

public class Main {
    static long s, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Long.parseLong(st.nextToken());
        t = Long.parseLong(st.nextToken());

        if (s == t) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs());
    }

    private static String bfs() {
        Queue<Long> q = new ArrayDeque<>();
        Queue<String> ops = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();

        q.add(s);
        ops.add("");
        visited.add(s);

        while (!q.isEmpty()) {
            long cur = q.poll();
            String curOps = ops.poll();

            if (cur == t) {
                return curOps;
            }

            long[] nextVals = {cur * cur, cur + cur, cur - cur, (cur != 0 ? cur / cur : -1)};
            char[] symbols = {'*', '+', '-', '/'};

            for (int i = 0; i < 4; i++) {
                long next = nextVals[i];
                if (next < 1 || next > 1_000_000_000L) continue;
                if (visited.contains(next)) continue;

                visited.add(next);
                q.add(next);
                ops.add(curOps + symbols[i]);
            }
        }
        return "-1";
    }
}
