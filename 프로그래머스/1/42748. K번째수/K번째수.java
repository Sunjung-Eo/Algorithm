import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length]; 

        for (int i = 0; i < commands.length; i++) {
            int[] set = commands[i];
            ArrayList<Integer> temp = new ArrayList<>();

            for (int j = set[0] - 1; j < set[1]; j++) {
                temp.add(array[j]);
            }

            Collections.sort(temp);
            answer[i] = temp.get(set[2] - 1); 
        }

        return answer;
    }
}
