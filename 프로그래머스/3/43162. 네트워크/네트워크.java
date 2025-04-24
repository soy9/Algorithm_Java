import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int len = computers[0].length;
        boolean[] visited = new boolean[len];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < len; i++) {
            if(visited[i]) {
                continue;
            }
            q.add(i);
            visited[i] = true;
            
            while(!q.isEmpty()) {
                int now = q.poll();
                
                for(int next = 0; next < len; next++) {
                    if(now == next) {
                        continue;
                    }
                    if(computers[now][next] == 1 && !visited[next]) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
            
            answer++;
        }
        
        return answer;
    }
}