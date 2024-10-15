import java.util.*;

class Solution {
    static String[] alphabet = {"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        
        dfs("");
        
        for (int i = 0; i < list.size(); i++) {
          if  (word.equals(list.get(i))) answer = i; 
        }
        
        return answer;
    }
    
    public static void dfs(String str) {
        list.add(str);
        
        if (str.length() == 5) {
            return;
        }
        
        for (int i = 0; i < alphabet.length; i++) {
            dfs(str + alphabet[i]);
        }
    }
}