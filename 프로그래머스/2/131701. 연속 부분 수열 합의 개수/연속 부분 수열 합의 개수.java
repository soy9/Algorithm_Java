import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int sum = 0, idx = 0;
        int len = elements.length;
                        
        for(int start = 0; start < len; start++) {
            sum = 0;
            idx = 0;
            
            for(int i = 0; i < len; i++) {
                idx = (start + i) % len;
                
                sum += elements[idx];
                set.add(sum);
            }
        }
        return set.size();
    }
}