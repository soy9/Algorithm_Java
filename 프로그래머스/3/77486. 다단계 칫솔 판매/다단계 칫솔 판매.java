import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        int[] referralIdx = new int[referral.length];
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < referral.length; i++) {
            map.put(enroll[i], i);
        }
        
        for(int i = 0; i < referralIdx.length; i++) {
            if(referral[i].equals("-")) {
                referralIdx[i] = -1;
            } else {
                referralIdx[i] = map.get(referral[i]);
            }
        }
        
        for(int i = 0; i < seller.length; i++) {
            int sellerIdx = map.get(seller[i]);
            int nextIdx = -1;
            int posIdx = sellerIdx;
            int remain = amount[i] * 100;
             do {
                 int r = remain / 10;
                 if(r < 1) {
                     answer[posIdx] += remain;
                     break;
                 } else {
                     answer[posIdx] += remain - r;
                 }
                 remain = r;
                 nextIdx = referralIdx[posIdx];
                 posIdx = nextIdx;
            } while(nextIdx != -1);
        }
        
        return answer;
    }
}