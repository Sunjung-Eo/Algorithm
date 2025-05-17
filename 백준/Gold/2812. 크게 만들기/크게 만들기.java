import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int removeCnt = Integer.parseInt(line[1]);
        char[] nums = br.readLine().toCharArray();

        int cnt = 0;
        Stack<Integer> stack = new Stack<>();

        for (char i : nums) {
            int num = Integer.parseInt(String.valueOf(i));

            while (cnt < removeCnt && !stack.empty() && stack.peek() < num) {
                stack.pop();
                cnt++;
            }

            stack.push(num);
        }
        
        while (cnt < removeCnt) {
            stack.pop();
            cnt++;
        }

        for (int i : stack ) {
            sb.append(i);
        }

        System.out.println(sb.toString());
        br.close();
    }
}
