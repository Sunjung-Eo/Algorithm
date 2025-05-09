import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	int num = 1;
    	for (int i = 0; i < n; i++) {
    		num = Integer.parseInt(br.readLine());
    		if (num == 0) {
    			stack.pop();
    			continue;
    		}
    		
    		stack.add(num);
    	}
    	
    	int sum = 0;
    	for (int i : stack) {
    		sum += i;
    	}
    	System.out.println(sum);
        br.close();
    }
}
