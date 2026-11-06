import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        
        // today split
        int[] ymd = new int[3];
        String[] tmp = today.split("\\.");
        for (int i = 0; i < 3; i++) {
            ymd[i] = Integer.parseInt(tmp[i]);
        }
        
        // terms split
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] t = terms[i].split(" ");
            map.put(t[0], Integer.parseInt(t[1]));
        }
        
        // cal
        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            String term = split[1];
            
            tmp = split[0].split("\\.");
            int[] day = new int[3];
            for (int j = 0; j < 3; j++) {
                day[j] = Integer.parseInt(tmp[j]);
            }
            
            int gap = map.get(term);
            int total = day[1] + gap - 1;
            day[0] += total / 12;
            day[1] = total % 12 + 1;
            
            if (ymd[0] > day[0]) {
                list.add(i + 1); continue;
            
            } else if (ymd[0] == day[0]) {
                if (ymd[1] > day[1]) {
                    list.add(i + 1); continue;  
                
                } else if (ymd[1] == day[1] && ymd[2] >= day[2]) {
                    list.add(i + 1); continue; 
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}