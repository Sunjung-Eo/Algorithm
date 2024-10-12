class Solution {
    public int[] solution(int brown, int yellow) {
        int area = brown + yellow;
        int h = 3;
        int w = area / h;
        
        for (int i = h; i < w; i++) {
            h = i;
            w = area / h;
            
            if (area % h == 0 && yellow == (w-2) * (h-2)) {
               break; 
            }
        }
        
        int[] answer = {w, h};
        return answer;
    }
}