import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] durability = new int[2 * n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] robot = new boolean[n];
        int step = 0;

        while (true) {
            step++;

            int last = durability[2 * n - 1];
            for (int i = 2 * n - 1; i > 0; i--) {
                durability[i] = durability[i - 1];
            }
            durability[0] = last;

            for (int i = n - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[n - 1] = false;

            for (int i = n - 2; i >= 0; i--) {
                if (robot[i] && !robot[i + 1] && durability[i + 1] > 0) {
                    robot[i] = false;
                    robot[i + 1] = true;
                    durability[i + 1]--;
                }
            }
            robot[n - 1] = false;

            if (durability[0] > 0) {
                robot[0] = true;
                durability[0]--;
            }

            int count = 0;
            for (int d : durability) {
                if (d == 0) count++;
            }
            if (count >= k) break;
        }

        System.out.println(step);
    }
}
