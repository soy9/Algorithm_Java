class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++) {
            answer += cnt(i);
        }
        
        if(left == right) {
            answer *= 2;
        }
        return answer;
    }
    
    int cnt(int n) {
        if(n == 1) {
            return -1;
        }
        
        for(int i = 1; i <= n; i++) {
            if(i * i == n) {
                return n * (-1);
            }
        }
        
        return n;
    }
}