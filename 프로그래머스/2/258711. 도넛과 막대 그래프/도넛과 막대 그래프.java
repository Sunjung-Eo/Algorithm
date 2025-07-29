class Solution {
    public int[] solution(int[][] edges) {
        int max = 0;
        for (int[] e : edges) {
            if (e[0] > max) max = e[0];
            if (e[1] > max) max = e[1];
        }
        
        int[] inCnt  = new int[max + 1];
        int[] outCnt = new int[max + 1];
        for (int[] e : edges) {
            outCnt[e[0]]++;
            inCnt[e[1]]++;
        }
        
        int dummy = 0;
        for (int i = 1; i <= max; i++) {
            if (inCnt[i] == 0 && outCnt[i] >= 2) {
                dummy = i;
                break;
            }
        }
        
        int stickCnt = 0, eightCnt = 0;
        for (int i = 1; i <= max; i++) {
            if (inCnt[i] >= 1 && outCnt[i] == 0) {
                stickCnt++;
            } else if (inCnt[i] >= 2 && outCnt[i] == 2) {
                eightCnt++;
            }
        }
        
        int donutCnt = outCnt[dummy] - stickCnt - eightCnt;
        
        return new int[]{ dummy, donutCnt, stickCnt, eightCnt };
    }
}
