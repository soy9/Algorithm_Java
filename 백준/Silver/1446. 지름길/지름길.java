import java.io.*;
import java.util.*;

public class Main {
    static class Rode {
        int to;
        int dist;
        
        public Rode (int to, int dist) {
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
        for (int i = 0; i <= D; i++) {
            dist[i] = i;
        }
        
        List<Rode>[] shortCuts = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) {
            shortCuts[i] = new ArrayList<>();
        }
        
		for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            if(d >= to - from || to > D) {
                continue;
            }
            shortCuts[from].add(new Rode(to, d));
		}

        for(int i = 0; i <= D; i++) {
            if(i > 0) {
                dist[i] = Math.min(dist[i], dist[i - 1] + 1);
            }
            for(Rode rode : shortCuts[i]) {
                dist[rode.to] = Math.min(dist[rode.to], dist[i] + rode.dist);
            }
        }
        
		System.out.print(dist[D]);
	}

}