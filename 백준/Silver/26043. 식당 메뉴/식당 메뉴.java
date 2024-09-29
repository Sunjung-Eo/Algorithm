import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static class Student {
        int number;
        int favoriteMenu;

        Student(int number, int favoriteMenu) {
            this.number = number;
            this.favoriteMenu = favoriteMenu;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        Queue<Student> queue = new LinkedList<>();
        Map<Integer, Integer> preferences = new HashMap<>();
        List<Integer> resultA = new ArrayList<>();
        List<Integer> resultB = new ArrayList<>();
        List<Integer> resultC = new ArrayList<>();
        
        for (int i = 0; i < T; i++) {
            String[] line = br.readLine().trim().split(" ");
            int type = Integer.parseInt(line[0]);
            
            if (type == 1) {
                int studentNum = Integer.parseInt(line[1]);
                int favoriteMenu = Integer.parseInt(line[2]);
                queue.add(new Student(studentNum, favoriteMenu));
                preferences.put(studentNum, favoriteMenu);
                
            } else if (type == 2) {
                int menuNum = Integer.parseInt(line[1]);
                
                if (!queue.isEmpty()) {
                    Student currentStudent = queue.poll();
                    int studentNum = currentStudent.number;
                    int favoriteMenu = currentStudent.favoriteMenu;
                    
                    if (favoriteMenu == menuNum) {
                        resultA.add(studentNum);
                    } else {
                        resultB.add(studentNum);
                    }
                }
            }
        }
        
        while (!queue.isEmpty()) {
            resultC.add(queue.poll().number);
        }
        
        Collections.sort(resultA);
        Collections.sort(resultB);
        Collections.sort(resultC);
        
        appendResults(sb, resultA);
        appendResults(sb, resultB);
        appendResults(sb, resultC);
        
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void appendResults(StringBuilder sb, List<Integer> result) {
        if (result.isEmpty()) {
            sb.append("None\n");
        } else {
            result.forEach(num -> sb.append(num).append(" "));
            sb.append("\n");
        }
    }
}
