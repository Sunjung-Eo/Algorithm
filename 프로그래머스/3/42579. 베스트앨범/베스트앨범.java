import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Map<Integer, Integer>> list = new HashMap<>();
        Map<String, Integer> sum = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (!list.containsKey(genres[i])) {
                list.put(genres[i], new HashMap<>());
            }
            list.get(genres[i]).put(i, plays[i]);
            sum.put(genres[i], sum.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(sum.entrySet());
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : entryList) {
            List<Map.Entry<Integer, Integer>> ans = new ArrayList<>(list.get(entry.getKey()).entrySet());
            ans.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            for (int j = 0; j < Math.min(2, ans.size()); j++) {
                answer.add(ans.get(j).getKey()); 
            }
        }
        
        Integer[] integerArray = answer.toArray(new Integer[0]);

        int[] intArray = new int[integerArray.length];
        for (int i = 0; i < integerArray.length; i++) {
            intArray[i] = integerArray[i]; 
        }

        return intArray;
    }
}