import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int n = prices.length;
        int[] answer = new int[n];
        stack.add(0);
        
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty()) {
                if (prices[i] < prices[stack.peek()]) {
                    int point = stack.peek();
                    answer[point] = i - point;
                    stack.pop();
                
                } else {
                    break;
                }
            }
            
            stack.add(i);
        }
        
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = n - 1 - idx;
        }
        
        return answer;
    }
}