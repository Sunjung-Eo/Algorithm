import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			char[] str = br.readLine().toCharArray();
			boolean check = true;
			
			for (int j = 0; j < str.length; j++) {
				if (str[j] == '(') {
					stack.add(str[j]);
					continue;
				}
				
				if (!stack.empty()) {
					stack.pop();
					
				} else {
					check = false;
					sb.append("NO").append("\n");
					break;
				}
			}
			
			if (check) {
				if (stack.isEmpty()) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}	
			}
			
			stack.clear();
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
