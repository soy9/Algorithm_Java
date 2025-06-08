class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        
        int temp = a[0];
        leftMin[0] = temp;
        for(int i = 1; i < a.length; i++) {
            temp = Math.min(temp, a[i]);
            leftMin[i] = temp;
        }
        
        temp = a[a.length - 1];
        rightMin[a.length - 1] = temp;
        for(int i = a.length - 2; i >= 0; i--) {
            temp = Math.min(temp, a[i]);
            rightMin[i] = temp;
        }
        
        for(int i = 0; i < a.length; i++) {
            if(a[i] > leftMin[i] && a[i] > rightMin[i]) {
                continue;
            }
            answer ++;
        }
        
        return answer;
    }
    
}