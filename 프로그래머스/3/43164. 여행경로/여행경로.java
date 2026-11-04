import java.util.*;

class Solution {
    static String[][] tickets;
    static boolean[] visited;
    static String[] answer;
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        visited = new boolean[tickets.length];
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs("ICN", path);
        
        return answer;
    }
    
    public boolean dfs(String cur, List<String> path) {
        if (path.size() == tickets.length + 1) {
            answer = path.toArray(new String[0]);
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(cur)) {
                path.add(tickets[i][1]);
                visited[i] = true;
                
                if (dfs(tickets[i][1], path)) return true;
                
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
        
        return false;
    }
}