import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int a = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int b = 0; b < B.length; b++) {
            if(B[b] > A[a]) {
                answer++;
                a++;
            }
        }
        
        return answer;
    }
}