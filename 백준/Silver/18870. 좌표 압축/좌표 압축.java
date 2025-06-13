import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split(" ");
        
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int v : sorted) {
            if (!map.containsKey(v)) {
                map.put(v, idx++);
            }
        }
        
        for (int v : nums) {
            bw.write(map.get(v) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
