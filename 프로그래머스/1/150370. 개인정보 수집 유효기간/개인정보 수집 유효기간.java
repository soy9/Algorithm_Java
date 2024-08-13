import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        // List<Integer> list = new ArrayList<>();
        int DATE_LEN = 10;
   
        int todayDate = Integer.parseInt(today.replace(".", ""));
   
        // termsMap : 약관, 기간 
        HashMap<String, Integer> termsMap = new HashMap<>();
        
        // 약관 별 유효기간 정보 저장
        for(String term : terms) {
            String[] tmp = term.split(" ");
            termsMap.put(tmp[0], Integer.parseInt(tmp[1]));
        }
        
        int idx = 1;
        // 개인정보
        for(String privacy : privacies) {
            // 날짜
            String[] info = privacy.split(" ");
            String[] days = info[0].split("\\.");
                        
            // 파기일 계산하기
            int endYear = Integer.parseInt(days[0]);
            int endMonth = Integer.parseInt(days[1]) + termsMap.get(info[1]);
            
            if(endMonth > 12) {
                int addYear = endMonth / 12;
                endMonth %= 12;
                if(endMonth == 0) {
                    endMonth = 12;
                    addYear --;
                }
                endYear += addYear;
            }
            
            // 오늘 날짜와 비교하기
            int endDate = (endYear*10000) + (endMonth*100) + Integer.parseInt(days[2]);
            
            if(endDate <= todayDate) {
                answer.add(idx);
            }
            idx++;
        }
        
//         // 오름차순 정렬
//         Collections.sort(list);
//         answer = new int[list.size()];
//         for(int i = 0; i < list.size(); i++) {
//             answer[i] = list.get(i);
//         }
        
        return answer.stream().mapToInt(integer -> integer).toArray();
    }
}