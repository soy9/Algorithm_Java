import java.io.*;
import java.util.*;

public class Main {
	static int N;
    static int D;
	static int[] dist;
	static int[] hasRode;
    
    static class Rode {
        int from;
        int to;
        int dist;
        
        public Rode (int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
        
        int[] dist = new int[D + 1];
        int[] hasRode = new int[D + 1];
        PriorityQueue<Rode> pq = new PriorityQueue<>((o1, o2) -> o1.from - o2.from);
     
        for(int i = 0; i <= D; i++) {
            dist[i] = i;
        }
        
		for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            if(d >= to - from || to > D) {
                continue;
            }
            pq.add(new Rode(from, to, d));
            hasRode[from]++;
		}
        
        for(int i = 0; i <= D; i++) {
            if(i > 0) {
                dist[i] = Math.min(dist[i], dist[i - 1] + 1);
            }
            
            for(int j = 0; j < hasRode[i]; j++) {
                Rode rode = pq.poll();
                dist[rode.to] = Math.min(dist[rode.to], dist[rode.from] + rode.dist);
            }
        }
        
		System.out.print(dist[D]);
	}

}