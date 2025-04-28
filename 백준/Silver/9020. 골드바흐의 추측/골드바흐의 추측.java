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
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
        	int num = Integer.parseInt(br.readLine());
        	int half = num / 2;
        	
        	while (half > 0) {
        		if (isPrime[half] && isPrime[num - half]) {
        			bw.append(Integer.toString(half)).append(" ").append(Integer.toString(num - half));
        			break;
        		}
        		
        		half--;
        	}
        	
        	bw.append("\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

}
