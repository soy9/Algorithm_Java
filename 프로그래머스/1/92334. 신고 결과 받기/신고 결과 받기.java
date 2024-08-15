import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> map = new HashMap<>();
        boolean[][] doReport = new boolean[id_list.length][id_list.length];    // [from][to]
        int[] cnt = new int[id_list.length];    // 신고받은 횟수
                
        for(int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], i);
        }
        
        for(String r : report) {
            String[] str = r.split(" ");
            int from = map.get(str[0]);
            int to = map.get(str[1]);
            
            if(!doReport[from][to]){
                doReport[from][to] = true;
                ++cnt[to];
            }
        }
        
        for(int i = 0; i < id_list.length; i++) {
            if(cnt[i] >= k) {
                for(int j = 0; j < id_list.length; j++) {
                    if(doReport[j][i]) {
                        answer[j]++;
                    }
                }
            }
        }
        
        return answer;
    }
}