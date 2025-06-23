import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        List<String> strs = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
        	strs.add(br.readLine());
        }
        
        strs.sort((o1, o2) -> {
        	int lenDiff = o1.length() - o2.length();
            if (lenDiff != 0) {
                return lenDiff;  
            }
        	
        	int a = 0, b = 0;
        	
        	for (int i = 0; i < o1.length(); i++) {
        		int n1 = o1.charAt(i) - '0';
        		int n2 = o2.charAt(i) - '0';
        		
        		if (n1 > 0 & n1 < 10) a += n1;
        		if (n2 > 0 & n2 < 10) b += n2;        		
        	}
        	
        	if (a == b) {
        		return o1.compareToIgnoreCase(o2);
        	}
        	
        	return a - b;
        });
        
        for (String s : strs) {
        	bw.append(s).append("\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
