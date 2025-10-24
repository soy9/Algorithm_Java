class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
                
        answer = bfs(numbers, 0, target, 0);
        
        return answer;
    }
    
    int bfs(int[] numbers, int idx, int target, int num) {
        int cnt = 0;
        
        if(idx == numbers.length) {
            if(target == num) {
                return 1;
            } else {
                return 0;
            }
        }
        
        cnt += bfs(numbers, idx + 1, target, num + numbers[idx]);
        cnt += bfs(numbers, idx + 1, target, num - numbers[idx]);
        
        return cnt;
    }
}