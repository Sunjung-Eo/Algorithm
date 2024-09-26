import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().trim().split(" ");
        
        long N = Long.parseLong(input[0]);
        int K = Integer.parseInt(input[1]);
        long T = Long.parseLong(input[2]);
        
        String[] line = br.readLine().trim().split(" ");
        
        List<Long> nums = new ArrayList<>();
        
        for (String s : line) {
            nums.add(Long.parseLong(s));
        }
        
        Collections.sort(nums);
        
        int count = 0;
        while (count < K) {
            int low = 0;
            int high = nums.size() - 1;
            long max = -1;
            int removeIdx = -1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums.get(mid) < T) {
                    max = nums.get(mid);
                    removeIdx = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (max == -1) break;

            T += max;
            count++;

            nums.remove(removeIdx);
        } 

        System.out.println(T);
    }
}