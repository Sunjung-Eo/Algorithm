import java.util.*;
import java.math.*;

class Solution {
    public int solution(int[][] sizes) {
        int max = 0;
        int min = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int[] card = sizes[i];
            Arrays.sort(card);
            
            max = Math.max(max, card[0]);
            min = Math.max(min, card[1]);
        }
                
        return max * min;
    }
}