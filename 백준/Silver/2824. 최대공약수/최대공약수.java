import java.math.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        BigInteger a = BigInteger.ONE;
        for (String s : line) {
            a = a.multiply(new BigInteger(s));
        }

        n = Integer.parseInt(br.readLine());
        line = br.readLine().split(" ");
        BigInteger b = BigInteger.ONE;
        for (String s : line) {
            b = b.multiply(new BigInteger(s));
        }

        BigInteger res = a.gcd(b);

        String resStr = res.toString();

        if (resStr.length() > 9) {
            System.out.println(resStr.substring(resStr.length() - 9));
        } else {
            System.out.println(resStr);
        }

        br.close();
    }
}
