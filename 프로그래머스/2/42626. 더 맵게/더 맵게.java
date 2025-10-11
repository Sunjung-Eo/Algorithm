import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> foods = new PriorityQueue<>();
        for (int i : scoville) {
            foods.add(i);
        }
        
        int cnt = 0;
        while (true) {
            if (foods.peek() >= K) break;
            if (foods.size() <= 1 && foods.peek() < K) {
                cnt = -1;
                break;
            }
            
            int first = foods.poll();
            int second = foods.poll();
            int makeFood = first + 2 * second;
            foods.add(makeFood);
            cnt++;
        }
        
        return cnt;
    }
}