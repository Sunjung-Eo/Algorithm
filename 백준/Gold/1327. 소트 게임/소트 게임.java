import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] target;

    public static class Node {
        int[] arr;
        int depth;

        Node(int[] arr, int depth) {
            this.arr = arr;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        StringBuilder sb = new StringBuilder();
        input = br.readLine().split(" ");
        int[] arr = new int[N];
        target = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            target[i] = i + 1;
        }

        System.out.println(bfs(new Node(arr, 0)));
    }

    private static int bfs(Node start) {
        Queue<Node> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.add(start);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (Arrays.equals(cur.arr, target)) {
                return cur.depth;
            }

            for (int i = 0; i <= N - K; i++) {
                int[] next = flip(cur.arr, i);
                String key = toKey(next);

                if (!visited.contains(key)) {
                    visited.add(key);
                    q.add(new Node(next, cur.depth + 1));
                }
            }
        }

        return -1;
    }

    private static String toKey(int[] next) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(next[i]);
        }
        return sb.toString();
    }

    private static int[] flip(int[] arr, int start) {
        int[] copy = arr.clone();
        int l = start, r = start + K - 1;
        while (l < r) {
            int tmp = copy[l];
            copy[l] = copy[r];
            copy[r] = tmp;
            l++;
            r--;
        }
        return copy;
    }
}