import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        ArrayList<Map<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            Map<Integer, Integer> m = new HashMap<>();
            m.put(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
            list.add(m);
        }

        ArrayList<Map<Integer, Integer>> dp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> item = list.get(i);
            int wt = item.keySet().iterator().next();
            int val = item.get(wt);

            Map<Integer, Integer> curr = new HashMap<>();
            if (wt <= k) {
                curr.put(wt, val);
            }

            for (int j = 0; j < i; j++) {
                for (Map.Entry<Integer, Integer> e : dp.get(j).entrySet()) {
                    int newW = e.getKey() + wt;
                    int newV = e.getValue() + val;
                    if (newW <= k) {
                        curr.merge(newW, newV, Math::max);
                    }
                }
            }

            dp.add(curr);
        }

        int answer = 0;
        for (Map<Integer, Integer> m : dp) {
            for (int v : m.values()) {
                answer = Math.max(answer, v);
            }
        }
        System.out.println(answer);
    }
}
