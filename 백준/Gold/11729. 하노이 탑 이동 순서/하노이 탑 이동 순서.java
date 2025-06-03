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
        
        hanoi(n, 1, 3, 2);
        
        bw.write(count + "\n");
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

	private static void hanoi(int n, int from, int to, int tmp) {
		if (n == 1) {
			count++;
			sb.append(from).append(" ").append(to).append("\n");
			return;
		}
		
		hanoi(n-1, from, tmp, to);
		
		count++;
		sb.append(from).append(" ").append(to).append("\n");
		
		hanoi(n-1, tmp, to, from);
	}
}
