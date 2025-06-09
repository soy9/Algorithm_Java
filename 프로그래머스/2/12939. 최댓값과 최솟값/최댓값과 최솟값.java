class Solution {
    public String solution(String s) {
        String[] sArr = s.split(" ");
        
        int temp = Integer.valueOf(sArr[0]);
        int min = temp;
        int max = temp;
        
        for(int i = 0; i < sArr.length; i++) {
            temp = Integer.valueOf(sArr[i]);
            min = Math.min(min, temp);
            max = Math.max(max, temp);
        }
        
        return min + " " + max;
    }
}