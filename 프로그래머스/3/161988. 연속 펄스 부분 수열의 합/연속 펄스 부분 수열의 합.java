class Solution {
    public long solution(int[] sequence) {
        long answer = (sequence[0] > - sequence[0]) ? sequence[0] : - sequence[0];
        
        long[][] psum = new long[2][sequence.length];
        int[] minIdx = new int[2]; 
        int[] maxIdx = new int[2];
        
        psum[0][0] = sequence[0];
        psum[1][0] = - sequence[0];
        
        for(int i = 1; i < sequence.length; i++) {
            if(i % 2 == 1) {
                psum[0][i] = psum[0][i - 1] - sequence[i];
                psum[1][i] = psum[1][i - 1] + sequence[i];
            } else {
                psum[0][i] = psum[0][i - 1] + sequence[i];
                psum[1][i] = psum[1][i - 1] - sequence[i];
            }
            
            for(int j = 0; j <= 1; j++) {
                minIdx[j] = (psum[j][minIdx[j]] <= psum[j][i]) ? minIdx[j] : i;
                maxIdx[j] = (psum[j][maxIdx[j]] > psum[j][i]) ? maxIdx[j] : i;
                
                if(maxIdx[j] > minIdx[j]) {
                    long temp = psum[j][maxIdx[j]] - psum[j][minIdx[j]];
                    temp = (temp > psum[j][maxIdx[j]]) ? temp : psum[j][maxIdx[j]];
                    answer = (answer > temp) ? answer : temp;
                }
            }
        }
        
        return answer;
    }
}