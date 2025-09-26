import java.util.*;
import java.math.*;

class Solution {
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        boolean[] visited = new boolean[tickets.length];
        ArrayList<String> route = new ArrayList<>(); 
        route.add("ICN");
        
        String[] answer = dfs(tickets, visited, route);
        return answer;
    }
    
    public String[] dfs(String[][] tickets, boolean[] visited, ArrayList<String> route) {
        boolean allUsed = true;
        for (boolean v : visited) if (!v) allUsed = false;

        if (allUsed) {
            return route.toArray(new String[0]);
        }

        String last = route.get(route.size() - 1);
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(last)) {
                visited[i] = true;
                route.add(tickets[i][1]);

                String[] result = dfs(tickets, visited, route);
                if (result != null) return result;

                route.remove(route.size() - 1);
                visited[i] = false;
            }
        }

        return null;
    }
}