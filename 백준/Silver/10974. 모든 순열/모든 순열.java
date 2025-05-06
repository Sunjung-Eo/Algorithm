import java.math.*;
import java.io.*;

public class Main {
    static StringBuilder sb;
    static int num;
    static boolean[] isPicked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        num =  Integer.parseInt(br.readLine());
        isPicked = new boolean[num + 1];
        permutation("", 0);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void permutation(String str, int count) {
        if (count == num) {
            sb.append(str).append("\n");
        }

        for (int i = 1; i <= num; i++) {
            if (!isPicked[i]) {
                isPicked[i] = true;
                permutation(str + Integer.toString(i) + " ", count + 1);
                isPicked[i] = false;
            }
        }
    }
}
