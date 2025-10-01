import java.util.*;
import java.math.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            stack.add(day);
        }
        
        ArrayList<Integer> tmp = new ArrayList<>();
        int cnt = 1;
        int day = -1;
        
        for (int i : stack) {
            if (day == -1) {
                day = i;
            
            } else if (day >= i) {
                cnt++;
            
            } else {
                tmp.add(cnt);
                day = i;
                cnt = 1;
            }
        }
        
        tmp.add(cnt);
        int[] answer = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }
        
        return answer;
    }
}