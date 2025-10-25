import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        int len = numbers.length();
        int num = Integer.parseInt(numbers);
        
        int[] numArr = new int[len];
        
        
        for(int i = 0; i < len; i++) {
            int s = num % 10;
            numArr[i] = s;
            num /= 10;
        }
        
        for(int i = 1; i <= len; i++) {
            boolean[] visited = new boolean[len];
            combi(numArr, i, visited, 0);
        }
        
        answer = set.size();
        
        return answer;
    }
    
    void combi(int[] numArr, int len, boolean[] visited, int num) {
        if(len == 0) {
            if(isPrimeNum(num)) {
                set.add(num);
            } 
            return;
        }
        
        for(int i = 0; i < numArr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combi(numArr, len - 1, visited, (num * 10) + numArr[i]);
                visited[i] = false;
            }
        }
        
    }
    
    boolean isPrimeNum(int num) {
        if(num == 0 || num == 1) return false;
        
        for(int i = 2; i < num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}