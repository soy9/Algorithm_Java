import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        
        long answer = times[times.length - 1] * n;
        long start = times[0];
        long end = (long) times[times.length - 1] * n;
        long mid;
        
        while(start <= end) {
            long sum = 0;
            mid = (start + end) / 2; 
            
            for(int time : times) {
                sum += mid / time;
            }
            
            if(sum >= n) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
}