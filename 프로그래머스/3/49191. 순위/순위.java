import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        Set<Integer>[] win = new HashSet[n + 1];  // 나를 이긴 사람들
        Set<Integer>[] lose = new HashSet[n + 1]; // 나에게 진 사람들
        
        for(int i = 1; i <= n; i++) {
            win[i] = new HashSet<Integer>();
            lose[i] = new HashSet<Integer>();
        }
        
        for(int i = 0; i < results.length; i++) {
            win[results[i][0]].add(results[i][1]);
            lose[results[i][1]].add(results[i][0]);
        }
        
        for(int i = 1; i <= n; i++) {
            int winCnt = dfs(win, i, n);
            int loseCnt = dfs(lose, i, n);
            
            if(winCnt + loseCnt == n - 1) {
                answer ++;
            }
        }
        
       
        return answer;
    }
    int dfs(Set<Integer>[] set, int i, int n) {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[n + 1];
        visited[i] = true;
        
        for(Integer w : set[i]) {
            q.add(w);
            cnt++;
            visited[w] = true;
        }
        
        while(!q.isEmpty()) {
            int num = q.poll();
            
            for(Integer s : set[num]) {
                if(!visited[s]) {
                    cnt++;
                    visited[s] = true;
                    q.add(s);
                }
            }
        }
        
        return cnt;
    }
}