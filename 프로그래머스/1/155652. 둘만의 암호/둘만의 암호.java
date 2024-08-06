class Solution {
    public String solution(String s, String skip, int index) {
        char[] cArr = s.toCharArray();
        char[] skipArr = skip.toCharArray();
        boolean[] isSkip = new boolean[26];
        
        for(int i = 0; i < skip.length(); i++) {
            int tmp = skipArr[i] -'a';
            isSkip[tmp] = true;
        }
        
        for(int i = 0; i < s.length(); i++) {
            int idx = cArr[i] - 'a';
            int t = index;
            
            while(t > 0) {
                idx++;
                idx = (idx >= 26) ? (idx - 26) : idx;
                
                if(!isSkip[idx]) {
                    t--;    
                }
            }
            
            cArr[i] = (char)(idx + 'a');
            
        }
        return new String(cArr);
    }
}