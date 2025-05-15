import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(str[i]);
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		int[] res = new int[n];

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				res[stack.pop()] = nums[i];
			}
			
			stack.add(i);
		}
		
		while (!stack.isEmpty()) {
			res[stack.pop()] = -1;
		}
		
		for (int i : res) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
