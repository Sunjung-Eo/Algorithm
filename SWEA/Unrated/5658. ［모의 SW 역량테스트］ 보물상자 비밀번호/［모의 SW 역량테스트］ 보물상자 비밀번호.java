

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
	static TreeSet<Integer> password = new TreeSet<>();
	static String[] passwordStr;
	static int n;
	static int k;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			password.clear();
			
			sb.append("#").append(t).append(" ");
			
			String[] input = br.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			k = Integer.parseInt(input[1]);
			
			passwordStr = br.readLine().trim().split("");
			
			dfs(0);
			
		    int cnt = 0;
            for (int value : password.descendingSet()) {
            	cnt++;
            	if (cnt == k) {
            		sb.append(value).append("\n");
            		break;
            	}
            }
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void dfs(int idx) {
        if (idx == n / 4) {
            return;
        }

        String[] passwordStrTmp = new String[n];
        
        for (int i = 0; i + idx < n; i++) {
            passwordStrTmp[i] = passwordStr[i + idx];
        }
        
        for (int i = 0; i < idx; i++) {
            passwordStrTmp[n - idx + i] = passwordStr[i];
        }
        
        
        for (int i = 0; i < n; i += n / 4) {
            StringBuilder tmp = new StringBuilder();
            
            for (int j = 0; j < n / 4; j++) {
                tmp.append(passwordStrTmp[i + j]);
            }
            
            password.add(Integer.parseInt(tmp.toString(), 16));
        }
        
        dfs(idx + 1); 
    }
}