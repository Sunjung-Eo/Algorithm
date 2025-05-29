import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String ops = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();
            if (n > 0) {
                String inner = arr.substring(1, arr.length() - 1);
                String[] parts = inner.split(",");
                for (String s : parts) {
                    deque.add(Integer.parseInt(s));
                }
            }

            boolean isReversed = false;
            boolean error = false;
            for (char op : ops.toCharArray()) {
                if (op == 'R') {
                    isReversed = !isReversed;
                } else if (op == 'D') {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (isReversed) deque.pollLast();
                    else           deque.pollFirst();
                }
            }

            if (error) {
                sb.append("error\n");
            } else {
                sb.append("[");
                if (!deque.isEmpty()) {
                    if (isReversed) {
                        while (deque.size() > 1) {
                            sb.append(deque.pollLast()).append(",");
                        }
                        sb.append(deque.pollLast());
                    } else {
                        while (deque.size() > 1) {
                            sb.append(deque.pollFirst()).append(",");
                        }
                        sb.append(deque.pollFirst());
                    }
                }
                sb.append("]\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
