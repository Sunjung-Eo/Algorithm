import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	static int count;
	static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine()); 
        
        if (n > 20) {
        	BigInteger totalCount = BigInteger.ONE.shiftLeft(n).subtract(BigInteger.ONE);
            bw.write(totalCount.toString());
            bw.newLine();
        	
        } else {
        	hanoi(n, 1, 3, 2);
        	bw.write(count + "\n");
        	bw.write(sb.toString());
        }
        
        bw.close();
        br.close();
    }

	private static void hanoi(int n, int from, int to, int tmp) {
		if (n == 1) {
			sb.append(from).append(" ").append(to).append("\n");
			count++;
			return;
		}
		
		hanoi(n-1, from, tmp, to);
		sb.append(from).append(" ").append(to).append("\n");
		count++;
		
		hanoi(n-1, tmp, to, from);
	}
}
