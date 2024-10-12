class Solution {
    public int[] solution(int brown, int yellow) {
        int area = brown + yellow;
        
        for (int h = 3; h <= area / 3; h++) {
            if (area % h == 0) {
                int w = area / h;
                
                if (yellow == (w - 2) * (h - 2)) {
                    int[] answer = {w, h};
                    return answer;
                }
            }
        }
        
        return null;
    }
}