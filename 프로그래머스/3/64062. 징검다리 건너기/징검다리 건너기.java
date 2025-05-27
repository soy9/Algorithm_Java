class Solution {
    
    boolean canJump(int mid, int[] stones, int k) {
        int cnt = 0;
        
        for(int stone : stones) {
            if(stone - mid < 0) {
                cnt++;
            } else {
                cnt = 0;
            }
            
            if(cnt == k) {
                return false;
            }
        }
        
        return true;        
    }
        
    public int solution(int[] stones, int k) {
        int min = Integer.MAX_VALUE;
        int max = 0, mid = 0;
        
        for(int stone : stones) {
            min = Math.min(min, stone);
            max = Math.max(max, stone);
        }
        
        
        while (min < max) {
            mid = (min + max + 1) / 2;
                        
            if(canJump(mid, stones, k)) {
                min = mid;            
            } else {
                max = mid - 1;
            }
        }
        
        return max;
    }
}