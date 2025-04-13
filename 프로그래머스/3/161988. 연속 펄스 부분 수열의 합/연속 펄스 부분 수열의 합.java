class Solution {
    long findMax(int n, int[] sequence){
        long[] psum = new long[sequence.length + 1];
        long answer = 0;
        
        int maxIdx = 0;
        int minusLastIdx = 0;
        
        psum[0] = 0;
        for(int i = 1; i <= sequence.length; i++){
            if(i % 2 == n) {
                psum[i] = psum[i - 1] + (sequence[i - 1] * (-1));
            } else {
                psum[i] = psum[i - 1] + sequence[i - 1];
            }
            
            if(psum[maxIdx] < psum[i]) {
                maxIdx = i;
                answer = psum[maxIdx] - psum[minusLastIdx];
            }
            
            if(psum[i] <= psum[minusLastIdx]) {
                minusLastIdx = i;
            }
        }
        
        return answer;
    }
    
    
    public long solution(int[] sequence) {
        long answer1 = 0;
        long answer2 = 0;
        
        answer1 = findMax(0, sequence);
        answer2 = findMax(1, sequence);

        return (answer1 > answer2) ? answer1 : answer2;
    }
}