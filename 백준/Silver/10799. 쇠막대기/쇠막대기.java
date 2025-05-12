import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String line = br.readLine();
    	
    	Stack<Character> stack = new Stack<Character>();
    	int peacies = 0;
    	
    	for (int i = 0; i < line.length(); i++) {
    		if (line.charAt(i) == '(') {
    			stack.push('(');
    			
    		} else {
    			stack.pop();
    			
    			if (line.charAt(i-1) == '(') {
    				peacies += stack.size();
    				
    			} else {
    				peacies++;
    			}
    		}
    	}
    	
    	System.out.println(peacies);
        br.close();
    }
}
