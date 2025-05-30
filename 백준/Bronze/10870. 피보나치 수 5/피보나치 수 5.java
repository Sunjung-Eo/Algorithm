import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static List<Integer> nums = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        if (n < 2) {
        	System.out.println(n);
        	return;
        }
        
        nums.add(0);
        nums.add(1);
        
        System.out.println(pivo(0, 1));
        br.close();
    }
    
    public static Integer pivo(int start, int next) {
    	if (nums.size() > n) {
    		return nums.get(nums.size() - 1);
    	}
    	nums.add(nums.get(start) + nums.get(next));
    	return pivo(start + 1, next + 1);
    }
}
