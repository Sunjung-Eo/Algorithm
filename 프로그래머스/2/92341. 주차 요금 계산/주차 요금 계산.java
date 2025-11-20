import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();

        for (String record : records) {
            String[] arr = record.split(" ");
            String[] hm = arr[0].split(":");

            int time = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
            String car = arr[1];
            String state = arr[2];

            if (state.equals("IN")) {
                inTime.put(car, time);
                
            } else {
                int diff = time - inTime.get(car);
                totalTime.put(car, totalTime.getOrDefault(car, 0) + diff);
                inTime.remove(car);
            }
        }

        for (String car : inTime.keySet()) {
            int diff = (23 * 60 + 59) - inTime.get(car);
            totalTime.put(car, totalTime.getOrDefault(car, 0) + diff);
        }

        List<String> cars = new ArrayList<>(totalTime.keySet());
        Collections.sort(cars);

        int[] answer = new int[cars.size()];

        for (int i = 0; i < cars.size(); i++) {
            int t = totalTime.get(cars.get(i));
            answer[i] = calcFee(t, fees);
        }

        return answer;
    }

    private int calcFee(int time, int[] fees) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (time <= baseTime) return baseFee;
        time -= baseTime;

        int units = (time + unitTime - 1) / unitTime; 
        return baseFee + units * unitFee;
    }
}
