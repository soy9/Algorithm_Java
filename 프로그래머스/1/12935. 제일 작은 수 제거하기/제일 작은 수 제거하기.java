class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        if(arr.length == 1) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        } else {
            answer = new int[arr.length - 1];
        }
        
        // find min
        int minIdx = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[minIdx]) {
                minIdx = i;
            }
        }
        
        // make answer array
        int idx = 0;
        for(int i = 0; i < arr.length; i++) {
            if(i != minIdx) {
                answer[idx] = arr[i];
                idx++;
            }
        }
        
        return answer;
    }
}