import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int n = Integer.parseInt(br.readLine());
    	int[] nums = new int[n];
    	
    	for (int i = 0; i < n; i++) {
    		nums[i] = Integer.parseInt(br.readLine());
    	}
    	
    	Arrays.sort(nums);
        
        for (int num : nums) {
            bw.write(num + "\n");
        }
    	
    	bw.close();
    	br.close();
    }
}
