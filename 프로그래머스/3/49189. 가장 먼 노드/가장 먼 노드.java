import java.util.*;

class Solution {
    List<Integer>[] list = null;
    int[] distance = null;
    boolean[] visited = null;
    int max = 0;
    int answer = 0;
    
    void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[1] = true;
        
        while(!q.isEmpty()) {
            int n = q.poll();
            
            for(int i : list[n]) {
                if(!visited[i]) {
                    visited[i] = true;
                    distance[i] = distance[n] + 1;
                    if(max == distance[i]) {
                        answer++;
                    } else if(max < distance[i]) {
                        max = distance[i];
                        answer = 1;
                    }
                    q.add(i);
                }
            }
        }
    }
    
    public int solution(int n, int[][] edge) {
        list = new List[n + 1];
        
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        
        for(int i = 0; i < edge.length; i++) {
            
            for(int j = 0; j < 2; j++) {
                if(list[edge[i][j]] == null) {
                    list[edge[i][j]] = new LinkedList<>();
                }  
                list[edge[i][j]].add(edge[i][(1 + j) % 2]);
            }
        }
        
        bfs(1);
        
        return answer;
    }
}