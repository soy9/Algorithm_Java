import java.util.*;

class Rode {
    int y;
    int x;
    int cost;
    int dir;
    
    Rode (int y, int x, int dir, int cost) {
        this.y = y;
        this.x = x;
        this.dir = dir;
        this.cost = cost;
    }
}

class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;
    boolean[][] visited;
    int[][][] costArr;
    int N;
    
    void bfs(int[][] board, int x, int y, int dir, int cost) {
        Queue<Rode> q = new LinkedList<Rode>();
        q.add(new Rode(y, x, dir, cost));
        
        while(!q.isEmpty()) {
            Rode r = q.poll();
            
            if (r.y == N - 1 && r.x == N - 1) {
                answer = Math.min(answer, r.cost);
            }
            
            for(int i = 0; i < 4; i++) {
                int ny = r.y + dy[i];
                int nx = r.x + dx[i];
                int ncost = r.cost;
                
                if(ny >= N || ny < 0 || nx >= N || nx < 0 || board[ny][nx] == 1) {
                    continue;
                }
                
                if(r.dir == -1 || r.dir == i) {
                    ncost += 100;
                } else {
                    ncost += 600;
                }
                
                if(!visited[ny][nx] || costArr[ny][nx][i] >= ncost) {
                    visited[ny][nx] = true;
                    costArr[ny][nx][i] = ncost;
                    
                    q.add(new Rode(ny, nx, i, ncost));
                } 
            }
        }
    }
    
    public int solution(int[][] board) {
        visited = new boolean[board.length][board.length];
        costArr = new int[board.length][board.length][4];
        N = board.length;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                Arrays.fill(costArr[i][j], Integer.MAX_VALUE);
            }
        }
        visited[0][0] = true;
        bfs(board, 0, 0, -1, 0);
                
        return answer;
    }
}