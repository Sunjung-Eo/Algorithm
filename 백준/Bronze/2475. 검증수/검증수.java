import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().trim().split(" ");
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			int n = Integer.parseInt(input[i]); 
			sum += n * n;
		}
		System.out.println(sum % 10);
	}

}
