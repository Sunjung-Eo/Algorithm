import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for (int i = 0; i < n; i++) {
        	int x = Integer.parseInt(br.readLine());
        	
        	if (x == 0) {
        		if (que.isEmpty()) {
        			sb.append("0").append("\n");
        	
        		} else {
        			sb.append(que.poll()).append("\n");
        		}
        	
        	} else {
        		que.add(x);
        	}
        }
        
        bw.append(sb.toString());
        bw.flush();
        bw.close(); br.close();
    }
}
