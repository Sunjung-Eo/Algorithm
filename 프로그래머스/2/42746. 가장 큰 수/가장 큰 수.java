import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] strNums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNums[i] = String.valueOf(numbers[i]);   
        }
        
        Arrays.sort(strNums, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            } 
        });
        
        for (String s : strNums) {
            answer += s;
        }
        
        if (answer.charAt(0) == '0') return "0"; 
        return answer;
    }
}