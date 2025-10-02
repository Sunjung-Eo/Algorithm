import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        if (s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(') return !answer;
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.add(s.charAt(i));
        }
        
        Stack<Character> tmp = new Stack<>();    
        
        while(answer && !stack.isEmpty()) {
            char c = stack.pop();
            
            if (c == ')') {
                if (stack.peek() == ')') {
                    tmp.add(c);         
                } else {
                    stack.pop(); 
                }
                
            } else {
                if (!tmp.isEmpty()) {
                    tmp.pop();
                } else {
                    answer = false;
                    break;
                }
            }            
        }

        return answer;
    }
}