import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    
    static class Node{
        int y, x;
        
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
		for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
		}

        int cnt = 0;
        int S = 0;
		for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    S = Math.max(bfs(i, j), S);
                    cnt++;
                }
            }
        }

        sb.append(cnt).append("\n");
        sb.append(S);
        
		System.out.println(sb);
	}
    
    static int bfs(int y, int x) {
        int cnt = 0;
        visited[y][x] = true;
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(y, x));
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            cnt++;
            for(int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];
                
                if(ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] || map[ny][nx] == 0) {
                    continue;
                }
                
                q.add(new Node(ny, nx));
                visited[ny][nx] = true;
            }
        }
        
        return cnt;
    }

}