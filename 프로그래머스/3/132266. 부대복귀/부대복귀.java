import java.util.*;

class Solution {
    LinkedList<Integer>[] roadsList = null;
    int[] distance = null;
    boolean[] visited = null;
    
    void bfs(int destination) {
        Queue<Integer> q = new LinkedList<>();
        
        int size = roadsList[destination].size();
        for(int i = 0; i < size; i++) {
            int next = roadsList[destination].get(i);
            q.add(next);
            visited[next] = true;
            distance[next] = 1;
        }
        
        while(!q.isEmpty()) {
            int pos = q.poll();
            size = roadsList[pos].size();
            for(int i = 0; i < size; i++) {
                int next = roadsList[pos].get(i);
                if(visited[next] && distance[next] <= distance[pos] + 1) {
                    continue;
                }
                
                distance[next] = distance[pos] + 1;
                visited[next] = true;
                q.add(next);
            }
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        roadsList = new LinkedList[n + 1];
        
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        
        for(int i = 1; i <= n; i++) {
            distance[i] = -1;
            roadsList[i] = new LinkedList<Integer>();
        }
        distance[destination] = 0;
        visited[destination] = true;
        
        for(int i = 0; i < roads.length; i++) {
            roadsList[roads[i][0]].add(roads[i][1]);
            roadsList[roads[i][1]].add(roads[i][0]);
        }
        
        bfs(destination);
        
        for(int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }
        
        return answer;
    }
}