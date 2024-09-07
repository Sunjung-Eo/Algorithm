
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine().trim());
        String[] input = br.readLine().trim().split(" ");
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(input[i]);

            while (!stack.isEmpty() && stack.peek()[0] <= height) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek()[1] + 1; 
            } else {
                result[i] = 0;
            }

            stack.push(new int[]{height, i});
        }

        for (int i : result) {
            sb.append(i).append(" ");
        }
        bw.write(sb.toString().trim());
        bw.close();
        br.close();
    }

}
