import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());
        
        
        for(String operation : operations) {
            String[] op = operation.split(" ");
            
            switch (op[0]) {
                case "I":
                    pq.add(Integer.valueOf(op[1]));
                    rpq.add(Integer.valueOf(op[1]));
                    break;
                case "D":
                    if(!pq.isEmpty()){
                        if(op[1].equals("1")) {
                            int temp = rpq.poll();
                            pq.remove(temp);
                        } else {
                            int temp = pq.poll();
                            rpq.remove(temp);
                        }
                        break;
                    }
            }
        }
        
        if(!pq.isEmpty()) {
            answer[0] = rpq.poll();
            answer[1] = pq.poll();
        }
        
        return answer;
    }
}