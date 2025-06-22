import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int[][] dist = new int[N + 1][N + 1];
        int[] scores = new int[N + 1];
        
        for(int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], N);
            dist[i][i] = 0;
        }
		
        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(a == -1 && b == -1) {
                break;
            }
            
            dist[a][b] = 1;
            dist[b][a] = 1;
        }
        //input end
                
        // 플로이드 워셜
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
                
        int cnt = 0;
        int minScore = Integer.MAX_VALUE;
        for(int from = 1; from <= N; from++){
            for(int to = 1; to <= N; to++){
                if(from == to) {
                    continue;
                }
                scores[from] = Math.max(scores[from], dist[from][to]);
            }
            
            if(minScore > scores[from]) {
                minScore = scores[from];
                cnt = 1;
                sb.setLength(0);
                sb.append(from).append(" ");
            } else if(minScore == scores[from]) {
                cnt++;
                sb.append(from).append(" ");
            }
        }
        
        // output
        System.out.println(minScore + " " + cnt);
		System.out.println(sb);
	}
}