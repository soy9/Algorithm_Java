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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());    // node
        int M = Integer.parseInt(st.nextToken());    // edge
        
        List<Edge> edges = new ArrayList<>();
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            edges.add(new Edge(from, to , weight));
        }
        // input end

        // bellmanford
		for (int i = 1; i < N; i++) {
            for(Edge edge : edges) {
                if(dist[edge.from] != Long.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.weight) {
                    dist[edge.to] = dist[edge.from] + edge.weight;
                }
            }
		}
        
        boolean hasCycle = false;
        for(Edge edge : edges) {
            if(dist[edge.from] != Long.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.weight) {
                hasCycle = true;
                break;
            }
        }
        
        if(hasCycle) {
            bw.write("-1");
        } else {
            for (int i = 2; i <= N; i++) {
                if(dist[i] == Long.MAX_VALUE) {
                    bw.write("-1\n");
                } else {
                    bw.write(dist[i] + "\n");
                }
		    }
        }
        
		bw.flush();
	}
}