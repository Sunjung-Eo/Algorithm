import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m;
	static int[] nums;
	static boolean[] isUsed;
	
    public static void main(String[] args) throws Exception {
		
        
        String[] line = br.readLine().split(" ");
        n  = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        
        nums = new int[n+1];
        for (int i = 0; i <= n; i++) {
        	nums[i] = i;
        }
        
        isUsed = new boolean[n+1];
        Arrays.fill(isUsed, false);
        
        isPicked(0, "");
        
        bw.append("\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void isPicked(int count, String sequence) throws Exception {
    	if (count == m) {
    		bw.append(sequence.trim()).append("\n");
    		return;
    	}
    	
    	for (int i= 1; i <= n; i++) {
    		if (!isUsed[i]) {
    			isUsed[i] = true;
    			isPicked(count + 1, sequence + i + " ");
    			isUsed[i] = false;
    		}
    	}
    }
}
