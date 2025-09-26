import java.util.*;
import java.math.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int oneCnt = 0;
        int twoCnt = 0;
        int threeCnt = 0;
        for (int i = 0; i < answers.length; i++) {
            if (one[i % 5] == answers[i]) oneCnt++;
            if (two[i % 8] == answers[i]) twoCnt++;
            if (three[i % 10] == answers[i]) threeCnt++;
        }
        
        int max = Math.max(oneCnt, twoCnt);
        max = Math.max(max, threeCnt);
        
        ArrayList<Integer> ans = new ArrayList<>();
        if (max == oneCnt) ans.add(1);
        if (max == twoCnt) ans.add(2);
        if (max == threeCnt) ans.add(3);
        
        Collections.sort(ans);
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}