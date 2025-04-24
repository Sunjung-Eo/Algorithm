import java.io.*;
import java.util.*;

public class Main {
	//4
	//	1 3 5 7
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] line = br.readLine().split(" ");
		int num = 0;
		int count = 0;
		boolean isDecimal = true;
		
		for (int i = 0; i < n; i++) {
			num = Integer.parseInt(line[i]);
			isDecimal = true;
			
			if (num == 1) {
				continue;
			}
			
			for (int j = 2; j <= Math.sqrt(num); j++) {
				if (num % j == 0) {
					isDecimal = false;
				}
			}
			
			if (isDecimal) count++;
		}
		
		System.out.println(count);
		br.close();
	}
}
