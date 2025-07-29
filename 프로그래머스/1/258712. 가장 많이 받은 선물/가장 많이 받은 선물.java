import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        int[][] board = new int[n][n];
        List<String> name = Arrays.asList(friends);
        
        for (int i = 0; i < gifts.length; i++) {
            String[] str = gifts[i].split(" ");
            int from = name.indexOf(str[0]); 
            int to = name.indexOf(str[1]);   
            board[from][to]++;
        }
        
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            int row = 0;
            int col = 0;
            
            for (int j = 0; j < n; j++) {
                row += board[i][j];
                col += board[j][i];
            }
            
            index[i] = row - col;
        }
        
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            
            for (int j = 0; j < n; j++) {
                if (board[i][j] > board[j][i]) {
                    cnt ++;
                    
                } else if (board[i][j] == board[j][i] && index[i] > index[j]) {
                    cnt++;
                }
            }
            
            answer = Math.max(cnt, answer);
        }
        return answer;
    }
}