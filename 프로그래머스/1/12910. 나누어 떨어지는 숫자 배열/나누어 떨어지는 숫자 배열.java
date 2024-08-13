import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = null;
        List<Integer> list = new ArrayList<>();
        
        for(int num : arr){
            if(num % divisor == 0) {
                list.add(num);
            }
        }
        
        if(list.size() > 0) {
            Collections.sort(list);
            answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        } else {
            answer = new int[1];
            answer[0] = -1;
        }
        
        return answer;
    }
}