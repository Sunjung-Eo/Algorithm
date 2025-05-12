import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuffer sb = new StringBuffer();
    	
    	int n = Integer.parseInt(br.readLine());
    	Stack<Integer> stack = new Stack<Integer>();
    	boolean impossible = false;
    	int current = 1;
    	
    	for (int i = 0; i < n; i++) {
    		int target = Integer.parseInt(br.readLine());
    		while (current <= target) {
    			stack.push(current++);
    			sb.append("+\n");
    		}
    		
    		if (!stack.isEmpty() && stack.peek() == target) {
    			stack.pop();
    			sb.append("-\n");
    		} else {
    			impossible = true;
    			break;
    		}
    	}
    	
    	if (!impossible) {
    		System.out.println(sb.toString());
    	} else {
    		System.out.println("NO");
    	}
    	
        br.close();
    }
}
