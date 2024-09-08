
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int k;
    static List<int[]> magneticList = new ArrayList<>();
    static List<int[]> toDoList = new ArrayList<>();

    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            magneticList.clear();
            toDoList.clear();

            k = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < 4; i++) {
                String[] input = br.readLine().trim().split(" ");
                int[] magnetic = new int[8];

                for (int j = 0; j < input.length; j++) {
                    magnetic[j] = Integer.parseInt(input[j]);
                }

                magneticList.add(magnetic);
            }

            for (int i = 0; i < k; i++) {
                String[] input = br.readLine().trim().split(" ");
                int[] toDo = new int[2];

                for (int j = 0; j < input.length; j++) {
                    toDo[j] = Integer.parseInt(input[j]);
                }

                toDoList.add(toDo);
            }

            for (int i = 0; i < k; i++) {
                int[] toDo = toDoList.get(i);
                int num = toDo[0] - 1; 
                int dir = toDo[1];
                rotate(num, dir, new boolean[4]);
            }

            int result = 0;
            for (int i = 0; i < 4; i++) {
                if (magneticList.get(i)[0] == 1) result += (int) Math.pow(2, i);
            }
            sb.append("#").append(t).append(" ").append(result).append("\n");
        
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void rotate(int num, int dir, boolean[] visited) {
        visited[num] = true;

        if (num > 0 && !visited[num - 1] && magneticList.get(num)[6] != magneticList.get(num - 1)[2]) {
            rotate(num - 1, -dir, visited);
        }

        if (num < 3 && !visited[num + 1] && magneticList.get(num)[2] != magneticList.get(num + 1)[6]) {
            rotate(num + 1, -dir, visited);
        }

        if (dir == 1) { 
            clockwise(num);
        } else {  
            counterClockwise(num);
        }
    }

    static void clockwise(int num) {
        int[] magnetic = magneticList.get(num);
        int last = magnetic[7];
        for (int i = 7; i > 0; i--) {
            magnetic[i] = magnetic[i - 1];
        }
        magnetic[0] = last;
    }

    static void counterClockwise(int num) {
        int[] magnetic = magneticList.get(num);
        int first = magnetic[0];
        for (int i = 0; i < 7; i++) {
            magnetic[i] = magnetic[i + 1];
        }
        magnetic[7] = first;
    }
}
