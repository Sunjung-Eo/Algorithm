import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);
        int gcd = nums[1] - nums[0];
        for (int i = 2; i < n; i++) {
            gcd = getGcd(gcd, nums[i] - nums[i-1]);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(gcd); i++) {
            if (gcd % i == 0) {
                res.add(i);

                if (i != gcd/i) {
                    res.add(gcd/i);
                }
            }
        }
        res.add(gcd);
        Collections.sort(res);
        for (int m : res) {
            System.out.print(m + " ");
        }
    }

    private static int getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }
}