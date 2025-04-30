import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	for (int i = 2; i <= Math.sqrt(n); i++) {
    		if (n == 1) return;
    		
    		while (n % i == 0) {
    			bw.append(Integer.toString(i)).append("\n");
    			n /= i;
    		}
    	}
        
    	if (n != 1) {
        	bw.append(Integer.toString(n));
    	}
        bw.flush();
        bw.close();
        br.close();
    }
}
