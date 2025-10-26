import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int answerH = 0;
        
        Arrays.sort(citations);
        
        if(n < citations[0]) {
            return n;
        }
        
        boolean found = false;
        for(int i = 0; i < n - 1; i++) {
            if(n - i < citations[i]) {
                break;
            }
            if(n - i < citations[i] || i > citations[i]) {
                break;
            }
            answerH = citations[i];
            for(int h = citations[i] + 1; h < citations[i + 1]; h++) {
                if(n - i - 1 < h || i > h) {
                    found = true;
                    break;
                }
                answerH = h;
                
            }
            if(found) {
                break;
            }
        }
        
        return answerH ;
    }
}