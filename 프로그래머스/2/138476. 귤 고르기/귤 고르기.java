import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            if(map.containsKey(tangerine[i])) {
                int n = map.get(tangerine[i]);
                map.put(tangerine[i], n + 1);
            } else {
                map.put(tangerine[i], 1);
            }
        }
        
        List<Integer> listKeySet = new ArrayList<>(map.keySet());
        
        // value 기준으로 내림차순 정렬
        Collections.sort(listKeySet, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));
		for(Integer key : listKeySet) {
            sum += map.get(key);
            answer++;
            if(sum >= k) {
                break;
            }
		}
        
        return answer;
    }
}