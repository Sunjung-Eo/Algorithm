import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int maxNum = 0;
        
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (nums[i] > maxNum) {
                maxNum = nums[i];
            }
        }

        int size = maxNum + 1;
        int[] sum0 = new int[size];
        int[] sum1 = new int[size];

        sum0[0] = 1;
        sum1[0] = 0;
        if (size > 1) {
            sum0[1] = 0;
            sum1[1] = 1;
        }

        for (int i = 2; i < size; i++) {
            sum0[i] = sum0[i-1] + sum0[i-2];
            sum1[i] = sum1[i-1] + sum1[i-2];
        }

        for (int num : nums) {
            sb.append(sum0[num]).append(" ").append(sum1[num]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
