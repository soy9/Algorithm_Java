import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        
        
        List<String> dictionary = new ArrayList<>();
        
        for(int i = 1; i <= 5; i++) {
            combi(i, dictionary, "");
        }
        
        Collections.sort(dictionary);
        
        for(int i = 0; i < dictionary.size(); i++) {
            if(dictionary.get(i).equals(word)) {
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
    
    void combi(int len, List<String> dictionary, String word) {
        if(len == 0) {
            dictionary.add(word);
            return;
        }
        
        String[] str = {"A", "E", "I", "O", "U"};
        
        for(int i = 0; i < 5; i++) {
            combi(len - 1, dictionary, word + str[i]);
        }
    }
}