import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> cnt = new HashMap<>();
        
        for (int i = 0; i < report.length; i++) {
            String[] tmp = report[i].split(" ");
            HashSet<String> set = map.getOrDefault(tmp[0], new HashSet<>());

            if (set.add(tmp[1])) {
                cnt.put(tmp[1], cnt.getOrDefault(tmp[1], 0) + 1);
            }
            map.put(tmp[0], set);
        }
        
        int[] answer = new int[id_list.length];
        for (int i = 0; i < answer.length; i++) {
            int count = 0;
            HashSet<String> set = map.getOrDefault(id_list[i], new HashSet<>());
            
            for (String s : set) {
                if (cnt.get(s) >= k) count++;
            }          
            answer[i] = count;
        }
        
        return answer;
    }
}