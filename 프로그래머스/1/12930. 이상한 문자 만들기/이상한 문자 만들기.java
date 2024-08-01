class Solution {
    public String solution(String s) {
        char[] carr = s.toCharArray();
        int idx = 0;
        
        for(int i = 0; i < carr.length; i++){
            if(carr[i] == ' ') {
                idx = 0;
                continue;
            }
            
            carr[i] = (idx % 2 == 0) ? Character.toUpperCase(carr[i]) : Character.toLowerCase(carr[i]);
            idx++;
        }
        
        return String.valueOf(carr);
    }
}