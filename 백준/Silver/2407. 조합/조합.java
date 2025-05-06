import java.math.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int minus = n - m;

        BigInteger NFactorial = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            NFactorial = NFactorial.multiply(BigInteger.valueOf(i));
        }

        BigInteger MFactorial = BigInteger.ONE;
        for (int i = 1; i <= m; i++) {
            MFactorial = MFactorial.multiply(BigInteger.valueOf(i));
        }

        BigInteger MinusFactorial = BigInteger.ONE;
        for (int i = 1; i <= minus; i++) {
            MinusFactorial = MinusFactorial.multiply(BigInteger.valueOf(i));
        }

        BigInteger res = NFactorial.divide(MinusFactorial.multiply(MFactorial));
        System.out.println(res);
        br.close();
    }
}
