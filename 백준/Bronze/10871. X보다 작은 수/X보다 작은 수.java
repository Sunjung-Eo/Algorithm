import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int max = Integer.parseInt(input[1]);
		
		input = br.readLine().trim().split(" ");
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(input[i]);
			if (num < max) sb.append(num).append(" ");
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
