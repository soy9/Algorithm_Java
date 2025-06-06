import java.util.*;

class Score implements Comparable<Score> {
    int a;
    int b;
    int sum;
    
    Score (int a, int b) {
        this.a = a;
        this.b = b;
        this.sum = a + b;
    }
    
    @Override
    public int compareTo(Score o) {
        return this.sum - o.sum;
    }
}

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int sum = scores[0][0] + scores[0][1];
        ArrayList<Score> list = new ArrayList<>();
        
        for(int i = 1; i < scores.length; i++) {
            if(scores[i][0] > scores[0][0] && scores[i][1] > scores[0][1]) {
                return -1;
            }
            
            if(scores[i][0] + scores[i][1] > sum) {
                list.add(new Score(scores[i][0], scores[i][1]));
                answer++;
            }
        }
        
        Collections.sort(list);
        
        for(int i = 0; i < list.size() - 1; i++) {
            for(int j = i + 1; j < list.size(); j++) {
                if(list.get(i).a < list.get(j).a && list.get(i).b < list.get(j).b) {
                    answer--;
                    break;
                }
            }
        }
                
        return answer;
    }
}