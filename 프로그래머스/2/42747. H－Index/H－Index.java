import java.util.*;
import java.math.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);        
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int hCandidate = n - i;    
            if (citations[i] >= hCandidate) {
                return hCandidate;    
            }
        }

        return 0;
    }
}