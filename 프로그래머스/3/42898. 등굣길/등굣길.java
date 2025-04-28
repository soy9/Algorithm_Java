class Solution {
    // n = y축, m = x축
    public int solution(int m, int n, int[][] puddles) {
        int[] dy = {0, 1};
        int[] dx = {1, 0};
        int ny = 0, nx = 0;
        int mod = 1000000007;
        
        int[][] map = new int[n + 1][m + 1];
        
        for(int i = 0; i < puddles.length; i++) {
            map[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        map[1][1] = 1;
        for(int y = 1; y <= n; y++) {
            for(int x = 1; x <= m; x++) {
                if(map[y][x] == -1) {
                    continue;
                }
                
                for(int i = 0; i < 2; i++) {
                    ny = y + dy[i];
                    nx = x + dx[i];
                    
                    if(ny > n || nx > m || map[ny][nx] == -1) {
                        continue;
                    }
                    map[ny][nx] += map[y][x] % mod;
                    
                }
            }
        }
        
        return map[n][m] % mod;
    }
}