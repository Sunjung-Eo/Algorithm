import java.util.*;
import java.math.*;

class Solution {
    int cnt = 0;
    int[] nums;
    
    public int solution(int[] numbers, int target) {
        nums = numbers;
        int[] visited = new int[nums.length];
        
        dfs(visited, target, 0);
        
        return cnt;
    }
    
    public void dfs(int[] visited, int target, int index) {
        if (index == visited.length) {
            int sum = 0;
            
            for (int i : visited) {
                sum += i;
            }
            
            if (sum == target) cnt++;
            return;
        }
        
        visited[index] = nums[index];
        dfs(visited, target, index + 1);
        
        visited[index] = -1 * nums[index];
        dfs(visited, target, index + 1);
    }
}