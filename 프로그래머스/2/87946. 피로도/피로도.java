class Solution {
    public int solution(int k, int[][] dungeons) {
        int max;
        
        for(max = dungeons.length; max > 0; max--) {
            boolean[] visited = new boolean[dungeons.length];
            if(exploreDundeon(0, max, k, dungeons, visited)) {
                break;
            }
        }
        
        return max;
    }
    
    boolean exploreDundeon(int idx, int cnt, int num, int[][] dungeons, boolean[] visited) {
        if(cnt == 0) {
            return (num < 0) ? false : true;
        }
        
        for(int i = 0 ; i < dungeons.length; i++) {
            if(visited[i] || num - dungeons[i][0] < 0) {
                continue;
            }
            
            visited[i] = true;
            if(exploreDundeon(idx + 1, cnt - 1, num - dungeons[i][1], dungeons, visited)) {
                return true;
            }
            visited[i] = false;
        }
        
        return false;
    }
}