import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty())  stack.add(arr[i]);
            if (stack.peek() == arr[i]) continue;
            
            stack.add(arr[i]);
        }
        
        int[] ans = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        
        return ans;
    }
}