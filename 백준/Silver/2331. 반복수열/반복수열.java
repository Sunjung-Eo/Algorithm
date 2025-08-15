import java.io.*;
import java.util.*;

public class Main {
    static int A, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        A = Integer.parseInt(input[0]);
        P = Integer.parseInt(input[1]);

        Map<Integer, Integer> visited = new HashMap<>();
        int current = A;
        int index = 0;

        while (!visited.containsKey(current)) {
            visited.put(current, index++);
            current = nextNumber(current);
        }

        System.out.println(visited.get(current));
    }

    static int nextNumber(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, P);
            num /= 10;
        }
        return sum;
    }
}
