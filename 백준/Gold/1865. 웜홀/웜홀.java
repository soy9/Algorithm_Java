import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from;
        int to;
        int weight;
        
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int TC = Integer.parseInt(br.readLine());
         
        while(TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());    // node
            int M = Integer.parseInt(st.nextToken());    // edge
            int W = Integer.parseInt(st.nextToken());    // 웜홀
            
            List<Edge> edges = new ArrayList<>();
            
            // 도로
            for(int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken()); 
            
                edges.add(new Edge(S, E, T));
                edges.add(new Edge(E, S, T));
            }
            
            // 웜홀
            for(int w = 0; w < W; w++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken()) * (-1); 
            
                edges.add(new Edge(S, E, T));
            }
            
            boolean hasNegativeCycle = bellmanford(edges, N);

            System.out.println(hasNegativeCycle ? "YES" : "NO");
        }
        
	}
        
    static boolean bellmanford(List<Edge> originalEdges, int N) {
        List<Edge> edges = new ArrayList<>(originalEdges); 
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int i = 1; i <= N; i++) {
            edges.add(new Edge(0, i, 0));
        }
    
        for (int i = 0; i <= N; i++) {
            boolean updated = false;
            for (Edge edge : edges) {
                if (dist[edge.from] != Integer.MAX_VALUE &&
                    dist[edge.to] > dist[edge.from] + edge.weight) {
                    dist[edge.to] = dist[edge.from] + edge.weight;
                    updated = true;
                }
            }

            if (i == N && updated) return true;
        }

        return false;
    }
}