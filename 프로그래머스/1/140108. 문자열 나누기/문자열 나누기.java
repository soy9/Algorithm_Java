class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] cArr = s.toCharArray();
        char first = cArr[0];
        int sameCnt = 0;
        int diffCnt = 0;
        
        for(int i = 0; i < cArr.length; i++) {
            if(sameCnt == diffCnt) {
                first = cArr[i];
                sameCnt = 0;
                diffCnt = 0;
                answer++;
            }
            
            if(first == cArr[i]) {
                sameCnt++;
            } else{
                diffCnt++;
            }
                
        }
        
        return answer;
    }
}