import java.io.*;
import java.util.*;

public class Main {
	//3 16
	//소수를 한 줄에 하나씩 표현
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		while (n <= m) {
			boolean isDecimal = true;
			
			if (n==1) {
				isDecimal = false;
				
			} else { // 완탐으로 모두 계산할 경우 시간 초과 발생, 개선된 로직 필요
				for (int i = 2; i <= Math.sqrt(n); i++) {
		            if (n % i == 0) {
		            	isDecimal = false; 
		            }
		        }
			}
			
			if (isDecimal) {
				bw.append(Integer.toString(n)).append("\n");
			}
			n++;
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
