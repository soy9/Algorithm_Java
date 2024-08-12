class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if(a == b) {
            return (long) a;
        }
        
        // 둘 부호가 달라
        long min = Math.min(a, b);
        long max = Math.max(a, b);
        
        if(min <= 0 && max >= 0) {
            
            min *= -1;
            min = min * (min + 1) / 2 * (-1);
            max = max * (max + 1) / 2;
            
            answer = max + min;
        } else{
            // 부호가 같아.
                
            if(min < 0) {
                min *= -1;
                max *= -1;
                
                long tmpMin = Math.min(min, max);
                min = min * (min + 1) / 2;
                max = max * (max + 1) / 2;
                answer = max - min - tmpMin;
            } else{
                long tmpMin = Math.min(min, max);
                min = min * (min + 1) / 2;
                max = max * (max + 1) / 2;
                answer = max - min + tmpMin;
            }
            
        }
        return answer;
    }
}