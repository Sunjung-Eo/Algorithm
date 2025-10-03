import java.util.*;

// 1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
// 2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
// 3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
//   3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(i);
        }
        
        int[] rank = priorities.clone();
        Arrays.sort(rank);
        int idx = rank.length - 1;
        int cnt = 0;
        
        while(!q.isEmpty()) {
            int tmp = q.poll();
            if (priorities[tmp] == rank[idx]) {                
                cnt++;               
                if (tmp == location) break;
                idx--;
            
            } else {
                q.add(tmp);
            }
        }    
        
        return cnt;
    }
}