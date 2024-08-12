class Solution {
    public String solution(String[] seoul) {
        int idx = 0;
        for(String s : seoul) {
            if(s.equals("Kim")) {
                break;
            }
            idx ++;
        }
        
        return "김서방은 " + String.valueOf(idx) +"에 있다";
    }
}