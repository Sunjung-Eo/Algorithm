import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 1000000;
        
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int[] primeCount = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            primeCount[i] = primeCount[i - 1] + (isPrime[i] ? 1 : 0);
        }

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;
            
            int result = primeCount[2 * num] - primeCount[num];
            bw.append(Integer.toString(result)).append("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
