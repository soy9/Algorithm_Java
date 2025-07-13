import java.util.*;

class Solution {
    class Edge {
        int from, to, cost;
        
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    int[] parent;

    // 유니온 파인드에서 find 연산
    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // 유니온 연산
    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<Edge> edges = new ArrayList<>();
        
        for (int[] cost : costs) {
            edges.add(new Edge(cost[0], cost[1], cost[2]));
        }

        edges.sort((e1, e2) -> e1.cost - e2.cost);

        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (Edge edge : edges) {
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                answer += edge.cost;
            }
        }

        return answer;
    }
}
