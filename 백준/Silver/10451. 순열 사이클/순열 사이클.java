import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] arr = new int[n+1];

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(str[i-1]);
            }

            Deque<Integer> stack = new ArrayDeque<>();
            boolean[] visited = new boolean[n+1];
            int res = 0;

            for (int i = 1; i <= n; i++) {
                if (!visited[arr[i]]) {
                    res++;
                    visited[arr[i]] = true;
                    stack.push(arr[i]);
                }

                while (!stack.isEmpty()) {
                    int curr = stack.pop();

                    if (!visited[arr[curr]]) {
                        visited[arr[curr]] = true;
                        stack.push(arr[curr]);
                    }
                }
            }

            System.out.println(res);
        }

        br.close();
    }
}
