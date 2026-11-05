import java.util.*;

class Solution {
    public int solution(int[] citations) {
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < citations.length; i++) {
            tmp.add(citations[i]);
        }
        
        tmp.sort((a, b) -> b - a);
        int answer = 0;
        
        for (int i = 0; i < tmp.size(); i++) {
            if (i < tmp.get(i)) {
                answer = i + 1;
            } else {
                break;
            }
        }
        
        return answer;
    }
}