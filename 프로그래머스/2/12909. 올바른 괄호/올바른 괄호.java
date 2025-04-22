class Solution {
    boolean solution(String s) {
        int openCnt = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                openCnt++;
            } else {
                if(--openCnt < 0) {
                    break;
                }
            }
        }

        return openCnt == 0 ? true : false;
    }
}