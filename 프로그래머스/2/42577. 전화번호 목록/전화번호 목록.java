import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for (String s : phone_book) {
            set.add(s);
        }
        
        for (String s : phone_book) {
            String str = "";
            
            for (int i = 0; i < s.length() - 1; i++) {
                str += s.charAt(i);
                if (set.contains(str)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}