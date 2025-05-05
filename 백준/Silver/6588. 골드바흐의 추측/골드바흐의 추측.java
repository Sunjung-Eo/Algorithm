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

        String line =  br.readLine();
        while (line != null && !line.equals("0")) {
            int num = Integer.parseInt(line);
            int a = 0, b = 0;

            for (int i = num - 2; i >= num / 2; i--) {
                if (isPrime[i] && isPrime[num - i]) {
                    b = i;
                    a = num - i;
                    break;
                }
            }

            if (a == 0 && b == 0) {
                sb.append("Goldbach's conjecture is wrong.").append("\n");
                line = br.readLine();
                continue;
            }

            sb.append(line).append(" = ").append(Integer.toString(a)).append(" + ").append(Integer.toString(b)).append("\n");
            line = br.readLine();
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
