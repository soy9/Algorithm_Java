class Solution {
    public int solution(int num) {
        int answer = -1;
        long tmp = (long) num;
        
        for(int i = 0; i < 500; i++) {
            if(tmp == 1) {
                answer = i;
                break;
            }
        
            if(tmp % 2 == 0) {
                tmp /= 2;
            } else {
                tmp *= 3;
                tmp++;
            }
        }
    
        return answer;
    }
}