class Solution {
    public int solution(String s) {
        int answer = 1;
        
        for(int i = 0; i < s.length() - 1; i++) {
            for(int j = i + 1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    int len = checkPalindrome(s, i, j);
                    answer = Math.max(answer, len);
                }
            }
            
            if(i + answer >= s.length()) {
                break;
            }
        }

        return answer;
    }
    
    int checkPalindrome(String s, int first, int last) {
        int len = last - first + 1;
        int mid = (first + last) / 2;
        
        for(int i = 0; i <= mid - first; i++) {
            if(s.charAt(first + i) != s.charAt(last - i)) {
                len = 0;
                break;
            }
        }
        
        return len;
    }
}