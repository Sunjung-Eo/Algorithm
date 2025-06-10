import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	static class Pair implements Comparable<Pair> {
		int key;
		String value;
		
		public Pair(int key, String value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(Pair o) {
			int res = Integer.compare(this.key, o.key);
			return res;
		}
		
	}
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		List<Pair> list = new ArrayList<Pair>();
		
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			list.add(new Pair(Integer.parseInt(line[0]), line[1]));
		}
		
		Collections.sort(list);
		
		for (Pair pair: list) {
			bw.write(pair.key + " " + pair.value + "\n");
		}
		
		bw.close();
		br.close();
	} 
}
