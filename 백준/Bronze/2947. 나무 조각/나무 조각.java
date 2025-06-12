import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        
        String[] str = br.readLine().split(" ");
        int n = str.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        
        bubbleSort(nums);
        
        bw.close();
        br.close();
    }

    private static void bubbleSort(int[] nums) throws IOException {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    swapped = true;
                    
                    for (int k = 0; k < n; k++) {
                        bw.write(nums[k] + (k < n - 1 ? " " : ""));
                    }
                    bw.newLine();
                }
            }
            if (!swapped) break;
        }
    }
}
