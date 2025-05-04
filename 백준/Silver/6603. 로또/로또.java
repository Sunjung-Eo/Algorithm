import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int size;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] line = br.readLine().split(" ");
            size = Integer.parseInt(line[0]);

            if (size == 0) break;

            nums = new int[size];
            for (int i = 0; i < size; i++) {
                nums[i] = Integer.parseInt(line[i + 1]);
            }

            isPicked(0, 0, "");
            bw.append("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void isPicked(int start, int count, String str) throws IOException {
        if (count == 6) {
            bw.append(str.trim()).append("\n");
            return;
        }

        for (int i = start; i < size; i++) {
            isPicked(i + 1, count + 1, str + nums[i] + " ");
        }
    }
}
