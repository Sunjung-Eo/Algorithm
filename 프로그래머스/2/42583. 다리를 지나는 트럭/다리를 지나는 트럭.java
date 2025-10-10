import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        int totalWeight = 0;
        int time = 0;
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        for (int i : truck_weights) {
            while (true) {
                int leftTruck = bridge.poll();
                totalWeight -= leftTruck;
                
                if (totalWeight + i <= weight) {
                    bridge.add(i);
                    totalWeight += i;
                    time++;
                    break;
                    
                } else {
                    bridge.add(0);
                    time++;
                }
            }
        }
        return time + bridge_length;
    }
}