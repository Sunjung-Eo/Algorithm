import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> que = new ArrayDeque<Integer>();
        
        while (n-- > 0) {
        	String[] str = br.readLine().split(" ");
        	if (str[0].equals("push")) {
        		que.add(Integer.parseInt(str[1]));
        	}
        	
        	if (str[0].equals("pop")) {
        		if (!que.isEmpty()) {
        			sb.append(que.pollFirst()).append("\n");
        		} else {
        			sb.append("-1").append("\n");
        		}
        	}
        	
        	if (str[0].equals("size")) {
        		sb.append(que.size()).append("\n");
        	}
        	
        	if (str[0].equals("empty")) {
        		if (que.isEmpty()) {
        			sb.append("1").append("\n");
        		} else {
        			sb.append("0").append("\n");
        		}
        	}
        	
        	if (str[0].equals("front")) {
        		if (!que.isEmpty()) {
            		sb.append(que.peekFirst()).append("\n");
        		} else {
        			sb.append("-1").append("\n");
        		}
        		
        	}
        	
        	if (str[0].equals("back")) {
        		if (!que.isEmpty()) {
            		sb.append(que.peekLast()).append("\n");
        		} else {
        			sb.append("-1").append("\n");
        		}
        	}
        }
        
        bw.append(sb.toString());
        bw.flush();
        bw.close(); br.close();
    }
}
