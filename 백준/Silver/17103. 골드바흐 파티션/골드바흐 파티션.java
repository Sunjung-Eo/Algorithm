import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int max = 1000000;
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int test = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < test; i++) {
            String line = br.readLine();
            int num =  Integer.parseInt(line);

            for (int j = num - 2; j >= num/2; j--) {
                if (isPrime[j] && isPrime[num - j]) {
                    count++;
                }
            }

            sb.append(count).append("\n");
            count = 0;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
