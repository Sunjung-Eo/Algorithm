import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split("");
		int[] nums = new int[str.length];
		
		for (int i = 0; i < str.length; i++) {
			nums[i] = Integer.parseInt(str[i]);
		}
		
		Arrays.sort(nums);

		for (int i = nums.length - 1; i >= 0; i--) {
			bw.write(Integer.toString(nums[i]));
		}
		
		bw.close();
		br.close();
	} 
}
