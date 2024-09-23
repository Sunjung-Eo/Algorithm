import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine().trim();
			arr[i] = Integer.parseInt(input);
		}
		
		int result = 1;
		int max = arr[arr.length-1];
		
		for (int i = arr.length-1; i >= 0; i--) {
			if (max < arr[i]) result ++;
			max = Math.max(max, arr[i]);
		}	
		
		System.out.println(result);
		
	}

}


