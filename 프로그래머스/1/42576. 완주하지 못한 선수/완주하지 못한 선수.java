import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> list = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            list.put(participant[i], list.getOrDefault(participant[i], 0) + 1);
        }
        
        for (int j = 0; j < completion.length; j++) {
            list.put(completion[j], list.get(completion[j]) - 1);
        }
        
        String answer = "";
        for (String name : list.keySet()) {
            if (list.get(name) > 0) {
                answer += name;
                break;
            }
        }
        return answer;
    }
}