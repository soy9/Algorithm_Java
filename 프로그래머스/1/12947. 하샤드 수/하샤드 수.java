class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int num = x;
        int sum = 0;
        
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
                
        answer = (x % sum == 0) ? true : false;
        
        return answer;
    }
}