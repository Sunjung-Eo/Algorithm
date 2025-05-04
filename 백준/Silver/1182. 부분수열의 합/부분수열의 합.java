import java.util.*;
import java.io.*;

public class Main {
    static int n, s;
    static int[] nums;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        s  = Integer.parseInt(line[1]);

        line = br.readLine().split(" ");
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(line[i]);
        }

        dfs(0, 0, false);
        System.out.println(count);
        br.close();
    }

    private static void dfs(int idx, int sum, boolean isPicked) {
        if (idx == n) {
            if (sum == s && isPicked) {
                count++;
            }
            return;
        }

        dfs(idx + 1,  sum + nums[idx], true);
        dfs(idx + 1, sum, isPicked);
    }
}
