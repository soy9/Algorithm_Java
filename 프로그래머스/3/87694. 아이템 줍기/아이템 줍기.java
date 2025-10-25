import java.util.*;

class Info {
    int y, x, dist;
    Info(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}

class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map = new int[101][101];
    static boolean[][] visited = new boolean[101][101];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] rect : rectangle) {
            
            int lx = rect[0] * 2, ly = rect[1] * 2;
            int rx = rect[2] * 2, ry = rect[3] * 2;
            
            for (int y = ly; y <= ry; y++) {
                for (int x = lx; x <= rx; x++) {
                    
                    if (x == lx || x == rx || y == ly || y == ry) {
                        if (map[y][x] == -1) continue;
                        map[y][x] = 1;
                    } else {
                        map[y][x] = -1;
                    }
                    
                }
            }
        }
        
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }
    
    int bfs(int sx, int sy, int tx, int ty) {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(sy, sx, 0));
        visited[sy][sx] = true;
        
        while (!q.isEmpty()) {
            Info cur = q.poll();
            if (cur.x == tx && cur.y == ty) return cur.dist;
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (nx < 0 || ny < 0 || nx > 100 || ny > 100) continue;
                if (visited[ny][nx] || map[ny][nx] != 1) continue;
                
                visited[ny][nx] = true;
                q.add(new Info(ny, nx, cur.dist + 1));
            }
        }
        return -1;
    }
}
