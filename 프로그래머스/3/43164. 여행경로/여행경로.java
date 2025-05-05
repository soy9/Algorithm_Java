import java.util.*;

class Solution {
    
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> route = new LinkedList<>();

    public String[] solution(String[][] tickets) {
        
        for (String[] ticket : tickets) {
            graph.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }

        dfs("ICN");

        return route.toArray(new String[0]);
    }

    void dfs(String airport) {
        while (graph.containsKey(airport) && !graph.get(airport).isEmpty()) {
            dfs(graph.get(airport).poll());
        }
        route.addFirst(airport);
    }
}
