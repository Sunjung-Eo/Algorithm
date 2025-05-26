import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        
        LinkedList<Integer> arr = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
        	arr.add(i);
        }
        
        sb.append('<');
        int idx = 0;
        while (arr.size() > 1) {
        	idx = (idx + k - 1) % arr.size();
        	sb.append(arr.remove(idx)).append(", ");
        }
        
        sb.append(arr.remove()).append('>');
        bw.append(sb.toString());
        bw.flush();
        bw.close(); br.close();
    }
}
