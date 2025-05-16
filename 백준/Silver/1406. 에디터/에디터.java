import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        String initial = br.readLine();
        int n = Integer.parseInt(br.readLine());
        
        Deque<Character> left = new ArrayDeque<Character>();
        Deque<Character> right = new ArrayDeque<Character>();
        
        for (char c : initial.toCharArray()) {
        	left.add(c);
        }
        
        while (n-- > 0) {
        	String[] line = br.readLine().split(" ");
        	
        	if (line[0].equals("L")) {
        		if (!left.isEmpty()) {
        			right.addLast(left.pollLast());
        		}
        	}
        	
        	if (line[0].equals("D")) {
        		if (!right.isEmpty()) {
        			left.addLast(right.pollLast());
        		}
        	}
        	
        	if (line[0].equals("P")) {
        		left.add(line[1].charAt(0));
        	}
        	
        	if (line[0].equals("B")) {
        		if (!left.isEmpty()) {
        			left.pollLast();
        		}
        	}
        }
        
        while (!left.isEmpty()) {
    		sb.append(left.pollFirst());
        }
        
        while (!right.isEmpty()) {
        	sb.append(right.pollLast());
        }
        
        bw.append(sb.toString());
        bw.flush();
        bw.close(); br.close();
    }
}
