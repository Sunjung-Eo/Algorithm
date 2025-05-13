import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int n = Integer.parseInt(br.readLine());
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	for (int i = 0; i < n; i++) {
    		String[] line = br.readLine().split(" ");
    		
    		if (line[0].equals("push")) {
    			stack.add(Integer.parseInt(line[1]));
    		} 
    		
    		if (line[0].equals("size")) {
    			sb.append(stack.size()).append("\n");
    		}
    		
    		if (line[0].equals("empty")) {
    			if (stack.isEmpty()) {
    				sb.append("1").append("\n");
    			} else {
    				sb.append("0").append("\n");
    			}
    		}
    		
    		if (line[0].equals("top")) {
    			if (!stack.isEmpty()) {
    				sb.append(Integer.toString(stack.peek())).append("\n");
    			} else {
    				sb.append("-1").append("\n");
    			}
    		}
    		
    		if (line[0].equals("pop")) {
    			if (!stack.isEmpty()) {
    				sb.append(Integer.toString(stack.pop())).append("\n");
    			} else {
    				sb.append("-1").append("\n");
    			}
    		}
    	}
    	
    	System.out.println(sb.toString());
        br.close();
    }
}
