import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {0, 0};
        
        Set<String> sets = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        
        int num = 0;
        for(String gem : gems) {
            sets.add(gem);
            map.put(gem, 0);
        }
        num = sets.size();
        
        if(num == 1) {
            answer[0]++;
            answer[1]++;
            return answer;
        }
        
        int cnt = 1;
        int minLen = gems.length;
        int frontIdx = 0, lastIdx = 0;
        
        map.put(gems[0], 1);
        
        for(int i = 1; i < gems.length; i++) {
            int n = map.get(gems[i]);
            if(n == 0) {
                // 새로운 숫자 들어온 경우
                map.put(gems[i], 1);
                lastIdx = i;
                cnt++;
            } else if(gems[i].equals(gems[frontIdx])) {
                // frontIdx 랑 똑같은 경우
                // lastIdx를 옮기고, frontIdx 다시 설정
                lastIdx = i;
            
                frontIdx++;
                for(int j = frontIdx; j <= i; j++) {
                    int tmp = map.get(gems[j]);
                    if(tmp - 1 >= 1) {
                        map.put(gems[j], tmp - 1);
                    } else {
                        frontIdx = j;
                        break;
                    }
                }
            } else {
                // 첫번째랑 다르고,  이미 있는 숫자인 경우
                // lastIdx는 늘리지 않고, map에 정보만 바꾼다.
                map.put(gems[i], n + 1);
            }
            
            // 짧은 구간인지 체크
            if(cnt == num && minLen > lastIdx - frontIdx) {
                minLen = lastIdx - frontIdx;
                answer[0] = frontIdx;
                answer[1] = lastIdx;
            } 
            
        }
        
        answer[0]++;
        answer[1]++;
        
        return answer;
    }
}